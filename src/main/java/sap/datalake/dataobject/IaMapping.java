package sap.datalake.dataobject;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/07
 **/
@Entity
@DynamicInsert
public class IaMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mappingId;

    @Column(length = 30, nullable = false)
    private String iaType;

    @Column(length = 30, nullable = false)
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
