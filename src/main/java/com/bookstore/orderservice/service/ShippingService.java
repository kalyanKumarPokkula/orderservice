package com.bookstore.orderservice.service;

import com.bookstore.orderservice.models.Address;
import com.bookstore.orderservice.models.Order;
import com.bookstore.orderservice.models.Shipping;
import com.bookstore.orderservice.repository.AddressRepository;
import com.bookstore.orderservice.repository.OrderRepository;
import com.bookstore.orderservice.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ShippingService {

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Shipping createShipping(Shipping shipping , Long orderId , Long addressId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("order not found"));

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new RuntimeException("address not found"));

        LocalDate currentDate = LocalDate.now();
        LocalDate datePlusTwoDays = currentDate.plusDays(1);
        shipping.setShippingDate(datePlusTwoDays);
        shipping.setDeliveryDate(LocalDate.now().plusDays(2));
        shipping.setOrderShipping(order);
        shipping.setShippingAddress(address);

        return shippingRepository.save(shipping);

    }
}
