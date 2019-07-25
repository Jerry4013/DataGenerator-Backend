package sap.datalake.service;

import org.springframework.data.domain.Pageable;
import sap.datalake.error.BusinessException;
import sap.datalake.model.InteractionModel;
import sap.datalake.model.InteractionPage;

import java.util.Date;
import java.util.List;

/**
 * @author: Jingchao Zhang
 * @createdate: 2019/07/07
 **/

public interface InteractionService {

    InteractionModel createInteraction(InteractionModel interactionModel) throws BusinessException;

    InteractionModel deleteInteraction(Integer id);

    InteractionModel updateInteraction(Integer id);

    InteractionPage getInteractionsByAccountId(Integer id, Integer page);

    InteractionPage getInteractionsByContactId(Integer id, Integer page);

    List<InteractionModel> getInteractionsByAccountIdAndStage(Integer accountId, Integer stage);

    void createRandomInteractionsWithAccount(Integer amount, Integer accountId);

    void createRandomInteractionsWithContact(Integer amount, Integer contactId, Date d1, Date d2,
                                             Integer iaStage, Integer accountId);

    void createRandomInteractionsWithAccountAndStage(Integer amount, Integer accountId, Integer stage);

}
