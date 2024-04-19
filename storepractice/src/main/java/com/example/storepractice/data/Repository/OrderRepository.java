package com.example.storepractice.data.Repository;

import com.example.storepractice.domain.Entity.Order;
import com.example.storepractice.domain.Entity.Store;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
  List<Order> getByIsDeletedFalse();
}
