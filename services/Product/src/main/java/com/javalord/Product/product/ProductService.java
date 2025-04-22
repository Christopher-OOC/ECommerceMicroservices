package com.javalord.Product.product;

import jakarta.validation.Valid;

import java.util.List;

public class ProductService {
    public Integer createProduct(@Valid ProductRequest request) {
    }

    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
    }

    public ProductResponse findById(Integer productId) {
    }

    public List<ProductResponse> findAll() {
    }
}
