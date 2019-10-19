/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.orders.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Castro
 */
@Entity
@Table(name = "ADDRESS")
@XmlRootElement
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
 //   @GeneratedValue(strategy = GenerationType.AUTO, generator = "SQ_ORDERS")
   // @SequenceGenerator(name = "SQ_ORDERS", sequenceName = "SQ_ORDERS", allocationSize = 1)
    private BigDecimal id;
    @Basic(optional = false)
    @Column(name = "STREET")
    private String street;
    @Column(name = "ZIP")
    private String zip;
    @Basic(optional = false)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    /*@JoinTable(name = "CUSTOMERS_ADDRESS", joinColumns = {
        @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ID")}, inverseJoinColumns = {
        @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID")})
    @ManyToMany
    private List<Customer> customerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "addressId")
    private List<Order> orderList;*/

    public Address() {
    }

    public Address(BigDecimal id) {
        this.id = id;
    }

    public Address(BigDecimal id, String street, String state, String city) {
        this.id = id;
        this.street = street;
        this.state = state;
        this.city = city;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

   /* @XmlTransient
    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @XmlTransient
    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.entity.Address[ id=" + id + " ]";
    }
    
}
