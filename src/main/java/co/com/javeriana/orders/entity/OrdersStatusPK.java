/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.orders.entity;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Cristian Castro
 */
@Embeddable
public class OrdersStatusPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ORDER_ID")
    private BigInteger orderId;
    @Basic(optional = false)
    @Column(name = "STATUS_ID")
    private short statusId;

    public OrdersStatusPK() {
    }

    public OrdersStatusPK(BigInteger orderId, short statusId) {
        this.orderId = orderId;
        this.statusId = statusId;
    }

    public BigInteger getOrderId() {
        return orderId;
    }

    public void setOrderId(BigInteger orderId) {
        this.orderId = orderId;
    }

    public short getStatusId() {
        return statusId;
    }

    public void setStatusId(short statusId) {
        this.statusId = statusId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        hash += (int) statusId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdersStatusPK)) {
            return false;
        }
        OrdersStatusPK other = (OrdersStatusPK) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        if (this.statusId != other.statusId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.entity.OrdersStatusPK[ orderId=" + orderId + ", statusId=" + statusId + " ]";
    }
    
}
