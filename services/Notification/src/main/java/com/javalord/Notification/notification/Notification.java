package com.javalord.Notification.notification;

import com.javalord.Notification.notification.kafka.order.OrderConfirmation;
import com.javalord.Notification.notification.kafka.payment.PaymentConfirmation;
import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
    private LocalDateTime notificationDate;



}
