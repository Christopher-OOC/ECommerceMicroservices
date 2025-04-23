package com.javalord.Product.product;

public record ProductPurchaseRequest(
        Integer productId,
        double quantity
) {
}
