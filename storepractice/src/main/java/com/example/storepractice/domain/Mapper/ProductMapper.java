package com.example.storepractice.domain.Mapper;

import com.example.storepractice.domain.Entity.Product;
import com.example.storepractice.domain.Entity.Store;
import com.example.storepractice.presentation.Request.Dto.ProductDto;
import com.example.storepractice.presentation.Request.Dto.StoreDto;
import java.time.LocalDateTime;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
  public Product fromDto(ProductDto dto) {

    Product product=new Product();
    product.setName(dto.getName());
    product.setDescription(dto.getDescription());
    product.setStock(dto.getStock());
    product.setPrice(dto.getPrice());
    product.setCreatedAt(LocalDateTime.now());
    product.setUpdatedAt(LocalDateTime.now());
    product.setCreatedBy("USER WHO CREATED THIS PROD");
    product.setUpdatedBy("USER WHO UPDATED THIS PROD");
    product.setIsActive(true);

    return product;
  }
}
