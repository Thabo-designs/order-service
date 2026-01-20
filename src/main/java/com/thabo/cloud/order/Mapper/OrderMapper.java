package com.thabo.cloud.order.Mapper;

import com.thabo.cloud.order.dto.OrderRequest;
import com.thabo.cloud.order.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    Order mapOrderRequestToOrder(OrderRequest orderRequest);
    OrderRequest mapOrderToOrderRequest(Order order);
}
