package co.com.javeriana.orders.repository;

import co.com.javeriana.orders.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;

@Repository
public interface AddressRepository extends JpaRepository<Address, Serializable> {

    public Address findById(BigDecimal id);
}
