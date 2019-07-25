package sap.datalake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sap.datalake.model.ProductModel;
import sap.datalake.response.CommonReturnType;
import sap.datalake.service.ProductService;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = "/create")
    @ResponseBody
    public CommonReturnType createContact(@RequestBody ProductModel productModel) {
        ProductModel product = productService.createProduct(productModel);
        return CommonReturnType.create(product);
    }
}
