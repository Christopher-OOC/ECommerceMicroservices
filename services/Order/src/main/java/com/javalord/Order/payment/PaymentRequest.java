package com.javalord.Order.payment;

import com.javalord.Order.PaymentMethod;
import com.javalord.Order.customer.CustomerResponse;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
