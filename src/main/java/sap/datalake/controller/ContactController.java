package sap.datalake.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sap.datalake.model.ContactModel;
import sap.datalake.model.ContactPage;
import sap.datalake.response.CommonReturnType;
import sap.datalake.service.ContactService;

import java.util.List;


/**
 * @author: Jingchao Zhang
 * @createDate: 2019/07/04
 **/
@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = {"*"}, allowCredentials = "true")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/create")
    public CommonReturnType createContact(@RequestBody ContactModel contactModel) {
        ContactModel contact = contactService.createContact(contactModel);
        return CommonReturnType.create(contact);
    }

    @GetMapping(value = "/get")
    public CommonReturnType getContact(@RequestParam(name = "id")Integer id) {
        ContactModel contactModel = contactService.findById(id);
        return CommonReturnType.create(contactModel);
    }

    @PostMapping(value = "/createrandom")
    public CommonReturnType createRandomContacts(@RequestParam("amount") Integer amount,
                                                 @RequestParam("account") Integer accountId) {
        contactService.createRandomContacts(amount, accountId);
        return CommonReturnType.create(null);
    }

    @GetMapping(value = "/getContacts")
    public CommonReturnType getContacts(@RequestParam("accountid") Integer accountId,
                                        @RequestParam(value = "page", required=false) Integer page) {
        ContactPage contactPage = contactService.getContacts(accountId, page);
        return CommonReturnType.create(contactPage);
    }
}
