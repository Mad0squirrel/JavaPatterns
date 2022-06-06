package com.example.newtask15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {
    private final Driver<Card> cardDriver;

    @Autowired
    public CardController(Driver<Card> cardDriver) {
        this.cardDriver = cardDriver;
    }
    @PostMapping(value="/cards")
    public ResponseEntity<?> create(@RequestBody Card card){
        cardDriver.create(card);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value="/cards")
    public ResponseEntity<List<Card>> read() {
        final List<Card> cards = cardDriver.readAll();
        return cards != null && !cards.isEmpty()
                ? new ResponseEntity<>(cards, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/cards/{id}")
    public ResponseEntity<Card> read(@PathVariable(name="id") long id) {
        final Card card = cardDriver.read(id);
        return card != null
                ? new ResponseEntity<>(card, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value="/cards/{id}")
    public ResponseEntity<?> update(@PathVariable(name="id") long id, @RequestBody Card card) {
        final boolean updated = cardDriver.update(card, id);
        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value="/cards/{id}")
    public ResponseEntity<?> delete(@PathVariable(name="id") long id) {
        final boolean deleted = cardDriver.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

}
