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
@Table(name = "laundry_info", catalog = "laundry_service", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LaundryInfo.findAll", query = "SELECT l FROM LaundryInfo l"),
    @NamedQuery(name = "LaundryInfo.findByClothTypeId", query = "SELECT l FROM LaundryInfo l WHERE l.clothTypeId = :clothTypeId"),
    @NamedQuery(name = "LaundryInfo.findByWhitesQuantity", query = "SELECT l FROM LaundryInfo l WHERE l.whitesQuantity = :whitesQuantity"),
    @NamedQuery(name = "LaundryInfo.findByWhitesWeight", query = "SELECT l FROM LaundryInfo l WHERE l.whitesWeight = :whitesWeight"),
    @NamedQuery(name = "LaundryInfo.findByColoredQuantity", query = "SELECT l FROM LaundryInfo l WHERE l.coloredQuantity = :coloredQuantity"),
    @NamedQuery(name = "LaundryInfo.findByColoredWeight", query = "SELECT l FROM LaundryInfo l WHERE l.coloredWeight = :coloredWeight"),
    @NamedQuery(name = "LaundryInfo.findByBlanketQuantity", query = "SELECT l FROM LaundryInfo l WHERE l.blanketQuantity = :blanketQuantity"),
    @NamedQuery(name = "LaundryInfo.findByBlanketWeight", query = "SELECT l FROM LaundryInfo l WHERE l.blanketWeight = :blanketWeight"),
    @NamedQuery(name = "LaundryInfo.findByBedsheetQuantity", query = "SELECT l FROM LaundryInfo l WHERE l.bedsheetQuantity = :bedsheetQuantity"),
    @NamedQuery(name = "LaundryInfo.findByBedsheetWeight", query = "SELECT l FROM LaundryInfo l WHERE l.bedsheetWeight = :bedsheetWeight"),
    @NamedQuery(name = "LaundryInfo.findByJeansQuantity", query = "SELECT l FROM LaundryInfo l WHERE l.jeansQuantity = :jeansQuantity"),
    @NamedQuery(name = "LaundryInfo.findByJeansWeight", query = "SELECT l FROM LaundryInfo l WHERE l.jeansWeight = :jeansWeight")})
public class LaundryInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cloth_type_id", nullable = false)
    private Integer clothTypeId;
    @Column(name = "whites_quantity")
    private Integer whitesQuantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "whites_weight", precision = 12)
    private Float whitesWeight;
    @Column(name = "colored_quantity")
    private Integer coloredQuantity;
    @Column(name = "colored_weight", precision = 12)
    private Float coloredWeight;
    @Column(name = "blanket_quantity")
    private Integer blanketQuantity;
    @Column(name = "blanket_weight", precision = 12)
    private Float blanketWeight;
    @Column(name = "bedsheet_quantity")
    private Integer bedsheetQuantity;
    @Column(name = "bedsheet_weight", precision = 12)
    private Float bedsheetWeight;
    @Column(name = "jeans_quantity")
    private Integer jeansQuantity;
    @Column(name = "jeans_weight", precision = 12)
    private Float jeansWeight;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @OneToMany(mappedBy = "laundryId")
    private List<ServicesAvailed> servicesAvailedList;

    public LaundryInfo() {
    }

    public LaundryInfo(Integer clothTypeId) {
        this.clothTypeId = clothTypeId;
    }

    public Integer getClothTypeId() {
        return clothTypeId;
    }

    public void setClothTypeId(Integer clothTypeId) {
        this.clothTypeId = clothTypeId;
    }

    public Integer getWhitesQuantity() {
        return whitesQuantity;
    }

    public void setWhitesQuantity(Integer whitesQuantity) {
        this.whitesQuantity = whitesQuantity;
    }

    public Float getWhitesWeight() {
        return whitesWeight;
    }

    public void setWhitesWeight(Float whitesWeight) {
        this.whitesWeight = whitesWeight;
    }

    public Integer getColoredQuantity() {
        return coloredQuantity;
    }

    public void setColoredQuantity(Integer coloredQuantity) {
        this.coloredQuantity = coloredQuantity;
    }

    public Float getColoredWeight() {
        return coloredWeight;
    }

    public void setColoredWeight(Float coloredWeight) {
        this.coloredWeight = coloredWeight;
    }

    public Integer getBlanketQuantity() {
        return blanketQuantity;
    }

    public void setBlanketQuantity(Integer blanketQuantity) {
        this.blanketQuantity = blanketQuantity;
    }

    public Float getBlanketWeight() {
        return blanketWeight;
    }

    public void setBlanketWeight(Float blanketWeight) {
        this.blanketWeight = blanketWeight;
    }

    public Integer getBedsheetQuantity() {
        return bedsheetQuantity;
    }

    public void setBedsheetQuantity(Integer bedsheetQuantity) {
        this.bedsheetQuantity = bedsheetQuantity;
    }

    public Float getBedsheetWeight() {
        return bedsheetWeight;
    }

    public void setBedsheetWeight(Float bedsheetWeight) {
        this.bedsheetWeight = bedsheetWeight;
    }

    public Integer getJeansQuantity() {
        return jeansQuantity;
    }

    public void setJeansQuantity(Integer jeansQuantity) {
        this.jeansQuantity = jeansQuantity;
    }

    public Float getJeansWeight() {
        return jeansWeight;
    }

    public void setJeansWeight(Float jeansWeight) {
        this.jeansWeight = jeansWeight;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @XmlTransient
    public List<ServicesAvailed> getServicesAvailedList() {
        return servicesAvailedList;
    }

    public void setServicesAvailedList(List<ServicesAvailed> servicesAvailedList) {
        this.servicesAvailedList = servicesAvailedList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clothTypeId != null ? clothTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LaundryInfo)) {
            return false;
        }
        LaundryInfo other = (LaundryInfo) object;
        if ((this.clothTypeId == null && other.clothTypeId != null) || (this.clothTypeId != null && !this.clothTypeId.equals(other.clothTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.LaundryInfo[ clothTypeId=" + clothTypeId + " ]";
    }
    
}
