package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.Cert;
import com.certranker.CertRankerBackend.entities.LearningResource;
import com.certranker.CertRankerBackend.entities.Vote;
import com.certranker.CertRankerBackend.repositories.CertRepository;
import com.certranker.CertRankerBackend.repositories.VoteRepository;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

    private final VoteRepository voteRepository;
    private final CertRepository certRepository;

    public VoteServiceImpl(VoteRepository voteRepository, CertRepository certRepository) {
        this.voteRepository = voteRepository;
        this.certRepository = certRepository;
    }

    @Override
    public void castVote(String userId, String resourceId, boolean upvote) {
        Vote existingVote = voteRepository.findByUserIdAndResourceId(userId, resourceId);
        Cert cert = certRepository.findById(resourceId).orElseThrow(() -> new RuntimeException("Certification not found"));

        if (existingVote != null) {
            // If changing vote type, adjust counts accordingly
            adjustVoteCounts(existingVote, cert, resourceId, upvote);
        } else {
            // New vote
            Vote newVote = new Vote(null, userId, resourceId, upvote ? "upvote" : "downvote");
            voteRepository.save(newVote);
            adjustResourceVotes(cert, resourceId, upvote,1);
        }

        certRepository.save(cert);
    }

    @Override
    public void adjustVoteCounts(Vote vote, Cert cert, String resourceId, boolean upvote) {
        boolean isUpvote = vote.getVoteType().equals("upvote");
        if (isUpvote != upvote) {
            vote.setVoteType(upvote ? "upvote" : "downvote");
            voteRepository.save(vote);
            adjustResourceVotes(cert, resourceId, upvote, 1);
            adjustResourceVotes(cert, resourceId, !upvote, -1);
        }
    }

    @Override
    public void adjustResourceVotes(Cert cert, String resourceId, boolean upvote, int increment) {
        LearningResource resource = cert.getLearningResourceList().stream()
                .filter(r -> r.getId().equals(resourceId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        if (upvote) {
            resource.getVotes().setUpvotes(resource.getVotes().getUpvotes() + increment);
        } else {
            resource.getVotes().setDownvotes(resource.getVotes().getDownvotes() + increment);
        }
    }
}
