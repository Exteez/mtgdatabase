package com.mtgdb.mtgdatabase.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository){
        this.cardRepository = cardRepository;
    }
    public List<Card> getCards(){
        return cardRepository.findAll();
    }

    public void addNewCard(Card card){
        Optional<Card> cardOptional = cardRepository.findCardById(card.getId());
        if(cardOptional.isPresent()){
            throw new IllegalStateException("CardID is already taken");
        }
        cardRepository.save(card);
    }

    public void deleteCard(Long cardId){
        boolean exists = cardRepository.existsById(cardId);
        if(!exists){
            throw new IllegalStateException(("Card with the id " + cardId + " does not exist."));
        }
        cardRepository.deleteById(cardId);
    }

    //TODO
    @Transactional
    public void updateCard(Long cardName, String name) {
    }

}
