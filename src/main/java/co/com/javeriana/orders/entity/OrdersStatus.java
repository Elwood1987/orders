/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.orders.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Cristian Castro
 */
@Entity
@Table(name = "ORDERS_STATUS")
@XmlRootElement
public class OrdersStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdersStatusPK ordersStatusPK;
    @Basic(optional = false)
    @Column(name = "DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Order order;
    @JoinColumn(name = "STATUS_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private StatusOrder statusOrder;

    public OrdersStatus() {
    }

    public OrdersStatus(OrdersStatusPK ordersStatusPK) {
        this.ordersStatusPK = ordersStatusPK;
    }

    public OrdersStatus(OrdersStatusPK ordersStatusPK, Date date) {
        this.ordersStatusPK = ordersStatusPK;
        this.date = date;
    }

    public OrdersStatus(BigInteger orderId, short statusId) {
        this.ordersStatusPK = new OrdersStatusPK(orderId, statusId);
    }

    public OrdersStatusPK getOrdersStatusPK() {
        return ordersStatusPK;
    }

    public void setOrdersStatusPK(OrdersStatusPK ordersStatusPK) {
        this.ordersStatusPK = ordersStatusPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordersStatusPK != null ? ordersStatusPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersStatus)) {
            return false;
        }
        OrdersStatus other = (OrdersStatus) object;
        if ((this.ordersStatusPK == null && other.ordersStatusPK != null) || (this.ordersStatusPK != null && !this.ordersStatusPK.equals(other.ordersStatusPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.entity.OrdersStatus[ ordersStatusPK=" + ordersStatusPK + " ]";
    }
    
}
