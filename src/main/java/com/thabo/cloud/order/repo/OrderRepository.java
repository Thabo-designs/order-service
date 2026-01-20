package com.thabo.cloud.order.repo;

import com.thabo.cloud.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, Integer> {
}
