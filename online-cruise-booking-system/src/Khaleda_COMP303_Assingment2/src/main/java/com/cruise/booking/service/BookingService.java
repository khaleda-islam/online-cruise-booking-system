package com.cruise.booking.service;

import com.cruise.booking.entity.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Long id);
    List<Booking> getBookingsByUserId(Long userId);
    List<Booking> getBookingsByCruiseId(Long cruiseId);
    Booking saveBooking(Booking booking);
    Booking updateBooking(Long id, Booking booking);
    void cancelBooking(Long id);
    void deleteBooking(Long id);
}
