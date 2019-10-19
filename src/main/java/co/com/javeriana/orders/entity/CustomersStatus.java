/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.orders.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Castro
 */
@Entity
@Table(name = "CUSTOMERS_STATUS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomersStatus.findAll", query = "SELECT c FROM CustomersStatus c")})
public class CustomersStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private BigDecimal customerId;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Customer customer;
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private StatusCustomer statusId;

    public CustomersStatus() {
    }

    public CustomersStatus(BigDecimal customerId) {
        this.customerId = customerId;
    }

    public CustomersStatus(BigDecimal customerId, Date date) {
        this.customerId = customerId;
        this.date = date;
    }

    public BigDecimal getCustomerId() {
        return customerId;
    }

    public void setCustomerId(BigDecimal customerId) {
        this.customerId = customerId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public StatusCustomer getStatusId() {
        return statusId;
    }

    public void setStatusId(StatusCustomer statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomersStatus)) {
            return false;
        }
        CustomersStatus other = (CustomersStatus) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.entity.CustomersStatus[ customerId=" + customerId + " ]";
    }
    
}
