package com.driver;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pg")
public class PGRentController {

    private final Map<Integer, PGDetails> pgStore = new HashMap<>();
    private static int pgIDCounter = 1;

    @PostMapping("/register")
    public ResponseEntity<String> registerPG(@RequestBody PGDetailsRequest pgDetailsRequest) {
        PGDetails details = new PGDetails(pgIDCounter++, pgDetailsRequest.getName(),
                pgDetailsRequest.getRent(), pgDetailsRequest.getRooms());
        pgStore.put(details.getId(), details);

        return new ResponseEntity<>("Registered PG with ID: " + details.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/updateRent/{id}")
    public ResponseEntity<String> updateRent(@PathVariable int id, @RequestBody RentUpdateRequest rentUpdateRequest) {
        PGDetails details = pgStore.get(id);
        if (details == null) {
            throw new PGNotFoundException("PG with ID " + id + " not found.");
        }
        details.setRent(rentUpdateRequest.getRent());
        return new ResponseEntity<>("Updated PG with ID: " + id, HttpStatus.OK);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<PGDetails> fetchDetails(@PathVariable int id) {
        PGDetails details = pgStore.get(id);
        if (details == null) {
            throw new PGNotFoundException("PG with ID " + id + " not found.");
        }
        return new ResponseEntity<>(details, HttpStatus.OK);
    }

    @GetMapping("/annualIncome/{id}")
    public ResponseEntity<Double> annualIncome(@PathVariable int id) {
        PGDetails details = pgStore.get(id);
        if (details == null) {
            throw new PGNotFoundException("PG with ID " + id + " not found.");
        }
        return new ResponseEntity<>(details.getRent() * 12, HttpStatus.OK);
    }

    @ExceptionHandler(PGNotFoundException.class)
    public ResponseEntity<String> handleException(PGNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}