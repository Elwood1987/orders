package co.com.javeriana.orders.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderDTO implements Serializable {
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    private BigDecimal id;
    private String orderCode;
    private Date orderDate;
    private String comments;
    private BigDecimal price;
    private BigDecimal addressId;
    private BigDecimal customerId;

    public OrderDTO() {
    }

    public OrderDTO(BigDecimal id, String orderCode, Date orderDate, String comments, BigDecimal price, BigDecimal addressId, BigDecimal customerId) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.comments = comments;
        this.price = price;
        this.addressId = addressId;
        this.customerId = customerId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getAddressId() {
        return addressId;
    }

    public void setAddressId(BigDecimal addressId) {
        this.addressId = addressId;
    }

    public BigDecimal getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigDecimal customerId) {
        this.customerId = customerId;
    }
}
