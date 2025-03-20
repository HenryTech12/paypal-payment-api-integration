# Payment API

A simple and efficient PayPal payment processing API built with Spring Boot.

## Features

- RESTful API for processing PayPal payments
- Secure transaction handling
- Payment status tracking (Pending, Completed, Failed, Canceled, Refunded, Disputed)
- Frontend templates for user interaction
- MVC architecture with service and controller layers

## Tech Stack

- **Backend:** Java, Spring Boot
- **Frontend:** HTML, CSS, JavaScript
- **Payment Gateway:** PayPal API
- **Build Tool:** Maven, Intelli J

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-repo/payment-api.git
   cd payment-api
   ```

2. Build the project:
   ```sh
   mvn clean install
   ```

3. Run the application:
   ```sh
   mvn spring-boot:run
   ```

4. Access the application at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint        | Description                 |
|--------|---------------|-----------------------------|
| GET    | `/payment/create`    | Create payment      |
| GET    | `/payment/execute`    | Make payment       |
| REQUEST | `/view/receipt` | Get current/last transaction receipt |

## PayPal Integration

This API integrates with PayPal for secure payment processing. Make sure to configure your PayPal API credentials in the `application.properties` file.

## Frontend

The frontend templates are located in `src/main/resources/templates/frontend`.
