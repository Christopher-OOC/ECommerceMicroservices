package com.javalord.Order.kafka;

import com.javalord.Order.PaymentMethod;
import com.javalord.Order.customer.CustomerResponse;
import com.javalord.Order.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
