package com.example.storepractice.domain.Service;

import com.example.storepractice.domain.Entity.Category;
import com.example.storepractice.presentation.Request.Dto.CategoryDto;
import java.util.List;
import java.util.UUID;

public interface CategoryService {

  Category createCategory (CategoryDto categoryDto);

  Category getById(UUID uuid);

  List<Category> getAll();

  Category updateCategory(CategoryDto categoryDto, UUID uuid);

  String deleteCategory(UUID uuid);
}
