package com.vipusa.order_service.service;


import com.vipusa.order_service.entity.Order;
import com.vipusa.order_service.request.CreateOrderRequest;
import com.vipusa.order_service.request.UpdateOrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder(CreateOrderRequest request);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    Order updateOrder(Long id, UpdateOrderRequest request);
    void deleteOrder(Long id);
}