package com.example.storepractice.presentation.Controller;

import com.example.storepractice.domain.Entity.Order;
import com.example.storepractice.domain.Service.OrderService;
import com.example.storepractice.presentation.Request.Dto.OrderDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import netscape.javascript.JSObject;
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
@RequestMapping("/order")
public class OrderController {

  private OrderService orderService;


  /**
   * CREAR UN ORDER con sus respectivos orderdetails de manera cascada
   *
   * @param orderDto
   * @return NOTA: algo interesante pasa si queremos devolver el objeto mismo creado, este entra en
   * un bucle infinito al armar el JSON y crea un order dentro de otra order, por eso se devuelve
   * solamente una cadena de confirmacion, la logica dentro del servicio esta bien tanto como las
   * relaciones, al no mandar el objeto ni se arma el json por lo que no consume recursos que si lo
   * haria con el bucle.
   */
  @PostMapping
  public ResponseEntity<String> createOrder(@RequestBody OrderDto orderDto) {

    Order neworder = orderService.createOrder(orderDto);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body("{\"message\": \"" + "Your order was succesfully saved" + "\"}");
  }

  @GetMapping
  public ResponseEntity<List<Order>> getAllOrders(){
    List<Order> orders=orderService.getAll();
    return ResponseEntity.status(HttpStatus.OK).body(orders);
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<Order> getOrderById(@PathVariable UUID uuid){
    Order order= orderService.getOrderById(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(order);
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<Order> updateOrder(@RequestBody OrderDto orderDto, @PathVariable UUID uuid){
    Order order=orderService.updateOrder(orderDto, uuid);
    return ResponseEntity.status(HttpStatus.OK).body(order);
  }

  @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteOrder(@PathVariable UUID uuid){
    String aux= orderService.deleteOrder(uuid);
    return ResponseEntity.status(HttpStatus.OK).body(aux);
    }
  }

