/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DJ
 */
@Entity
@Table(name = "services_availed", catalog = "laundry_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicesAvailed.findAll", query = "SELECT s FROM ServicesAvailed s"),
    @NamedQuery(name = "ServicesAvailed.findByServiceId", query = "SELECT s FROM ServicesAvailed s WHERE s.serviceId = :serviceId"),
    @NamedQuery(name = "ServicesAvailed.findByColored", query = "SELECT s FROM ServicesAvailed s WHERE s.colored = :colored"),
    @NamedQuery(name = "ServicesAvailed.findByWhites", query = "SELECT s FROM ServicesAvailed s WHERE s.whites = :whites"),
    @NamedQuery(name = "ServicesAvailed.findByHeavy", query = "SELECT s FROM ServicesAvailed s WHERE s.heavy = :heavy"),
    @NamedQuery(name = "ServicesAvailed.findByDryClean", query = "SELECT s FROM ServicesAvailed s WHERE s.dryClean = :dryClean"),
    @NamedQuery(name = "ServicesAvailed.findByIron", query = "SELECT s FROM ServicesAvailed s WHERE s.iron = :iron"),
    @NamedQuery(name = "ServicesAvailed.findByRush", query = "SELECT s FROM ServicesAvailed s WHERE s.rush = :rush"),
    @NamedQuery(name = "ServicesAvailed.findByPickup", query = "SELECT s FROM ServicesAvailed s WHERE s.pickup = :pickup"),
    @NamedQuery(name = "ServicesAvailed.findByDelivery", query = "SELECT s FROM ServicesAvailed s WHERE s.delivery = :delivery"),
    @NamedQuery(name = "ServicesAvailed.findByQuantity", query = "SELECT s FROM ServicesAvailed s WHERE s.quantity = :quantity")})
public class ServicesAvailed implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "service_id", nullable = false)
    private Integer serviceId;
    private Short colored;
    private Short whites;
    private Short heavy;
    @Column(name = "dry_clean")
    private Short dryClean;
    private Short iron;
    private Short rush;
    private Short pickup;
    private Short delivery;
    private Integer quantity;
    @JoinColumn(name = "laundry_id", referencedColumnName = "cloth_type_id")
    @ManyToOne
    private LaundryInfo laundryId;
    @OneToMany(mappedBy = "servicesId")
    private List<Transaction> transactionList;

    public ServicesAvailed() {
    }

    public ServicesAvailed(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Short getColored() {
        return colored;
    }

    public void setColored(Short colored) {
        this.colored = colored;
    }

    public Short getWhites() {
        return whites;
    }

    public void setWhites(Short whites) {
        this.whites = whites;
    }

    public Short getHeavy() {
        return heavy;
    }

    public void setHeavy(Short heavy) {
        this.heavy = heavy;
    }

    public Short getDryClean() {
        return dryClean;
    }

    public void setDryClean(Short dryClean) {
        this.dryClean = dryClean;
    }

    public Short getIron() {
        return iron;
    }

    public void setIron(Short iron) {
        this.iron = iron;
    }

    public Short getRush() {
        return rush;
    }

    public void setRush(Short rush) {
        this.rush = rush;
    }

    public Short getPickup() {
        return pickup;
    }

    public void setPickup(Short pickup) {
        this.pickup = pickup;
    }

    public Short getDelivery() {
        return delivery;
    }

    public void setDelivery(Short delivery) {
        this.delivery = delivery;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LaundryInfo getLaundryId() {
        return laundryId;
    }

    public void setLaundryId(LaundryInfo laundryId) {
        this.laundryId = laundryId;
    }

    @XmlTransient
    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviceId != null ? serviceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicesAvailed)) {
            return false;
        }
        ServicesAvailed other = (ServicesAvailed) object;
        if ((this.serviceId == null && other.serviceId != null) || (this.serviceId != null && !this.serviceId.equals(other.serviceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.ServicesAvailed[ serviceId=" + serviceId + " ]";
    }
    
}
