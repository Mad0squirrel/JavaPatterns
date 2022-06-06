package com.example.newtask15.services;

import com.example.newtask15.Card;
import com.example.newtask15.CardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CardService {
    private CardRepository cardRepository;

    @Autowired
    CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public void create(Card card) {
        log.info("Create cards {}", card);
        cardRepository.save(card);
    }

    public List<Card> readAll() {
        log.info("Read all cards");
        return cardRepository.findAll();
    }

    public Card read(long id) {
        log.info("Read by id = {}", id);
        return cardRepository.getById(id);
    }

    public boolean update(Card card, long id) {
        log.info("Update card by id = {}", id);
        card.setId(id);
        cardRepository.save(card);
        return true;
    }

    public boolean delete(long id) {
        log.info("Delete card by id = {}", id);
        cardRepository.deleteById(id);
        return true;
    }

    public List<Card> findCardsByCode(int code) {
        log.info("Find cards by code = {}", code);
        return cardRepository.findAllByCode(code);
    }
}
