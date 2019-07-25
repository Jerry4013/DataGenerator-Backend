package sap.datalake.model;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
public class ContactModel {

    private Integer contactId;

    @NotBlank(message = "Last name cannot be empty.")
    private String lastName;

    @NotBlank(message = "First name cannot be empty.")
    private String firstName;

    private String fullName;

    private String title;

    private String email;

    private Integer sex;

    private Integer maritalStatus;

    private String department;

    private Date dateOfBirth;

    private AccountModel account;

    public ContactModel() {
    }

    public ContactModel(@NotBlank(message = "Last name cannot be empty.") String lastName,
                        @NotBlank(message = "First name cannot be empty.") String firstName,
                        String fullName,
                        String title,
                        String email,
                        Integer sex,
                        Integer maritalStatus,
                        String department,
                        Date dateOfBirth,
                        AccountModel account) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.fullName = fullName;
        this.title = title;
        this.email = email;
        this.sex = sex;
        this.maritalStatus = maritalStatus;
        this.department = department;
        this.dateOfBirth = dateOfBirth;
        this.account = account;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public AccountModel getAccount() {
        return account;
    }

    public void setAccount(AccountModel account) {
        this.account = account;
    }
}
