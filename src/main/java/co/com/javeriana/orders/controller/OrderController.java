package co.com.javeriana.orders.controller;

import co.com.javeriana.orders.dto.OrderDTO;
import co.com.javeriana.orders.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Object> createOrder(@RequestBody OrderDTO order){
        try {
            if (order == null){
                return new ResponseEntity<>("Order NO puede ser vacio", HttpStatus.NOT_FOUND);
            }
            return orderService.createOrder(order);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
