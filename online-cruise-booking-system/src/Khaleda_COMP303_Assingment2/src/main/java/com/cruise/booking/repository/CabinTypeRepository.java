package com.cruise.booking.repository;

import com.cruise.booking.entity.CabinType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CabinTypeRepository extends JpaRepository<CabinType, Long> {
    Optional<CabinType> findByTypeName(String typeName);
}
