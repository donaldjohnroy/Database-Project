/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @author DJ
 */
@Entity
@Table(name = "daily_sales", catalog = "laundry_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DailySales.findAll", query = "SELECT d FROM DailySales d"),
    @NamedQuery(name = "DailySales.findByDailySalesId", query = "SELECT d FROM DailySales d WHERE d.dailySalesId = :dailySalesId"),
    @NamedQuery(name = "DailySales.findByDate", query = "SELECT d FROM DailySales d WHERE d.date = :date"),
    @NamedQuery(name = "DailySales.findByTotal", query = "SELECT d FROM DailySales d WHERE d.total = :total")})
public class DailySales implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "daily_sales_id", nullable = false)
    private Integer dailySalesId;
    @Basic(optional = false)
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @Column(nullable = false)
    private float total;
    @JoinColumn(name = "transaction_id", referencedColumnName = "transaction_id")
    @ManyToOne
    private Transaction transactionId;

    public DailySales() {
    }

    public DailySales(Integer dailySalesId) {
        this.dailySalesId = dailySalesId;
    }

    public DailySales(Integer dailySalesId, Date date, float total) {
        this.dailySalesId = dailySalesId;
        this.date = date;
        this.total = total;
    }

    public Integer getDailySalesId() {
        return dailySalesId;
    }

    public void setDailySalesId(Integer dailySalesId) {
        this.dailySalesId = dailySalesId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Transaction getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Transaction transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dailySalesId != null ? dailySalesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DailySales)) {
            return false;
        }
        DailySales other = (DailySales) object;
        if ((this.dailySalesId == null && other.dailySalesId != null) || (this.dailySalesId != null && !this.dailySalesId.equals(other.dailySalesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.DailySales[ dailySalesId=" + dailySalesId + " ]";
    }
    
}
