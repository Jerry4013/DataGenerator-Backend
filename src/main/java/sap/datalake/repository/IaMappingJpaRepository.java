package sap.datalake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sap.datalake.dataobject.IaMapping;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/07
 **/

public interface IaMappingJpaRepository extends JpaRepository<IaMapping, Integer> {

    List<IaMapping> findAllByIaType(String iaType);

    List<IaMapping> findAllByCommMedium(String commMedium);

}
