package com.mtgdb.mtgdatabase.cards;

import com.mtgdb.mtgdatabase.cards.attributes.Cost;
import com.mtgdb.mtgdatabase.cards.attributes.SubType;
import com.mtgdb.mtgdatabase.cards.attributes.SuperType;
import com.mtgdb.mtgdatabase.cards.attributes.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;

public class CardConfig {
    //name, cost, supert, type, subt, text, p/t

    Card card = new Card(
            "Kess, Dissident Mage",
            List.of(Cost.ONE, Cost.U, Cost.B, Cost.R),
            List.of(SuperType.NONE),
            List.of(Type.CREATURE),
            List.of(SubType.HUMAN, SubType.WIZARD),
            " Flying. Once during each of your turns, you may cast an instant or sorcery spell from your graveyard." +
            " If a spell cast this way would be put into your graveyard, exile it instead.",
            3,
            4
            );


}
