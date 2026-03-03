package com.cruise.booking.controller;

import com.cruise.booking.entity.PaymentTransaction;
import com.cruise.booking.service.PaymentTransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentTransactionController {

    private final PaymentTransactionService paymentTransactionService;

    public PaymentTransactionController(PaymentTransactionService paymentTransactionService) {
        this.paymentTransactionService = paymentTransactionService;
    }

    @GetMapping
    public List<PaymentTransaction> getAllTransactions() {
        return paymentTransactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentTransaction> getTransactionById(@PathVariable Long id) {
        return paymentTransactionService.getTransactionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/booking/{bookingId}")
    public List<PaymentTransaction> getTransactionsByBooking(@PathVariable Long bookingId) {
        return paymentTransactionService.getTransactionsByBookingId(bookingId);
    }

    @PostMapping
    public PaymentTransaction createTransaction(@RequestBody PaymentTransaction transaction) {
        return paymentTransactionService.saveTransaction(transaction);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PaymentTransaction> updateTransaction(@PathVariable Long id,
                                                                @RequestBody PaymentTransaction transaction) {
        return paymentTransactionService.getTransactionById(id)
                .map(existing -> ResponseEntity.ok(paymentTransactionService.updateTransaction(id, transaction)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTransaction(@PathVariable Long id) {
        return paymentTransactionService.getTransactionById(id)
                .map(existing -> {
                    paymentTransactionService.deleteTransaction(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
