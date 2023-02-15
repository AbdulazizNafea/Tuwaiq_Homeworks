package com.example.hw28_relationsecurity.service;

import com.example.hw28_relationsecurity.apiException.ApiException;
import com.example.hw28_relationsecurity.model.Order;
import com.example.hw28_relationsecurity.model.Product;
import com.example.hw28_relationsecurity.model.User;
import com.example.hw28_relationsecurity.repository.OrderRepository;
import com.example.hw28_relationsecurity.repository.ProductRepository;
import com.example.hw28_relationsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    //Admin
    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public  List<Order> getMyOrder(Integer auth) {
        User user =userRepository.findUserById(auth);
        List<Order> order = orderRepository.findAllByUser(user);
        if (order.isEmpty()) {
            throw new ApiException("Orders not Found");
        }
        return order;
    }

    public Order getOrderById(Integer auth, Integer orderId){
        User user = userRepository.findUserById(auth);
        Order order = orderRepository.findOrderById(orderId);
        if (order == null){
            throw new ApiException("Order not found");
        }else if (order.getUser().getId() != auth){
            throw new ApiException("not allow to see this order");
        }
        return order;
    }


    public void addOrder(Order order,Integer auth,Integer productId){
        User user = userRepository.findUserById(auth);
        Product product = productRepository.findProductById(productId);
        order.setStatus("New");
        order.setDateReceived(new Date().toString());
        order.setUser(user);
        order.setProduct(product);
        double totalPrice = order.getQuantity() * order.getProduct().getPrice();
        order.setTotalPrice(totalPrice);
        orderRepository.save(order);
    }



    public void updateOrder(Order order, Integer user_id, Integer order_id) {
//        User user = userRepository.findUserById(user_id);
        Order order1 = orderRepository.findOrderById(order_id);
        if (order1 == null) {
            throw new ApiException("Order not found");
        }
        order1.setStatus(order.getStatus());
        //order.getQuantity(order.getQuantity())
        orderRepository.save(order1);
    }
//    In Delete endpoint, check order status if its in progress or complete throw an exception
    public void deleteOrder(Integer auth, Integer order_id) {
        //User user = userRepository.findUserById(user_id);
        Order order1 = orderRepository.findOrderById(order_id);
        if (order1 == null) {
            throw new ApiException("Order not found");
        } else if (order1.getUser().getId() != auth) {
            throw new ApiException("not allow to update");
        }else if (order1.getStatus().equalsIgnoreCase("progress") || order1.getStatus().equalsIgnoreCase("complete")) {
            throw new ApiException("not allow to delete this order when it status is progress or complete ");

        }
        orderRepository.delete(order1);
    }
}
