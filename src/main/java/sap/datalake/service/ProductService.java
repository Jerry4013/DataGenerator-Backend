package sap.datalake.service;

import sap.datalake.error.BusinessException;
import sap.datalake.model.ProductModel;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/

public interface ProductService {
    ProductModel createProduct(ProductModel productModel) throws BusinessException;
}
