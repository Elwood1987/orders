package co.com.javeriana.orders.services;

import co.com.javeriana.orders.dto.OrderDTO;
import co.com.javeriana.orders.entity.Address;
import co.com.javeriana.orders.entity.Customer;
import co.com.javeriana.orders.entity.Order;
import co.com.javeriana.orders.repository.AddressRepository;
import co.com.javeriana.orders.repository.CustomerRepository;
import co.com.javeriana.orders.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CustomerRepository customerRepository;

    public ResponseEntity<Object> createOrder(OrderDTO orderDTO){
        try {

            /*Order newOrder = new Order();
            newOrder.setOrderCode(orderDTO.getOrderCode());
            newOrder.setOrderDate(orderDTO.getOrderDate());
            newOrder.setComments(orderDTO.getComments());
            newOrder.setPrice(orderDTO.getPrice());
            Address address = (addressRepository.findById(orderDTO.getAddressId()));

            newOrder.setAddressId(address);

            Customer customer = customerRepository.findById(orderDTO.getCustomerId());

            newOrder.setCustomerId(customer);

            orderRepository. (newOrder);*/

            orderRepository.insertOrder(orderDTO.getOrderCode(), orderDTO.getOrderDate(), orderDTO.getComments(), orderDTO.getAddressId(),
                    orderDTO.getCustomerId(), orderDTO.getPrice());

           return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
