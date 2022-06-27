package com.mtgdb.mtgdatabase.cards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Optional;

//data access layer
@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT s FROM Card s WHERE s.name = ?1")
    Optional<Card> findCardById(Long cardId);

}
