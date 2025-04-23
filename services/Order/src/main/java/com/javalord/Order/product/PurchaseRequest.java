package com.javalord.Order.product;

public record PurchaseRequest(
        Integer productId,
        double quantity
) {
}
