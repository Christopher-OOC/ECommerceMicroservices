package com.javalord.Notification.notification.kafka.payment;

import com.javalord.Notification.notification.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<PaymentConfirmation, Integer> {

}
