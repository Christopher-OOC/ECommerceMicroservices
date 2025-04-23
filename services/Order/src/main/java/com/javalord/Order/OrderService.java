package com.javalord.Order;

import com.javalord.Order.customer.CustomerClient;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final CustomerClient customerClient;

    public Integer createdOrder(@Valid OrderRequest request) {
        // check customer --> OpenFeign

        //purchase the product

        //persist order

        //persist order line

        //start payment process

        //send the order confirmation
    }
}
