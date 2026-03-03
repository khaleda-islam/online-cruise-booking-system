package com.cruise.booking.controller;

import com.cruise.booking.entity.Cruise;
import com.cruise.booking.service.CruiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cruises")
public class CruiseController {

    private final CruiseService cruiseService;

    public CruiseController(CruiseService cruiseService) {
        this.cruiseService = cruiseService;
    }

    @GetMapping
    public List<Cruise> getAllCruises() {
        return cruiseService.getAllCruises();
    }

    @GetMapping("/available")
    public List<Cruise> getAvailableCruises() {
        return cruiseService.getAvailableCruises();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cruise> getCruiseById(@PathVariable Long id) {
        return cruiseService.getCruiseById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Cruise createCruise(@RequestBody Cruise cruise) {
        return cruiseService.saveCruise(cruise);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cruise> updateCruise(@PathVariable Long id, @RequestBody Cruise cruise) {
        return cruiseService.getCruiseById(id)
                .map(existing -> ResponseEntity.ok(cruiseService.updateCruise(id, cruise)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCruise(@PathVariable Long id) {
        return cruiseService.getCruiseById(id)
                .map(existing -> {
                    cruiseService.deleteCruise(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
