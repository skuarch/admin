package controllers.payment;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.Payment;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import model.beans.PersonBasicInformation;
import model.util.PersonBasicInformationUtil;

/**
 *
 * @author skuarch
 */
@Controller
public class PaymentListTable extends BaseController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(PaymentListTable.class);
    private PersonBasicInformation personBasicInformation = null;

    //==========================================================================
    @RequestMapping(value = {"paymentListTable", "/paymentListTable"})
    public ModelAndView showTable(Locale locale) {
        
        ModelAndView mav = null;
        HashMap<String, Object> parameters = null;
        String json = null;
        Payment[] payments = null;

        try {
            
            mav = new ModelAndView("payment/paymentListTable");
            personBasicInformation = PersonBasicInformationUtil.getPersonBasicInformation(session);
            parameters = PersonBasicInformationUtil.createHashMapGetAffiliatesbyCreator(personBasicInformation.getPersonId());

            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_PAYMENT_GET_LIST
            );
            
            payments = new Gson().fromJson(json, Payment[].class);
            mav.addObject("payments", payments);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }

}
