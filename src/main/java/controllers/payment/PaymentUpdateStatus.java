package controllers.payment;

import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch-lap
 */
@Controller
public class PaymentUpdateStatus extends BaseController {

    private static final Logger logger = Logger.getLogger(PaymentUpdateStatus.class);

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = {"paymentUpdateStatus"})
    public ModelAndView paymentUpdateStatus(@RequestParam("payments") String[] payments, Locale locale) {

        ModelAndView mav = getModelAndViewJson();
        String json;
        HashMap<String, Object> parameters = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        try {
            
            for (int i = 0; i < payments.length; i++) {
                sb.append(payments[i]);
                if (i != payments.length -1) {
                    sb.append(",");
                }
            }
            
            parameters.put("payments", sb.toString());
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_PAYMENT_UPDATE_STATUS
            );

            mav.addObject("json", json);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
