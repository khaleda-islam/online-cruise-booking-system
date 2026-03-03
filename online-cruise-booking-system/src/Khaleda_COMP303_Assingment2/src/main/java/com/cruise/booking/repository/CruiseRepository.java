package com.cruise.booking.repository;

import com.cruise.booking.entity.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long> {
    List<Cruise> findByStatus(String status);
    List<Cruise> findByDepartureDateAfter(LocalDate date);
    List<Cruise> findByShipShipId(Long shipId);
}
