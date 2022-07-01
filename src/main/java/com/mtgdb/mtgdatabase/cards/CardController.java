package com.mtgdb.mtgdatabase.cards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//API Layer
@RestController
@RequestMapping(path = "api/v1/card")
public class CardController {

    @Autowired
    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService){
        this.cardService = cardService;
    }

    @GetMapping
    public List<Card> getCards(){
        return cardService.getCards();
    }

    @PostMapping
    public void registerNewCard(@RequestBody Card card){
        cardService.addNewCard(card);
    }

    @DeleteMapping(path = "{cardId}")
    public void deleteCard(@PathVariable("cardId") Long cardId){
        cardService.deleteCard(cardId);
    }

    @PutMapping(path = "{cardId}")
    public void updateCard(
            @PathVariable("cardId") Long cardId,
            @RequestParam(required = false) String name) {
                cardService.updateCard(cardId, name);

    }
}
