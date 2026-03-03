package com.cruise.booking.repository;

import com.cruise.booking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserUserId(Long userId);
    List<Booking> findByCruiseCruiseId(Long cruiseId);
    List<Booking> findByBookingStatus(String bookingStatus);
}
