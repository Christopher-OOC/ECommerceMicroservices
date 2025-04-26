package com.javalord.Order;

import com.javalord.Order.customer.CustomerClient;
import com.javalord.Order.exception.BusinessException;
import com.javalord.Order.kafka.OrderConfirmation;
import com.javalord.Order.kafka.OrderProducer;
import com.javalord.Order.product.ProductClient;
import com.javalord.Order.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper orderMapper;
    private final OrderLineService orderLineService;
    private final OrderProducer orderProducer;

    public Integer createdOrder(@Valid OrderRequest request) {
        // check customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("No customer"));

        //purchase the product
        var purchasedProducts = this.productClient.purchaseProducts(request.products());

        //persist order
        var order = this.orderRepository.save(orderMapper.toOrder(request));

        //persist order line
        for (PurchaseRequest purchaseRequest : request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo start payment process
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        //send the order confirmation
        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::fromOrder)

    }
}
