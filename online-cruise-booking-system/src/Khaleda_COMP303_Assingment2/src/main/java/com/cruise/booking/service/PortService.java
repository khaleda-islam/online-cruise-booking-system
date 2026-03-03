package com.cruise.booking.service;

import com.cruise.booking.entity.Port;

import java.util.List;
import java.util.Optional;

public interface PortService {
    List<Port> getAllPorts();
    Optional<Port> getPortById(Long id);
    Optional<Port> getPortByCode(String portCode);
    Port savePort(Port port);
    Port updatePort(Long id, Port port);
    void deletePort(Long id);
}
