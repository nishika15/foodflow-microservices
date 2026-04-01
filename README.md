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
