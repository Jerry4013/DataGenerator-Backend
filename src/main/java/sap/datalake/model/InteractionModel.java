package sap.datalake.model;

import javax.validation.constraints.NotBlank;
import java.util.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/07
 **/
public class InteractionModel {

    private Integer interactionId;

    @NotBlank(message = "Contact ID cannot be empty.")
    private Integer contactId;

    @NotBlank(message = "Communication Medium cannot be empty.")
    private String commMedium;

    @NotBlank(message = "Interaction Type cannot be empty.")
    private String iaType;

    @NotBlank(message = "TimeStamp cannot be empty.")
    private Date timestamp;

    private Integer iaStage;

    @NotBlank(message = "Account ID cannot be empty.")
    private Integer accountId;

    private List<Integer> relatedProductIds = new ArrayList<>();

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

    public Integer getIaStage() {
        return iaStage;
    }

    public void setIaStage(Integer iaStage) {
        this.iaStage = iaStage;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public List<Integer> getRelatedProductIds() {
        return relatedProductIds;
    }

    public void setRelatedProductIds(List<Integer> relatedProductIds) {
        this.relatedProductIds = relatedProductIds;
    }
}
