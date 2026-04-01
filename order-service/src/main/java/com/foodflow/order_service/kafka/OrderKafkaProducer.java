package com.foodflow.order_service.kafka;

import com.foodflow.order_service.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderKafkaProducer {

    private final KafkaTemplate<String, OrderResponse> kafkaTemplate;

    @Value("${kafka.topic.order-placed}")
    private String orderPlacedTopic;

    public void sendOrderPlacedEvent(OrderResponse order) {
        log.info("Publishing order event to Kafka topic: {}", orderPlacedTopic);
        kafkaTemplate.send(orderPlacedTopic, String.valueOf(order.getId()), order);
        log.info("Order event published successfully for orderId: {}", order.getId());
    }
}