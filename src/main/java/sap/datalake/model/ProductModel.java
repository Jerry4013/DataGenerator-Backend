package sap.datalake.model;

import javax.validation.constraints.NotBlank;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
public class ProductModel {

    private Integer productId;

    @NotBlank(message = "Product name cannot be empty.")
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
