package com.pahangkrisdyan.onlinetools.saintelague.models;

public class Quotient {

    private final Double value;
    private final Integer partyIndex;
    private final Integer denominator;
    private Boolean isGainSeat;

    public Quotient(Double value, Integer partyIndex, Integer denominator) {
        this.value = value;
        this.partyIndex = partyIndex;
        this.denominator = denominator;
    }

    public Quotient(Double value, Integer partyIndex, Integer denominator, Boolean isGainSeat) {
        this.value = value;
        this.partyIndex = partyIndex;
        this.denominator = denominator;
        this.isGainSeat = isGainSeat;
    }

    public Double getValue() {
        return value;
    }

    public Integer getPartyIndex() {
        return partyIndex;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public Boolean getGainSeat() {
        return isGainSeat;
    }

    public void setGainSeat(Boolean gainSeat) {
        isGainSeat = gainSeat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quotient quotient = (Quotient) o;

        if (this.value.compareTo((quotient.value)) != 0) return false;
        if (!this.partyIndex.equals(((Quotient) o).getPartyIndex())) return false;
        if (!this.denominator.equals(((Quotient) o).getDenominator())) return false;
        return this.isGainSeat.equals(((Quotient) o).getGainSeat());
    }
}
