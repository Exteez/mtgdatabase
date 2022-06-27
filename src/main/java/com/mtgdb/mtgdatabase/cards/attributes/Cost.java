package com.mtgdb.mtgdatabase.cards.attributes;

public enum Cost {
    X (0, "none"), ONE (1, "none"), TWO (2, "none"), THREE (3, "none"), FOUR (4, "none"),
    FIVE (5, "none"), SIX (6, "none"), NONE (0, "none"), W (1, "white"), U (1, "blue"),
    B (1, "black"), R (1, "red"), G (1, "green"), ZERO (0, "none"), ;

    public final int manaAsValue;
    public final String colorOfMana;


    Cost(int manaAsValue, String colorOfMana) {
        this.manaAsValue = manaAsValue;
        this.colorOfMana = colorOfMana;
    }

}
