package sap.datalake.dataobject;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@Entity
@DynamicInsert
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;

    @Column(length = 100, nullable = false)
    private String productName;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
