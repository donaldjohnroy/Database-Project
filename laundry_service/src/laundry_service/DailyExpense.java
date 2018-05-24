/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laundry_service;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "daily_expense", catalog = "laundry_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DailyExpense.findAll", query = "SELECT d FROM DailyExpense d"),
    @NamedQuery(name = "DailyExpense.findByItemId", query = "SELECT d FROM DailyExpense d WHERE d.itemId = :itemId"),
    @NamedQuery(name = "DailyExpense.findByDailyExpensecol", query = "SELECT d FROM DailyExpense d WHERE d.dailyExpensecol = :dailyExpensecol"),
    @NamedQuery(name = "DailyExpense.findByDateAcquired", query = "SELECT d FROM DailyExpense d WHERE d.dateAcquired = :dateAcquired"),
    @NamedQuery(name = "DailyExpense.findByDescription", query = "SELECT d FROM DailyExpense d WHERE d.description = :description"),
    @NamedQuery(name = "DailyExpense.findByPricePerItem", query = "SELECT d FROM DailyExpense d WHERE d.pricePerItem = :pricePerItem"),
    @NamedQuery(name = "DailyExpense.findByQuantity", query = "SELECT d FROM DailyExpense d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "DailyExpense.findByTotalPrice", query = "SELECT d FROM DailyExpense d WHERE d.totalPrice = :totalPrice")})
public class DailyExpense implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item_id", nullable = false)
    private Integer itemId;
    @Column(name = "daily_expensecol", length = 255)
    private String dailyExpensecol;
    @Column(name = "date_acquired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcquired;
    @Column(name = "description", length = 255)
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price_per_item", precision = 12)
    private Float pricePerItem;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "total_price", precision = 12)
    private Float totalPrice;
    @JoinColumn(name = "emp_id", referencedColumnName = "employee_id")
    @ManyToOne
    private Employee empId;

    public DailyExpense() {
    }

    public DailyExpense(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDailyExpensecol() {
        return dailyExpensecol;
    }

    public void setDailyExpensecol(String dailyExpensecol) {
        this.dailyExpensecol = dailyExpensecol;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(Float pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Employee getEmpId() {
        return empId;
    }

    public void setEmpId(Employee empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DailyExpense)) {
            return false;
        }
        DailyExpense other = (DailyExpense) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "laundry_service.DailyExpense[ itemId=" + itemId + " ]";
    }
    
}
