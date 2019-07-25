package sap.datalake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sap.datalake.dataobject.Product;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/04
 **/

public interface ProductJpaRepository extends JpaRepository<Product, Integer> {
}
