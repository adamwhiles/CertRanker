package com.certranker.CertRankerBackend.services;

import com.certranker.CertRankerBackend.entities.Cert;
import com.certranker.CertRankerBackend.entities.Vote;

public interface VoteService {
    void castVote(String userId, String resourceId, boolean upvote);
    void adjustVoteCounts(Vote vote, Cert cert, String resourceId, boolean upvote);
    void adjustResourceVotes(Cert cert, String resourceId, boolean upvote, int increment);
}
