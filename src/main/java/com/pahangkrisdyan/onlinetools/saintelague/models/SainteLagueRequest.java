package com.pahangkrisdyan.onlinetools.saintelague.models;

public class SainteLagueRequest {

    private Long[] votes;
    private Integer seat;

    public SainteLagueRequest() {
    }

    public SainteLagueRequest(Long[] votes, Integer seat) {
        this.votes = votes;
        this.seat = seat;
    }

    public Long[] getVotes() {
        return votes;
    }

    public void setVotes(Long[] votes) {
        this.votes = votes;
    }

    public Integer getSeat() {
        return seat;
    }

    public void setSeat(Integer seat) {
        this.seat = seat;
    }
}
