package com.javalord.Product.product;

import java.math.BigInteger;

public record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigInteger price,
        double quantity
) {
}
