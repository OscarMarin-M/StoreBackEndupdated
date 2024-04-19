package com.example.storepractice.domain.Mapper;

import com.example.storepractice.domain.Entity.Category;
import com.example.storepractice.presentation.Request.Dto.CategoryDto;
import java.time.LocalDateTime;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

  public Category categoryFromDto (CategoryDto categoryDto){

    Category category=new Category();
    category.setName(categoryDto.getName());
    category.setDescription(categoryDto.getDescription());
    category.setIsDeleted(false);
    category.setCreatedAt(LocalDateTime.now());
    category.setUpdatedAt(LocalDateTime.now());
    category.setCreatedBy("MANUAL");
    category.setUpdatedBy("MANUAL");

    return category;
  }

}
