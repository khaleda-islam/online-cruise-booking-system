package com.cruise.booking.service;

import com.cruise.booking.entity.CabinType;

import java.util.List;
import java.util.Optional;

public interface CabinTypeService {
    List<CabinType> getAllCabinTypes();
    Optional<CabinType> getCabinTypeById(Long id);
    CabinType saveCabinType(CabinType cabinType);
    CabinType updateCabinType(Long id, CabinType cabinType);
    void deleteCabinType(Long id);
}
