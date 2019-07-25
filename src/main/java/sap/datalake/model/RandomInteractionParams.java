package sap.datalake.model;

import java.util.Date;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/08
 **/
public class RandomInteractionParams {

    private Integer amount;

    private Integer contactId;

    private Date d1;

    private Date d2;

    private Integer iaStage;

    private Integer accountId;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public Date getD1() {
        return d1;
    }

    public void setD1(Date d1) {
        this.d1 = d1;
    }

    public Date getD2() {
        return d2;
    }

    public void setD2(Date d2) {
        this.d2 = d2;
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
}
