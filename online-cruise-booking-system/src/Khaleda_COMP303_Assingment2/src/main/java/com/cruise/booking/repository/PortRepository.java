package com.cruise.booking.repository;

import com.cruise.booking.entity.Port;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortRepository extends JpaRepository<Port, Long> {
    Optional<Port> findByPortCode(String portCode);
    Optional<Port> findByPortName(String portName);
}
