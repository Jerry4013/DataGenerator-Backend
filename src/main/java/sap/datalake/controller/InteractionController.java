package sap.datalake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sap.datalake.error.BusinessException;
import sap.datalake.error.EmBusinessError;
import sap.datalake.model.InteractionModel;
import sap.datalake.model.InteractionPage;
import sap.datalake.model.RandomInteractionParams;
import sap.datalake.response.CommonReturnType;
import sap.datalake.service.InteractionService;

import javax.validation.Valid;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/07
 **/
@RestController
@RequestMapping("/interaction")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class InteractionController {

    @Autowired
    private InteractionService interactionService;

    @PostMapping(value = "/create")
    public CommonReturnType createInteraction(@RequestBody @Valid InteractionModel interactionModel,
                                              BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Information is not valid.");
        }
        InteractionModel interaction = interactionService.createInteraction(interactionModel);
        return CommonReturnType.create(interaction);
    }

    @GetMapping(value = "/getbycontactid")
    public CommonReturnType getInteractionsByContactId(@RequestParam Integer contactId,
                                                       @RequestParam(value = "page", required=false) Integer page) {
        InteractionPage interactionPage = interactionService.getInteractionsByContactId(contactId, page);
        return CommonReturnType.create(interactionPage);
    }

    @GetMapping(value = "/getbyaccountid")
    public CommonReturnType getInteractionsByAccountId(@RequestParam Integer accountId,
                                                       @RequestParam(value = "page", required=false) Integer page) {
        InteractionPage interactionPage = interactionService.getInteractionsByAccountId(accountId, page);
        return CommonReturnType.create(interactionPage);
    }

    @PostMapping(value = "/randombycontact")
    public CommonReturnType createRandomInteractionsWithContact(@RequestBody RandomInteractionParams params) {
        interactionService.createRandomInteractionsWithContact(params.getAmount(), params.getContactId(),
                params.getD1(), params.getD2(), params.getIaStage(), params.getAccountId());
        return CommonReturnType.create(null);
    }
}
