package com.certranker.CertRankerBackend.entities;

public class Votes {
    private int upvotes;
    private int downvotes;

    public Votes() {}

    public Votes(int upvotes, int downvotes) {
        this.upvotes = upvotes;
        this.downvotes = downvotes;
    }

    public int getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(int upvotes) {
        this.upvotes = upvotes;
    }

    public int getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(int downvotes) {
        this.downvotes = downvotes;
    }
}
