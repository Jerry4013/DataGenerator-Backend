package sap.datalake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sap.datalake.response.CommonReturnType;
import sap.datalake.service.IaMappingService;

import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/08
 **/
@RestController
@RequestMapping("/iamapping")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class IaMappingController {

    @Autowired
    private IaMappingService iaMappingService;

    @GetMapping(value = "/getiatypes")
    public CommonReturnType getIaTypes(@RequestParam(value = "comm", required=false) String comm) {
        if (comm == null || comm.equals("undefined") || comm.equals("")) {
            List<String> iaMappingTypes = iaMappingService.getIaMappingTypes();
            return CommonReturnType.create(iaMappingTypes);
        }
        List<String> iaTypes = iaMappingService.getIaTypeByCommMedium(comm);
        return CommonReturnType.create(iaTypes);
    }

    @GetMapping(value = "/getcommmediums")
    public CommonReturnType getCommMediumByIaType(@RequestParam(value = "iatype", required=false) String iaType) {
        if (iaType == null || iaType.equals("undefined") || iaType.equals("")) {
            List<String> commMediums = iaMappingService.getCommMediums();
            return CommonReturnType.create(commMediums);
        }
        List<String> commMediums = iaMappingService.getCommMediumByIaType(iaType);
        return CommonReturnType.create(commMediums);
    }
}
