package com.cruise.booking.controller;

import com.cruise.booking.entity.Ship;
import com.cruise.booking.service.ShipService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ships")
public class ShipController {

    private final ShipService shipService;

    public ShipController(ShipService shipService) {
        this.shipService = shipService;
    }

    @GetMapping
    public List<Ship> getAllShips() {
        return shipService.getAllShips();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ship> getShipById(@PathVariable Long id) {
        return shipService.getShipById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Ship createShip(@RequestBody Ship ship) {
        return shipService.saveShip(ship);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ship> updateShip(@PathVariable Long id, @RequestBody Ship ship) {
        return shipService.getShipById(id)
                .map(existing -> ResponseEntity.ok(shipService.updateShip(id, ship)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShip(@PathVariable Long id) {
        return shipService.getShipById(id)
                .map(existing -> {
                    shipService.deleteShip(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
