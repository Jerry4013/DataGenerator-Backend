package sap.datalake.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/09
 **/
public class InteractionVO {

    private Integer interactionId;

    private String firstName;

    private String lastName;

    private String commMedium;

    private String iaType;

    private Date timestamp;

    private Integer iaStage;

    private String accountId;

    public Integer getInteractionId() {
        return interactionId;
    }

    public void setInteractionId(Integer interactionId) {
        this.interactionId = interactionId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

}
