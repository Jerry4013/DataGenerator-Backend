package sap.datalake.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sap.datalake.dataobject.Product;
import sap.datalake.error.BusinessException;
import sap.datalake.model.ProductModel;
import sap.datalake.repository.ProductJpaRepository;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductJpaRepository productJpaRepository;

    @Override
    @Transactional
    public ProductModel createProduct(ProductModel productModel) throws BusinessException {
        if (productModel == null) {
            return null;
        }
        Product product = new Product();
        BeanUtils.copyProperties(productModel, product);
        Product save = productJpaRepository.save(product);
        productModel.setProductId(save.getProductId());
        return productModel;
    }
}
