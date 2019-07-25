package sap.datalake.dataobject;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@Entity
@DynamicInsert
public class Interaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer interactionId;

    @Column(nullable = false)
    private Integer contactId;

    @Column(length = 20, nullable = false)
    private String commMedium;

    @Column(length = 20, nullable = false)
    private String iaType;

    private Date timestamp;

    @Column(nullable = false, columnDefinition = "TINYINT")
    private Integer iaStage;

    @Column(nullable = false)
    private Integer accountId;

//    private Set<Product> relatedProducts = new HashSet<>();

    public Interaction() {
    }

    public Interaction(Integer contactId, String commMedium, String iaType, Date timestamp, Integer iaStage, Integer accountId) {
        this.contactId = contactId;
        this.commMedium = commMedium;
        this.iaType = iaType;
        this.timestamp = timestamp;
        this.iaStage = iaStage;
        this.accountId = accountId;
    }

    public Integer getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Integer interactionId) {
        this.interactionId = interactionId;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Integer getIaStage() {
        return iaStage;
    }

    public void setIaStage(Integer iaStage) {
        this.iaStage = iaStage;
    }

    public String getCommMedium() {
        return commMedium;
    }

    public void setCommMedium(String commMedium) {
        this.commMedium = commMedium;
    }

    public String getIaType() {
        return iaType;
    }

    public void setIaType(String iaType) {
        this.iaType = iaType;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getIaStatus() {
        return iaStage;
    }

    public void setIaStatus(Integer iaStatus) {
        this.iaStage = iaStatus;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    //    public Set<Product> getRelatedProducts() {
//        return relatedProducts;
//    }
//
//    public void setRelatedProducts(Set<Product> relatedProducts) {
//        this.relatedProducts = relatedProducts;
//    }
}
