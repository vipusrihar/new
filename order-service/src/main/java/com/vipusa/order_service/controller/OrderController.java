package com.vipusa.order_service.controller;

import com.vipusa.order_service.entity.Order;
import com.vipusa.order_service.request.CreateOrderRequest;
import com.vipusa.order_service.request.UpdateOrderRequest;
import com.vipusa.order_service.response.ApiResponse;
import com.vipusa.order_service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/")
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request);

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .isSuccess(true)
                .message("Order created successfully")
                .response(order)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .isSuccess(true)
                .message("Order fetched successfully")
                .response(order)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<Order>>> getAllOrders() {
        List<Order> orders = orderService.getAllOrders();

        ApiResponse<List<Order>> response = ApiResponse.<List<Order>>builder()
                .isSuccess(true)
                .message("All orders fetched successfully")
                .response(orders)
                .build();

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Order>> updateOrder(
            @PathVariable Long id,
            @RequestBody UpdateOrderRequest request) {

        Order order = orderService.updateOrder(id, request);

        ApiResponse<Order> response = ApiResponse.<Order>builder()
                .isSuccess(true)
                .message("Order updated successfully")
                .response(order)
                .build();

        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);

        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .isSuccess(true)
                .message("Order deleted successfully")
                .build();

        return ResponseEntity.ok(response);
    }
}
