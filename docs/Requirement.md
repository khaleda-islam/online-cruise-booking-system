# Requirements — Online Cruise Booking System

## Table of Contents
1. [User Authentication & Registration](#1-user-authentication--registration)
2. [Cruise Reservation](#2-cruise-reservation)
3. [Payment Integration](#3-payment-integration)
4. [Payment Confirmation](#4-payment-confirmation)
5. [Modify Reservation](#5-modify-reservation)
6. [Cancel Reservation](#6-cancel-reservation)
7. [Customer Profile Management](#7-customer-profile-management)

---

## 1. User Authentication & Registration

Customers must register and log in to access booking features.

- **Registration** requires: first name, last name, email address, username, and password.
- **Login** supports email/username and password.
- Passwords must be securely hashed before storage (bcrypt / Argon2).
- Email verification token is sent upon registration.
- Session management via JWT tokens stored in secure, httpOnly cookies.
- Account lockout after multiple failed login attempts.

---

## 2. Cruise Reservation

Customers can search, select, and book cruises.

- Search cruises by departure date range, departure port, and destination.
- View cruise details including itinerary, ship information, and onboard amenities.
- Select a cabin type (Interior, Ocean View, Balcony, Suite) and enter passenger details.
- Passenger count (adults + children) must not exceed the selected cabin's maximum occupancy.
- At least one adult is required per reservation.
- A unique booking reference number is generated for each reservation (format: `CR-YYYYMMDD-XXXXX`).

---

## 3. Payment Integration

After selecting cruise details, customers proceed to checkout.

- Provide payment options for:
  - Credit Card
  - Debit Card
  - PayPal
  - Apple Pay
  - Google Pay
- **Note:** Payment details (card numbers, CVV, etc.) must **NOT** be stored in the database.
- Only a gateway-issued transaction reference is persisted to allow refund lookups.

---

## 4. Payment Confirmation

Upon successful payment, the system displays a booking confirmation.

- Confirmation is shown on-page (or via an alert / dialog box).
- Confirmation must include:
  - Booking reference number
  - Cruise name / ship name
  - Departure date
- Reservation status is updated from `PENDING` to `CONFIRMED` after payment.
- Payment transaction record is created with status `COMPLETED`.

---

## 5. Modify Reservation

Customers can edit their reservation details after booking.

Editable fields include:
- Cruise dates (departure/return date via cabin re-selection)
- Cabin type
- Passenger count (adults / children)

- Each modification is logged in a `RESERVATION_MODIFICATIONS` audit table.
- Price difference is calculated and a new payment or refund is initiated if required.

---

## 6. Cancel Reservation

Customers can cancel their cruise reservation subject to the following policy:

- Cancellation is allowed **up to 10 days before the departure date**.
- Cancellation requests received within 10 days of departure are **rejected**.
- Date validation logic enforces this policy on the backend before updating the reservation.
- Upon successful cancellation:
  - Reservation `status` is set to `CANCELLED`.
  - `cancelled_at` timestamp and `cancellation_reason` are recorded.
  - Cabin availability is restored (`is_available = TRUE`).
  - `available_cabins` count on the cruise is incremented.
  - Payment `status` is updated to `REFUNDED` (if applicable).

---

## 7. Customer Profile Management

Customers can access their profile page to view and update personal information.

Editable fields include:
- Address (street, city, state, postal code, country)
- Phone number
- Email address
- Password (requires current password verification)

- Email changes trigger a new verification email.
- Password changes invalidate all existing sessions except the current one.
