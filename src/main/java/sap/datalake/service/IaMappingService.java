package sap.datalake.service;

import sap.datalake.model.IaMappingModel;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/08
 **/

public interface IaMappingService {

    List<String> getIaMappingTypes();

    List<String> getCommMediumByIaType(String iaType);

    List<String> getCommMediums();

    List<String> getIaTypeByCommMedium(String comm);
}
