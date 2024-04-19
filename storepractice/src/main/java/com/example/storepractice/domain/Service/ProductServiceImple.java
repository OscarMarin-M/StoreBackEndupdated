package com.example.storepractice.domain.Service;

import com.example.storepractice.data.Repository.ProductRepository;
import com.example.storepractice.domain.Entity.Category;
import com.example.storepractice.domain.Entity.Product;
import com.example.storepractice.domain.Mapper.ProductMapper;
import com.example.storepractice.presentation.Request.Dto.ProductDto;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductServiceImple implements ProductService {

  private ProductRepository productRepository;
  private ProductMapper productMapper;
  private CategoryService categoryService;
  @Override
  public Product create(ProductDto productDto) {

    Product aux=productMapper.fromDto(productDto);
    Category category=categoryService.getById(productDto.getCategoryId());
    aux.setCategory(category);
    productRepository.save(aux);
    return aux;
  }

  @Override
  public Product findById(UUID id) {
    return productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Product not found"));
  }

  @Override
  public List<Product> getAll() {
    return productRepository.getByIsActiveTrue();
  }

  @Override
  public Product update(ProductDto productDto, UUID uuid) {
    Product productToUpdate=this.findById(uuid);
    productToUpdate.setName(productDto.getName());
    productToUpdate.setDescription(productDto.getDescription());
    productToUpdate.setStock(productDto.getStock());
    productToUpdate.setPrice(productDto.getPrice());
    Category category=categoryService.getById(productDto.getCategoryId());
    productToUpdate.setCategory(category);
    return productRepository.save(productToUpdate);
  }

  @Override
  public String delete(UUID uuid) {
    Product product= productRepository.findById(uuid).orElseThrow(()->new EntityNotFoundException("product not found"));
    product.setIsActive(false);
    productRepository.save(product);
    return "PRODUCT was deleted successfully";
  }


}
