package com.mtgdb.mtgdatabase.cards;

import com.mtgdb.mtgdatabase.cards.attributes.Cost;
import com.mtgdb.mtgdatabase.cards.attributes.SubType;
import com.mtgdb.mtgdatabase.cards.attributes.SuperType;
import com.mtgdb.mtgdatabase.cards.attributes.Type;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;


@Configuration
public class CardConfig {

    @Bean
    CommandLineRunner commandLineRunner(CardRepository repository){
        return args -> {
            Card card = new Card(
                    "Kess, Dissident Mage",
                    List.of(Cost.ONE, Cost.U, Cost.B, Cost.R),
                    List.of(SuperType.LEGENDARY),
                    List.of(Type.CREATURE),
                    List.of(SubType.HUMAN, SubType.WIZARD),
                    " Flying. Once during each of your turns, you may cast an instant or sorcery spell from your graveyard." +
                            " If a spell cast this way would be put into your graveyard, exile it instead.",
                    3,
                    4
            );
            repository.saveAll(
                    List.of(card)
            );
        };
    }

}
