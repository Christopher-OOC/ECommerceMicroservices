package com.javalord.Product.product;

import java.math.BigInteger;

public record ProductRequest(
        Integer id,
        String name,
        String description,
        double availableQuantity,
        BigInteger price,
        Integer categoryId
) {
}
