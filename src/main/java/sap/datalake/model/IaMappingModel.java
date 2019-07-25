package sap.datalake.model;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/08
 **/
public class IaMappingModel {

    private Integer mappingId;

    private String iaType;

    private String commMedium;

    public Integer getMappingId() {
        return mappingId;
    }

    public void setMappingId(Integer mappingId) {
        this.mappingId = mappingId;
    }

    public String getIaType() {
        return iaType;
    }

    public void setIaType(String iaType) {
        this.iaType = iaType;
    }

    public String getCommMedium() {
        return commMedium;
    }

    public void setCommMedium(String commMedium) {
        this.commMedium = commMedium;
    }
}
