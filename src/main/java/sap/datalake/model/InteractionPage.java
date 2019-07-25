package sap.datalake.model;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/09
 **/
public class InteractionPage {

    private Integer totalPages;

    private Integer totalElements;

    private Integer currentPage;

    private Integer NumberOfElementsOfCurrentPage;

    private List<InteractionVO> interactionVOS;

    public InteractionPage() {
    }

    public InteractionPage(Integer totalPages, Integer totalElements, Integer currentPage,
                           Integer numberOfElementsOfCurrentPage, List<InteractionVO> interactionVOS) {
        this.totalPages = totalPages;
        this.totalElements = totalElements;
        this.currentPage = currentPage;
        NumberOfElementsOfCurrentPage = numberOfElementsOfCurrentPage;
        this.interactionVOS = interactionVOS;
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

    public Integer getNumberOfElementsOfCurrentPage() {
        return NumberOfElementsOfCurrentPage;
    }

    public void setNumberOfElementsOfCurrentPage(Integer numberOfElementsOfCurrentPage) {
        NumberOfElementsOfCurrentPage = numberOfElementsOfCurrentPage;
    }

    public List<InteractionVO> getInteractionVOS() {
        return interactionVOS;
    }

    public void setInteractionVOS(List<InteractionVO> interactionVOS) {
        this.interactionVOS = interactionVOS;
    }
}
