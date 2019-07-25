package sap.datalake.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sap.datalake.dataobject.IaMapping;
import sap.datalake.repository.IaMappingJpaRepository;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/08
 **/
@Service
public class IaMappingServiceImpl implements IaMappingService {

    @Autowired
    private IaMappingJpaRepository iaMappingJpaRepository;

    @Override
    public List<String> getIaMappingTypes() {
        List<IaMapping> iaMappings = iaMappingJpaRepository.findAll();
        List<String> iaTypes = iaMappings.stream().map(IaMapping::getIaType).collect(Collectors.toList());
        return removeDuplicate(iaTypes);
    }

    @Override
    public List<String> getCommMediumByIaType(String iaType) {
        List<IaMapping> iaMappings = iaMappingJpaRepository.findAllByIaType(iaType);
        List<String> commMediums = iaMappings.stream().map(IaMapping::getCommMedium).collect(Collectors.toList());
        return commMediums;
    }

    @Override
    public List<String> getIaTypeByCommMedium(String comm) {
        List<IaMapping> iaMappings = iaMappingJpaRepository.findAllByCommMedium(comm);
        List<String> iaTypes = iaMappings.stream().map(IaMapping::getIaType).collect(Collectors.toList());
        return iaTypes;
    }

    @Override
    public List<String> getCommMediums() {
        List<IaMapping> iaMappings = iaMappingJpaRepository.findAll();
        List<String> commMediums = iaMappings.stream().map(IaMapping::getCommMedium).collect(Collectors.toList());
        return removeDuplicate(commMediums);
    }

    private List<String> removeDuplicate(List<String> strings) {
        LinkedHashSet<String> set = new LinkedHashSet<>(strings.size());
        set.addAll(strings);
        strings.clear();
        strings.addAll(set);
        return strings;
    }
}
