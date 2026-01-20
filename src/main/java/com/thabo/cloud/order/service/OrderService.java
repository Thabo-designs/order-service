package com.thabo.cloud.order.service;

import com.thabo.cloud.order.Mapper.OrderMapper;
import com.thabo.cloud.order.dto.OrderDTOFrontEnd;
import com.thabo.cloud.order.dto.OrderRequest;
import com.thabo.cloud.order.dto.UserDTO;
import com.thabo.cloud.order.entity.Order;
import com.thabo.cloud.order.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    SequenceGenerator sequenceGenerator;

    @Autowired
    RestTemplate restTemplate;

    public OrderRequest saveOrderInDb(OrderDTOFrontEnd orderDetails) {
        Integer newOrderId = sequenceGenerator.GenerateNextOrderId();
        UserDTO userDTO = fetchUserDetailsFromUserId(orderDetails.getUserId());

        Order orderToBeSaved = new Order(newOrderId, orderDetails.getFoodItemsList(),
                orderDetails.getRestaurant(), userDTO);
        orderRepository.save(orderToBeSaved);
        return OrderMapper.INSTANCE.mapOrderToOrderRequest(orderToBeSaved);

    }

    private UserDTO fetchUserDetailsFromUserId(Integer userId) {
        return restTemplate.getForObject("http://USER-SERVICE/user/fetchUserById/" + userId, UserDTO.class);
    }
}
