package com.foodflow.order_service.service;

import com.foodflow.order_service.dto.OrderRequest;
import com.foodflow.order_service.dto.OrderResponse;
import com.foodflow.order_service.kafka.OrderKafkaProducer;
import com.foodflow.order_service.model.Order;
import com.foodflow.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderKafkaProducer kafkaProducer;

    public OrderResponse placeOrder(OrderRequest request) {
        Order order = new Order();
        order.setUserId(request.getUserId());
        order.setRestaurantId(request.getRestaurantId());
        order.setItems(request.getItems());
        order.setTotalAmount(request.getTotalAmount());
        order.setDeliveryAddress(request.getDeliveryAddress());

        Order savedOrder = orderRepository.save(order);
        log.info("Order placed successfully with ID: {}", savedOrder.getId());

        OrderResponse response = mapToResponse(savedOrder);
        kafkaProducer.sendOrderPlacedEvent(response);

        return response;
    }

    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        return mapToResponse(order);
    }

    public List<OrderResponse> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public OrderResponse updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        order.setStatus(status);
        Order updatedOrder = orderRepository.save(order);
        log.info("Order {} status updated to {}", id, status);
        return mapToResponse(updatedOrder);
    }

    private OrderResponse mapToResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getUserId(),
                order.getRestaurantId(),
                order.getItems(),
                order.getTotalAmount(),
                order.getStatus(),
                order.getDeliveryAddress(),
                order.getCreatedAt()
        );
    }
}