package sap.datalake.model;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/10
 **/
public class ContactPage {

    private Integer totalPages;

    private Integer totalElements;

    private Integer currentPage;

    private Integer numberOfElements;

    private List<ContactModel> contactModels;

    public ContactPage() {
    }

    public ContactPage(Integer totalPages, Integer totalElements, Integer currentPage,
                       Integer numberOfElements, List<ContactModel> contactModels) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        this.numberOfElements = numberOfElements;
        this.contactModels = contactModels;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Integer totalElements) {
        this.totalElements = totalElements;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(Integer numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public List<ContactModel> getContactModels() {
        return contactModels;
    }

    public void setContactModels(List<ContactModel> contactModels) {
        this.contactModels = contactModels;
    }
}
