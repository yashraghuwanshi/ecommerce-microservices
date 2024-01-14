package com.example.service;

import com.example.dto.OrderItemsRequest;
import com.example.dto.OrderRequest;
import com.example.model.Order;
import com.example.model.OrderItems;
import com.example.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderItems> orderItems = orderRequest.getOrderItemsRequest()
                .stream()
                .map(this::mapToDto).collect(Collectors.toList());
        order.setOrderItems(orderItems);

        orderRepository.save(order);
    }

    private OrderItems mapToDto(OrderItemsRequest orderItemsRequest) {
        OrderItems orderItems = new OrderItems();
        orderItems.setPrice(orderItemsRequest.getPrice());
        orderItems.setSkuCode(orderItemsRequest.getSkuCode());
        orderItems.setQuantity(orderItemsRequest.getQuantity());
        return orderItems;
    }
}
