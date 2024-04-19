package com.example.storepractice.presentation.Controller;

import com.example.storepractice.domain.Entity.Product;
import com.example.storepractice.domain.Service.ProductService;
import com.example.storepractice.presentation.Request.Dto.ProductDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.util.ProcessIdUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

  private ProductService productService;

  @PostMapping
  public ResponseEntity<Product> createProduct(@RequestBody ProductDto productDto) {

    Product product = productService.create(productDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(product);
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<Product> getById(@PathVariable UUID uuid) {
    Product product = productService.findById(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(product);
  }

  @GetMapping
  public ResponseEntity<List<Product>> getAll() {
    List<Product> allproducts = productService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(allproducts);
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<Product> updateProduct(@RequestBody ProductDto productDto, @PathVariable UUID uuid) {
    Product updatedproduct = productService.update(productDto, uuid);
    return ResponseEntity.status(HttpStatus.OK).body(updatedproduct);

  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<String> deleteCategory(@PathVariable UUID uuid) {
    String aux = productService.delete(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(aux);

  }
}
