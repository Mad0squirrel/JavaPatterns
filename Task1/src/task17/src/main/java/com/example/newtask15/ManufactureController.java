package com.example.newtask15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/manufactures")
public class ManufactureController {
    private final ManufactureDriver driver;

    @Autowired
    public ManufactureController(ManufactureDriver driver) {
        this.driver = driver;
    }


    @GetMapping(value="")
    public ResponseEntity<List<Manufacture>> read() {
        final List<Manufacture> manufactures = driver.readAll();
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Manufacture> read(@PathVariable(name="id") long id) {
        final Manufacture manufacture = driver.read(id);
        return manufacture != null
                ? new ResponseEntity<>(manufacture, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value="/code/{code}")
    public ResponseEntity<List<Manufacture>> findManufacturesByCode(@PathVariable(name="code") int code) {
        final List<Manufacture> manufactures = driver.findManufacturesByCode(code);
        return manufactures != null && !manufactures.isEmpty()
                ? new ResponseEntity<>(manufactures, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
