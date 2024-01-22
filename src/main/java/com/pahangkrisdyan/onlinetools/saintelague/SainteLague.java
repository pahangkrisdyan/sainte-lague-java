package com.pahangkrisdyan.onlinetools.saintelague;

import com.pahangkrisdyan.onlinetools.saintelague.models.Quotient;
import com.pahangkrisdyan.onlinetools.saintelague.models.SainteLagueRequest;
import com.pahangkrisdyan.onlinetools.saintelague.models.SainteLagueResponse;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;

public class SainteLague implements Function<SainteLagueRequest, SainteLagueResponse> {

    @Override
    public SainteLagueResponse apply(SainteLagueRequest request) {
        final Integer seat = request.getSeat();
        final Long[] votes = request.getVotes();

        final int denominations = seat == 0 ? 0 : (int) Math.ceil((Math.sqrt(8 * seat + 1) - 1) / 2);

        List<Quotient> quotients = IntStream.range(0, votes.length)
                .boxed()
                .flatMap(i -> IntStream.rangeClosed(1, denominations * 2).filter(n -> n % 2 != 0)
                        .mapToObj(denominator -> new Quotient(votes[i] / (double) denominator, i, denominator, false)))
                .sorted(Comparator.comparingDouble(Quotient::getValue).reversed())
                .toList();

        quotients.stream().limit(seat).forEach(q -> q.setGainSeat(true));

        return new SainteLagueResponse(quotients, seat);
    }

}
