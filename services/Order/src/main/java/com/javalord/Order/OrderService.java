package com.javalord.Order;

import com.javalord.Order.customer.CustomerClient;
import com.javalord.Order.exception.BusinessException;
import com.javalord.Order.product.ProductClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;

    public Integer createdOrder(@Valid OrderRequest request) {
        // check customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("No customer"));

        //purchase the product

        //persist order

        //persist order line

        //start payment process

        //send the order confirmation
    }
}
