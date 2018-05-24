/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry_service;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DJ
 */
@Entity
@Table(name = "transaction", catalog = "laundry_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Transaction.findAll", query = "SELECT t FROM Transaction t"),
    @NamedQuery(name = "Transaction.findByTransactionId", query = "SELECT t FROM Transaction t WHERE t.transactionId = :transactionId"),
    @NamedQuery(name = "Transaction.findByDateClaimed", query = "SELECT t FROM Transaction t WHERE t.dateClaimed = :dateClaimed"),
    @NamedQuery(name = "Transaction.findByDateReceived", query = "SELECT t FROM Transaction t WHERE t.dateReceived = :dateReceived"),
    @NamedQuery(name = "Transaction.findByOrNumber", query = "SELECT t FROM Transaction t WHERE t.orNumber = :orNumber"),
    @NamedQuery(name = "Transaction.findByTotalAmount", query = "SELECT t FROM Transaction t WHERE t.totalAmount = :totalAmount")})
public class Transaction implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "transaction_id", nullable = false)
    private Integer transactionId;
    @Column(name = "date_claimed")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateClaimed;
    @Column(name = "date_received")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReceived;
    @Column(name = "or_number")
    private Integer orNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "total_amount", precision = 12)
    private Float totalAmount;
    @OneToMany(mappedBy = "transactionId")
    private List<DailySales> dailySalesList;
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee employeeId;
    @JoinColumn(name = "services_id", referencedColumnName = "service_id")
    @ManyToOne
    private ServicesAvailed servicesId;

    public Transaction() {
    }

    public Transaction(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public Date getDateClaimed() {
        return dateClaimed;
    }

    public void setDateClaimed(Date dateClaimed) {
        this.dateClaimed = dateClaimed;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Integer getOrNumber() {
        return orNumber;
    }

    public void setOrNumber(Integer orNumber) {
        this.orNumber = orNumber;
    }

    public Float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
    }

    @XmlTransient
    public List<DailySales> getDailySalesList() {
        return dailySalesList;
    }

    public void setDailySalesList(List<DailySales> dailySalesList) {
        this.dailySalesList = dailySalesList;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public ServicesAvailed getServicesId() {
        return servicesId;
    }

    public void setServicesId(ServicesAvailed servicesId) {
        this.servicesId = servicesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionId != null ? transactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transaction)) {
            return false;
        }
        Transaction other = (Transaction) object;
        if ((this.transactionId == null && other.transactionId != null) || (this.transactionId != null && !this.transactionId.equals(other.transactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laundry_service.Transaction[ transactionId=" + transactionId + " ]";
    }
    
}
