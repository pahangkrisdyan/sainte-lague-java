package com.pahangkrisdyan.onlinetools.saintelague;

import com.pahangkrisdyan.onlinetools.saintelague.models.Quotient;
import com.pahangkrisdyan.onlinetools.saintelague.models.SainteLagueRequest;
import com.pahangkrisdyan.onlinetools.saintelague.models.SainteLagueResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class SainteLagueResponseTest {

    private SainteLague sainteLague;

    @BeforeEach
    void setUp() {
        sainteLague = new SainteLague();
    }

    @ParameterizedTest
    @MethodSource("provideTestCases")
    void apply_CorrectResponses_TestCases(SainteLagueRequest request, SainteLagueResponse expectedResponse) {
        // Act
        SainteLagueResponse response = sainteLague.apply(request);

        // Assert
        assertEquals(expectedResponse.getSeat(), expectedResponse.getSeat());
        assertEquals(expectedResponse.getSeats(), expectedResponse.getSeats());
        assertIterableEquals(expectedResponse.getQuotients(), response.getQuotients());
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(
                        new SainteLagueRequest(new Long[]{ 100000L, 80000L, 30000L, 20000L}, 8),
                        new SainteLagueResponse(Arrays.asList(
                                new Quotient(100000D, 0, 1, true),
                                new Quotient(80000D, 1, 1, true),
                                new Quotient(33333.333333333336D, 0, 3, true),
                                new Quotient(30000D, 2, 1, true),
                                new Quotient(26666.666666666668D, 1, 3, true),
                                new Quotient(20000D, 0, 5, true),
                                new Quotient(20000D, 3, 1, true),
                                new Quotient(16000D, 1, 5, true),
                                new Quotient(14285.714285714286D, 0, 7, false),
                                new Quotient(11428.57142857143D, 1, 7,false),
                                new Quotient(10000D, 2, 3,false),
                                new Quotient(6666.666666666667D, 3, 3,false),
                                new Quotient(6000D, 2, 5, false),
                                new Quotient(4285.714285714285D, 2, 7, false),
                                new Quotient(4000D, 3, 5, false),
                                new Quotient(2857.1428571428573D, 3, 7, false)
                        ), null)
                )
        );
    }
}