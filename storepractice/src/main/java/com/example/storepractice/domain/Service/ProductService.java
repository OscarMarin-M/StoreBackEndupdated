package com.example.storepractice.domain.Service;

import com.example.storepractice.domain.Entity.Product;
import com.example.storepractice.presentation.Controller.ProductController;
import com.example.storepractice.presentation.Request.Dto.ProductDto;
import java.util.List;
import java.util.UUID;
import javax.sound.sampled.Port;

public interface ProductService {

  Product create (ProductDto productDto);
  Product findById(UUID id);

  List<Product> getAll();

  Product update (ProductDto productDto, UUID uuid);

  String delete(UUID uuid);

}
