package com.example.storepractice.presentation.Controller;


import com.example.storepractice.domain.Entity.Category;
import com.example.storepractice.domain.Service.CategoryService;
import com.example.storepractice.presentation.Request.Dto.CategoryDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
  private CategoryService categoryService;
  @PostMapping
  public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto){

    Category newCategory=categoryService.createCategory(categoryDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<Category> getCategoryById(@PathVariable UUID uuid){
    Category category=categoryService.getById(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(category);
  }

  @GetMapping
  public ResponseEntity<List<Category>> getAllCategories(){
    List<Category> allCategories= categoryService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(allCategories);
  }
  @PutMapping("/{uuid}")
  public ResponseEntity<Category> updateCategory(@RequestBody CategoryDto categoryDto, @PathVariable UUID uuid){
    Category category=categoryService.updateCategory(categoryDto, uuid);
    return ResponseEntity.status(HttpStatus.OK).body(category);
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<String> deleteCategory(@PathVariable UUID uuid){
    String aux=categoryService.deleteCategory(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(aux);
  }

}
