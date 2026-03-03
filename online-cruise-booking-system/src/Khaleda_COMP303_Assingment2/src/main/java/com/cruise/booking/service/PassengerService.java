package com.cruise.booking.service;

import com.cruise.booking.entity.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    List<Passenger> getAllPassengers();
    Optional<Passenger> getPassengerById(Long id);
    List<Passenger> getPassengersByBookingId(Long bookingId);
    Passenger savePassenger(Passenger passenger);
    Passenger updatePassenger(Long id, Passenger passenger);
    void deletePassenger(Long id);
}
