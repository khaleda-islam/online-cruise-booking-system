# Assignment 2 Instructions (Due Week 8)

## Assignment 2: Online Cruise Booking System (Spring Boot Web App)

### Due Date: March 10 at 11:59 pm

### Assessment Information
Total Mark: 60 marks - 15% of the overall grade

### Purpose:
Develop a Spring Boot-based web application for a Luxury Cruise Web App Development. Implementing CRUD functionality using JPA and Hibernate. The application should connect to a MySQL database and provide a user-friendly interface for customers to book, view, modify, and cancel flight reservations.

By finishing this assignment, you will practice to:
- Design, code and test a Spring Boot MVC app with Thymeleaf template and Spring Data JPA.
- Design and Implement MySQL database to connect with Spring Boot JPA.

Read the lecture slides week 3 - 6 and lab exercises. This material provides the necessary information you need to complete the exercises.

### Instructions and Rules
- This lab should be completed by every student individually or in pairs.
- You will have to demonstrate your solution in a scheduled lab session and submitting the project through the assignment drop box on Luminate. You must name your Eclipse project according to the following rule:
- Your Name_COMP303_AssignmentNumber
- Example: John_COMP303_Assignment2

### Functional Requirements:
1. User Login and Registration  
   The Home/Index Page should include:  
   - A "Sign In" option for existing users.  
   - A "Create Account" link for new customers to register.

2. Cruise Reservation  
   Upon successful login, customers will be redirected to the Cruise Reservation Page, where they can:  
   - Select cruise departure and return dates.  
   - Choose departure port and destination.  
   - Select cabin type (e.g., Interior, Ocean View, Balcony, Suite).  
   - Enter the number of passengers (adults and children).  
   - View cruise price, ship image/logo, itinerary highlights, and onboard amenities (preferred).

3. Payment Integration  
   After selecting cruise details, customers proceed to checkout.  
   - Provide options for credit/debit card, PayPal, Apple Pay, or Google Pay.  
   - Note: Payment details should NOT be stored in the database.

4. Payment Confirmation  
   - Display a booking confirmation message (on-page, alert, or dialog box) upon successful payment.  
   - Confirmation should include booking reference number, cruise name, and departure date.

5. Modify Reservation  
   Customers should be able to:  
   - Edit their reservation details, such as:  
     - Cruise dates  
     - Cabin type  
     - Passenger count

6. Cancel Reservation  
   - Allow customers to cancel their cruise reservation up to 10 days before departure.  
   - Implement date validation logic to enforce this cancellation policy.

7. Customer Profile Management  
   Customers can access their profile page to:  
   - View and update personal information such as:  
     - Address  
     - Phone number  
     - Email  
   - Password

8. Server-Side Validation  
   - Server-side validation should be implemented using appropriate annotations in the entity classes.  
   - Display validation errors using error handling tags in Thymeleaf templates.

9. Web Interface Design  
   Design a clean, accessible, and user-friendly interface using:  
   - Thymeleaf HTML files  
   - CSS or Bootstrap for styling  
   - Include luxury cruise imagery, ship visuals, and branding for a premium, professional appearance.

10. Database Requirements (MySQL)  
    Create a relational database named CruiseReservation with at least the following main tables:  
    - Customer - customer and traveler details  
    - Cruise - cruise itinerary, ship, ports, dates, and pricing  
    - Booking - reservation details linking passengers and cruises

| Customer     | Cruise         | Booking           |
|--------------|----------------|-------------------|
| customer_id  | cruise_id      | booking_id        |
| username or email | cruise_name    | customer_id (FK)  |
| password     | departure_time | cruise_id (FK)    |
| firstname    | arrival_time   | booking_date      |
| lastname     | origin         | departure_date    |
| address      | destination    | no_of_passengers  |
| city         | price          | total_price       |
| postalCode   |                | status            |

### Assessment Rubrics

| Description                                                                 | Points |
|-----------------------------------------------------------------------------|--------|
| Functionalities: Developing a Spring Boot MVC to satisfy all the requirements (1-7) | 30     |
| MySQL database design and use of JPA/CRUD repositories (10)                | 12     |
| UI friendliness (proper layout, colors, fonts, use of CSS) and page navigation (9) | 6      |
| Input form validations including Entity class annotations and Thymeleaf validations and Code stands, use of variables, comments, and naming conventions. (8) | 6      |
| Lab Demo                                                                    | 6      |
| Total                                                                       | 60     |

### Submission Rules
Each file submitted in the solution should have student name, student number and submission date in the top of the file. (Code standard)

Comments may be necessary inside the functions or predicates but that the names of the functions and predicates and the comments you include explain each are especially important. (Code standard)

Each students must hand in the assignment to Luminate drop box.

### Late Submission
There is a 20% off per day late penalty which means if a student submits an assignment one day late and does perfect work, the most they can obtain is 80/100.

For example, if a student submits one day late and obtains 8/10 as an assignment then the professor will need to deduct 20% from this grade (8 x .20 = 1.6, 8-1.6 = 6.4/10 - record 6.4). If a student submits two days late then 40% will be deducted, for example, assume the student obtains 9/10 (9 x .40 = 3.6, 9-3.6 = 5.4/10). By day five the student receives zero.

### Academic Honesty (Plagiarism and Cheating)
All students must follow the academic honesty policies regarding Plagiarism and cheating on assignments, Quizzes or Tests. Centennial college's Academic Policy will be strictly enforced. To support academic honesty at Centennial College, all academic work submitted by students may be reviewed for authenticity and originality, with utilizing software tools.

(Note: Page 5 of the PDF is blank and contains no content. Also, there's a minor inconsistency in the purpose statement where it mentions "flight reservations" – this appears to be a typo and should likely be "cruise reservations" based on the context.)