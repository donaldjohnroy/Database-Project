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
import javax.persistence.EntityManager;
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
 * @author Franklin
 */
@Entity
@Table(name = "daily_expense")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DailyExpense.findAll", query = "SELECT d FROM DailyExpense d")
    , @NamedQuery(name = "DailyExpense.findByItemId", query = "SELECT d FROM DailyExpense d WHERE d.itemId = :itemId")
    , @NamedQuery(name = "DailyExpense.findByDescription", query = "SELECT d FROM DailyExpense d WHERE d.description = :description")
    , @NamedQuery(name = "DailyExpense.findByDateAcquired", query = "SELECT d FROM DailyExpense d WHERE d.dateAcquired = :dateAcquired")
    , @NamedQuery(name = "DailyExpense.findByQuantity", query = "SELECT d FROM DailyExpense d WHERE d.quantity = :quantity")
    , @NamedQuery(name = "DailyExpense.findByPricePerItem", query = "SELECT d FROM DailyExpense d WHERE d.pricePerItem = :pricePerItem")
    , @NamedQuery(name = "DailyExpense.findByTotalPrice", query = "SELECT d FROM DailyExpense d WHERE d.totalPrice = :totalPrice")
    , @NamedQuery(name = "DailyExpense.findByDailyExpensecol", query = "SELECT d FROM DailyExpense d WHERE d.dailyExpensecol = :dailyExpensecol")})
public class DailyExpense implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item_id")
    private Integer itemId;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "date_acquired")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcquired;
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @Column(name = "price_per_item")
    private float pricePerItem;
    @Basic(optional = false)
    @Column(name = "total_price")
    private float totalPrice;
    @Basic(optional = false)
    @Column(name = "daily_expensecol")
    private String dailyExpensecol;
    @JoinColumn(name = "emp_id", referencedColumnName = "employee_id")
    @ManyToOne(optional = false)
    private Employee empId;

    public DailyExpense() {
    }

    public DailyExpense(Integer itemId) {
        this.itemId = itemId;
    }

    public DailyExpense(Integer itemId, String description, Date dateAcquired, int quantity, float pricePerItem, float totalPrice, String dailyExpensecol) {
        this.itemId = itemId;
        this.description = description;
        this.dateAcquired = dateAcquired;
        this.quantity = quantity;
        this.pricePerItem = pricePerItem;
        this.totalPrice = totalPrice;
        this.dailyExpensecol = dailyExpensecol;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateAcquired() {
        return dateAcquired;
    }

    public void setDateAcquired(Date dateAcquired) {
        this.dateAcquired = dateAcquired;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(float pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDailyExpensecol() {
        return dailyExpensecol;
    }

    public void setDailyExpensecol(String dailyExpensecol) {
        this.dailyExpensecol = dailyExpensecol;
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
