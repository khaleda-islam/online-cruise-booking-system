package com.cruise.booking.service;

import com.cruise.booking.entity.Cruise;

import java.util.List;
import java.util.Optional;

public interface CruiseService {
    List<Cruise> getAllCruises();
    Optional<Cruise> getCruiseById(Long id);
    List<Cruise> getCruisesByStatus(String status);
    List<Cruise> getAvailableCruises();
    Cruise saveCruise(Cruise cruise);
    Cruise updateCruise(Long id, Cruise cruise);
    void deleteCruise(Long id);
}
