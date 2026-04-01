# FoodFlow — Real-Time Food Delivery Backend

A production-grade microservices-based food delivery backend built with Spring Boot and Apache Kafka.

## Architecture
- **User Service** (port 8081) — JWT authentication, BCrypt password hashing
- **Order Service** (port 8082) — Order management, Kafka producer
- **Notification Service** (port 8083) — Kafka consumer, real-time notifications

## Tech Stack
Java • Spring Boot • Spring Security • JWT • MySQL • Apache Kafka • Maven • Docker

## How to Run
1. Start Zookeeper and Kafka
2. Run each service independently
3. Test APIs via Postman

## API Endpoints
### User Service
- POST /api/auth/register
- POST /api/auth/login

### Order Service
- POST /api/orders
- GET /api/orders/{id}
- GET /api/orders/user/{userId}
- PUT /api/orders/{id}/status

## API Testing Screenshots

### User Registration — JWT Token Generated
<img width="940" height="480" alt="image" src="https://github.com/user-attachments/assets/4fea9beb-526f-4b54-9de4-bcd1b43198ce" />

### Login API — JWT Token Response
<img width="940" height="498" alt="image" src="https://github.com/user-attachments/assets/9b592785-9fcd-4788-8871-414e5f72c3cb" />

### Place Order API
<img width="940" height="498" alt="image" src="https://github.com/user-attachments/assets/219713d8-824c-4483-9063-4a480b1c331a" />

### Update Order Status
<img width="940" height="459" alt="image" src="https://github.com/user-attachments/assets/80fcf1a4-2945-45cf-868d-3573a123ec11" />

### Real-Time Kafka Notification
<img width="940" height="501" alt="image" src="https://github.com/user-attachments/assets/21dec711-e76d-466e-bc51-a2ffe2dc3d4c" />

### MySQL — BCrypt Hashed Passwords
<img width="1524" height="466" alt="image" src="https://github.com/user-attachments/assets/73ae27bb-b7e6-4e0f-885a-66cfa35d1aad" />
