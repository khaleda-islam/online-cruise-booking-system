package com.cruise.booking.service.impl;

import com.cruise.booking.entity.Booking;
import com.cruise.booking.repository.BookingRepository;
import com.cruise.booking.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> getBookingsByUserId(Long userId) {
        return bookingRepository.findByUserUserId(userId);
    }

    @Override
    public List<Booking> getBookingsByCruiseId(Long cruiseId) {
        return bookingRepository.findByCruiseCruiseId(cruiseId);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public Booking updateBooking(Long id, Booking booking) {
        booking.setBookingId(id);
        return bookingRepository.save(booking);
    }

    @Override
    public void cancelBooking(Long id) {
        bookingRepository.findById(id).ifPresent(booking -> {
            booking.setBookingStatus("CANCELLED");
            bookingRepository.save(booking);
        });
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
