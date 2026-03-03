package com.cruise.booking.controller;

import com.cruise.booking.entity.Port;
import com.cruise.booking.service.PortService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ports")
public class PortController {

    private final PortService portService;

    public PortController(PortService portService) {
        this.portService = portService;
    }

    @GetMapping
    public List<Port> getAllPorts() {
        return portService.getAllPorts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Port> getPortById(@PathVariable Long id) {
        return portService.getPortById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Port createPort(@RequestBody Port port) {
        return portService.savePort(port);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Port> updatePort(@PathVariable Long id, @RequestBody Port port) {
        return portService.getPortById(id)
                .map(existing -> ResponseEntity.ok(portService.updatePort(id, port)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePort(@PathVariable Long id) {
        return portService.getPortById(id)
                .map(existing -> {
                    portService.deletePort(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
