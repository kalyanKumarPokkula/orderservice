package com.bookstore.orderservice.service;


import com.bookstore.orderservice.Book;
import com.bookstore.orderservice.dto.OrderItemDTO;
import com.bookstore.orderservice.models.Order;
import com.bookstore.orderservice.models.OrderItem;
import com.bookstore.orderservice.repository.OrderItemRepository;
import com.bookstore.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public OrderItem createOrderItem(OrderItem orderItem , Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        System.out.println(orderItem);
        System.out.println(
                order
        );
        Double price = order.getTotalAmount();
        price += orderItem.getPrice();
        order.setTotalAmount(price);
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);

        orderItem.setOrder(order);

        return orderItemRepository.save(orderItem);

    }

    public Book getOrderItem(Long id){
        OrderItem orderItem = orderItemRepository.findById(id).orElseThrow(() -> new RuntimeException("OrderItem not found"));

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.valueOf("application/*+json")));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        String bookServiceUrl = "http://localhost:3000/books/" + orderItem.getBookId();

        ResponseEntity<Book> response = restTemplate.exchange(bookServiceUrl, HttpMethod.GET, entity, Book.class);

        Book book = response.getBody();

        System.out.println(book.toString());

        OrderItemDTO orderItemDto = new OrderItemDTO(orderItem , book);
        System.out.println(orderItemDto.toString());

        return book;
    }

    public List<OrderItem> createOrderItems(List<OrderItem> orderItems, Long orderId){
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        Double price = order.getTotalAmount();;
        for(OrderItem item : orderItems){
            price += item.getPrice();

        }
        order.setTotalAmount(price);
        order.setUpdatedAt(LocalDateTime.now());
        orderRepository.save(order);

        for(OrderItem item : orderItems){
            item.setOrder(order);
        }



        return orderItemRepository.saveAll(orderItems);

    }
}
