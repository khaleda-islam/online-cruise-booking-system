package com.cruise.booking.service;

import com.cruise.booking.entity.CruiseCabin;

import java.util.List;
import java.util.Optional;

public interface CruiseCabinService {
    List<CruiseCabin> getAllCruiseCabins();
    Optional<CruiseCabin> getCruiseCabinById(Long id);
    List<CruiseCabin> getCabinsByCruiseId(Long cruiseId);
    CruiseCabin saveCruiseCabin(CruiseCabin cruiseCabin);
    CruiseCabin updateCruiseCabin(Long id, CruiseCabin cruiseCabin);
    void deleteCruiseCabin(Long id);
}
