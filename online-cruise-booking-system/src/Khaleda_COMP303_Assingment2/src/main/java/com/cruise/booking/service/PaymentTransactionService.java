package com.cruise.booking.service;

import com.cruise.booking.entity.PaymentTransaction;

import java.util.List;
import java.util.Optional;

public interface PaymentTransactionService {
    List<PaymentTransaction> getAllTransactions();
    Optional<PaymentTransaction> getTransactionById(Long id);
    List<PaymentTransaction> getTransactionsByBookingId(Long bookingId);
    PaymentTransaction saveTransaction(PaymentTransaction transaction);
    PaymentTransaction updateTransaction(Long id, PaymentTransaction transaction);
    void deleteTransaction(Long id);
}
