package sap.datalake.dataobject;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@Entity
@DynamicInsert
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountId;

    @Column(length = 150, nullable = false)
    private String companyName;

    @Column(nullable = false)
    private Integer size;

    @Column(length = 30, nullable = false)
    private String industry;

    @Column(length = 100, nullable = false)
    private String website;

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
}
