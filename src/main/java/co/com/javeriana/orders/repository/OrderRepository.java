package co.com.javeriana.orders.repository;

import co.com.javeriana.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Repository
public interface OrderRepository extends JpaRepository<Order, Serializable> {

    @Modifying
    @Query("insert into ORDER (ORDER_CODE,ORDER_DATE,COMMENTS,ADDRESS_ID,CUSTOMER_IDPRICE) values(:code, :date, :comments, :address, :customer, :price)")
    public int insertOrder(@Param("code") String code, @Param("date") Date date, @Param("comments") String comments, @Param("address") BigDecimal address,
                           @Param("customer") BigDecimal customer, @Param("price") BigDecimal price);


}
