package controllers.cashier;

import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.ApplicationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
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
public class ToggleActiveCashier extends BaseController {
    
    private static final Logger logger = Logger.getLogger(ToggleActiveCashier.class);

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = {"toggleActiveCashier"})
    public ModelAndView toggleActiveCashier(@RequestParam int cashierId, Locale locale) {
        
        ModelAndView mav = null;
        String json;
        HashMap<String,Object> parameters;     
        JSONObject jsono;

        try {            
            
            parameters = ApplicationUtil.createParameters(cashierId);
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_CASHIER_TOGGLE_ACTIVE
            );                       
            
            jsono = new JSONObject(json);            
            mav = super.getModelAndViewJson();            
            mav.addObject("json", jsono);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
