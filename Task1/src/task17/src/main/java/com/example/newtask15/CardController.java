package com.example.newtask15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/cards")
public class CardController {
    private final CardDriver driver;

    @Autowired
    public CardController(CardDriver driver) {
        this.driver = driver;
    }


    @GetMapping(value="")
    public ResponseEntity<List<Card>> read() {
        final List<Card> phones = driver.readAll();
        return phones != null && !phones.isEmpty()
                ? new ResponseEntity<>(phones, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Card> read(@PathVariable(name="id") long id) {
        final Card phone = driver.read(id);
        return phone != null
                ? new ResponseEntity<>(phone, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/code/{code}")
    public ResponseEntity<List<Card>> findCardsByCode(@PathVariable(name="code") int code) {
        final List<Card> cards = driver.findCardsByCode(code);
        return cards != null && !cards.isEmpty()
                ? new ResponseEntity<>(cards, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
