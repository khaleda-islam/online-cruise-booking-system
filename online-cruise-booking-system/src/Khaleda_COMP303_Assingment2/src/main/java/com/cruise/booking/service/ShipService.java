package com.cruise.booking.service;

import com.cruise.booking.entity.Ship;

import java.util.List;
import java.util.Optional;

public interface ShipService {
    List<Ship> getAllShips();
    Optional<Ship> getShipById(Long id);
    Ship saveShip(Ship ship);
    Ship updateShip(Long id, Ship ship);
    void deleteShip(Long id);
}
