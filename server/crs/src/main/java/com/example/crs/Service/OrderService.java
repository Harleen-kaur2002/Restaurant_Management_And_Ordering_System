package com.example.crs.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.crs.Model.Customer;
import com.example.crs.Model.Order;
import com.example.crs.Model.OrderItem;
import com.example.crs.Repository.CustomerRepository;
import com.example.crs.Repository.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private OrderRepository orderRepo;

    public Order placeOrder(Customer customer, List<OrderItem> items, double subtotal, double tax, double total) {
        Customer savedCustomer = customerRepo.save(customer);
        Order order = new Order();
        order.setCustomerId(savedCustomer.getId());
        order.setItems(items);
        order.setSubtotal(subtotal);
        order.setTax(tax);
        order.setTotal(total);
        return orderRepo.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
}
