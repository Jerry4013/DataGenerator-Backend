package sap.datalake.model;

import javax.validation.constraints.NotBlank;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/05
 **/
public class AccountModel {

    private Integer accountId;

    @NotBlank(message = "Company name cannot be empty.")
    private String companyName;

    private Integer size;

    private String industry;

    private String website;

    private ContactModel[] contactModels;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public ContactModel[] getContactModels() {
        return contactModels;
    }

    public void setContactModels(ContactModel[] contactModels) {
        this.contactModels = contactModels;
    }
}
