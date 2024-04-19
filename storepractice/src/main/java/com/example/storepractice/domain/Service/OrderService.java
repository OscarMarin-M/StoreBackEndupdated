package com.example.storepractice.domain.Service;

import com.example.storepractice.domain.Entity.Order;
import com.example.storepractice.presentation.Request.Dto.OrderDto;
import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import java.util.List;
import java.util.UUID;
import org.hibernate.sql.Update;

public interface OrderService {
  Order createOrder(OrderDto orderDto);

  List<Order> getAll();

  Order getOrderById(UUID uuid);

  Order updateOrder(OrderDto dto, UUID uuid);

  String deleteOrder(UUID uuid);
}
