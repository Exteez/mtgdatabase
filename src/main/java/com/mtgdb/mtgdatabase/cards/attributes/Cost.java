package com.mtgdb.mtgdatabase.cards.attributes;

public enum Cost {
    X (0), ONE (1), TWO (2), THREE (3), FOUR (4),
    FIVE (5), SIX (6), NONE (0), W (1), U (1),
    B (1), R (1), G (1), ZERO (0), ;

    public final int manaAsValue;

    Cost(int manaAsValue) {
        this.manaAsValue =manaAsValue;
    }
}
