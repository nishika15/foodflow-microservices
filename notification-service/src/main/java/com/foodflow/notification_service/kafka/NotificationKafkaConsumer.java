package com.foodflow.notification_service.kafka;

import com.foodflow.notification_service.dto.OrderEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class NotificationKafkaConsumer {

    @KafkaListener(
            topics = "${kafka.topic.order-placed}",
            groupId = "notification-group"
    )
    public void handleOrderPlaced(OrderEvent orderEvent) {
        log.info("═══════════════════════════════════════");
        log.info("📦 NEW ORDER NOTIFICATION");
        log.info("═══════════════════════════════════════");
        log.info("Order ID     : {}", orderEvent.getId());
        log.info("User ID      : {}", orderEvent.getUserId());
        log.info("Items        : {}", orderEvent.getItems());
        log.info("Total Amount : ₹{}", orderEvent.getTotalAmount());
        log.info("Address      : {}", orderEvent.getDeliveryAddress());
        log.info("Status       : {}", orderEvent.getStatus());
        log.info("═══════════════════════════════════════");
        log.info("✅ Notification sent to user {}!", orderEvent.getUserId());
    }
}