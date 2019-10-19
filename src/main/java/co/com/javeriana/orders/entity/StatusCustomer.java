/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.javeriana.orders.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Cristian Castro
 */
@Entity
@Table(name = "STATUS_CUSTOMER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StatusCustomer.findAll", query = "SELECT s FROM StatusCustomer s")})
public class StatusCustomer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Short id;
    @Basic(optional = false)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "statusId")
    private List<CustomersStatus> customersStatusList;

    public StatusCustomer() {
    }

    public StatusCustomer(Short id) {
        this.id = id;
    }

    public StatusCustomer(Short id, String name) {
        this.id = id;
        this.name = name;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<CustomersStatus> getCustomersStatusList() {
        return customersStatusList;
    }

    public void setCustomersStatusList(List<CustomersStatus> customersStatusList) {
        this.customersStatusList = customersStatusList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StatusCustomer)) {
            return false;
        }
        StatusCustomer other = (StatusCustomer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.javeriana.entity.StatusCustomer[ id=" + id + " ]";
    }
    
}
