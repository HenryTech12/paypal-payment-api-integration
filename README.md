# Payment API

A robust PayPal payment processing API built with Spring Boot.

## Features

- RESTful API for processing PayPal payments
- Secure transaction handling with externalized credentials
- Payment status tracking (Pending, Completed, Failed, Canceled, Refunded, Disputed)
- Frontend templates for user interaction using Thymeleaf
- Model mapping for DTOs and entities
- Centralized exception handling with `@ControllerAdvice`
- Logging for debugging requests and responses

## Tech Stack

- **Backend:** Java, Spring Boot (v3.3.9)
- **Frontend:** HTML, CSS, JavaScript (Thymeleaf templates)
- **Payment Gateway:** PayPal API
- **Build Tool:** Maven, Intelli J

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/payment-api.git
   cd payment-api
   ```

2. Configure your PayPal API credentials in `application.properties`:
   ```properties
   payment.client-id=your_client_id
   payment.client-secret=your_client_secret
   payment.mode=sandbox
   ```

3. Build the project:
   ```sh
   mvn clean install
   ```

4. Run the application:
   ```sh
   mvn spring-boot:run
   ```

5. Access the application at `http://localhost:8080`.

## API Endpoints

| Method  | Endpoint               | Description                     |
|---------|------------------------|---------------------------------|
| GET     | `/payment/create`       | Create a new payment           |
| POST    | `/payment/execute`      | Execute a payment transaction  |
| GET     | `/view/receipt`         | Retrieve the latest receipt    |

## PayPal Integration

This API integrates with PayPal for secure payment processing.  
Credentials are configured via `application.properties` for flexibility.

## Exception Handling

This project includes centralized exception handling using `@ControllerAdvice`:
- **PayPal API Errors:** Handled using `PayPalRESTException`, returning a `400 Bad Request` response.
- **General Errors:** Unhandled exceptions return a `500 Internal Server Error` response.
- **Logging:** Errors are logged for debugging.

## Frontend

<<<<<<< HEAD
The frontend templates are located in `src/main/resources/templates/frontend`.
=======
The frontend templates are located in `src/main/resources/templates/frontend/`.

## Logging

The application includes detailed logging:
- `org.springframework.web` (DEBUG)
- `org.apache.coyote.http11` (DEBUG)
- `org.apache.tomcat.util.threads` (DEBUG)

>>>>>>> 784cc8a (backend changes)
