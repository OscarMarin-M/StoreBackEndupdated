package com.example.storepractice.data.Repository;

import com.example.storepractice.domain.Entity.Category;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, UUID> {

  List<Category> getByIsDeletedFalse();
}
