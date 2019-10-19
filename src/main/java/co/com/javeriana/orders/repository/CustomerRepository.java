package co.com.javeriana.orders.repository;

import co.com.javeriana.orders.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {

    public Customer findById(BigDecimal id);
}
