package com.pahangkrisdyan.onlinetools.saintelague.models;

import java.util.List;
import java.util.stream.Collectors;

public class SainteLagueResponse {

    private final List<Quotient> quotients;
    private final Integer seat;

    public SainteLagueResponse(List<Quotient> quotients, Integer seat) {
        this.quotients = quotients;
        this.seat = seat;
    }

    public List<Quotient> getQuotients() {
        return quotients;
    }

    public Integer getSeat() {
        return seat;
    }

    public List<Integer> getSeats() {
        return quotients.stream()
                .filter(Quotient::getGainSeat)
                .collect(Collectors.groupingBy(Quotient::getPartyIndex))
                .values().stream().map(List::size)
                .toList();
    }
}
