package com.example.storepractice.domain.Service;

import com.example.storepractice.data.Repository.CategoryRepository;
import com.example.storepractice.domain.Entity.Category;
import com.example.storepractice.domain.Mapper.CategoryMapper;
import com.example.storepractice.presentation.Request.Dto.CategoryDto;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImple implements CategoryService{

  private CategoryRepository categoryRepository;
  private CategoryMapper categoryMapper;
  @Override
  public Category createCategory(CategoryDto categoryDto) {

    Category categoryToCreate =categoryMapper.categoryFromDto(categoryDto);

    return categoryRepository.save(categoryToCreate);
  }

  @Override
  public Category getById(UUID uuid) {
    Category category=categoryRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("Category was not found"));
    return category;
  }

  @Override
  public List<Category> getAll() {
    return categoryRepository.getByIsDeletedFalse();
  }

  @Override
  public Category updateCategory(CategoryDto categoryDto, UUID uuid) {
    Category categoryfound= categoryRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("categoria not found"));
    categoryfound.setName(categoryDto.getName());
    categoryfound.setDescription(categoryDto.getDescription());
    categoryfound.setUpdatedAt(LocalDateTime.now());
    return categoryRepository.save(categoryfound);
  }

  @Override
  public String deleteCategory(UUID uuid) {

    Category category= categoryRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("category not found"));
    category.setIsDeleted(true);
    categoryRepository.save(category);
    return "Category was deleted successfully";
  }


}
