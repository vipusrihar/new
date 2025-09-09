package com.vipusa.order_service.service;


import com.vipusa.order_service.entity.Order;
import com.vipusa.order_service.repository.OrderRepository;
import com.vipusa.order_service.request.CreateOrderRequest;
import com.vipusa.order_service.request.UpdateOrderRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order createOrder(CreateOrderRequest request) {
        Order order = new Order();
        order.setCustomerName(request.getCustomerName());
        order.setProductName(request.getProductName());
        order.setQuantity(request.getQuantity());
        order.setTotalPrice(request.getTotalPrice());

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order updateOrder(Long id, UpdateOrderRequest request) {
        Order order = getOrderById(id);

        if (request.getCustomerName() != null) order.setCustomerName(request.getCustomerName());
        if (request.getProductName() != null) order.setProductName(request.getProductName());
        if (request.getQuantity() != null) order.setQuantity(request.getQuantity());
        if (request.getTotalPrice() != null) order.setTotalPrice(request.getTotalPrice());

        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Long id) {
        if (!orderRepository.existsById(id)) {
            throw new RuntimeException("Order not found with id: " + id);
        }
        orderRepository.deleteById(id);
    }
}