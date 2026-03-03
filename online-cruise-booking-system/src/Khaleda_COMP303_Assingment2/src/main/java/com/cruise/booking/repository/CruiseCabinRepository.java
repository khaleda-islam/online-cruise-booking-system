package com.cruise.booking.repository;

import com.cruise.booking.entity.CruiseCabin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CruiseCabinRepository extends JpaRepository<CruiseCabin, Long> {
    List<CruiseCabin> findByCruiseCruiseId(Long cruiseId);
    List<CruiseCabin> findByCabinTypeCabinTypeId(Long cabinTypeId);
}
