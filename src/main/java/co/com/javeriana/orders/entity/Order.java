/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.orders.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Cristian Castro
 */
@Entity
@Table(name = "ORDER")
@XmlRootElement
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ORDERS")
    @SequenceGenerator(name = "SQ_ORDERS", sequenceName = "SQ_ORDERS", allocationSize = 1)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "ORDER_CODE")
    private String orderCode;
    @Basic(optional = false)
    @Column(name = "ORDER_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date orderDate;
    @Column(name = "COMMENTS")
    private String comments;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private BigDecimal price;

   /* @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private List<Item> itemList;*/

    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Address addressId;

    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Customer customerId;

    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrdersStatus> ordersStatusList;*/

    public Order() {
    }

    public Order(BigDecimal id) {
        this.id = id;
    }

    public Order(BigDecimal id, String orderCode, Date orderDate, BigDecimal price) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.price = price;
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

   /* @XmlTransient
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }*/

    public Address getAddressId() {
        return addressId;
    }

    public void setAddressId(Address addressId) {
        this.addressId = addressId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    /*@XmlTransient
    public List<OrdersStatus> getOrdersStatusList() {
        return ordersStatusList;
    }

    public void setOrdersStatusList(List<OrdersStatus> ordersStatusList) {
        this.ordersStatusList = ordersStatusList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Order)) {
            return false;
        }
        Order other = (Order) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.entity.Order[ id=" + id + " ]";
    }
    
}
