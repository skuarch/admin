package controllers.secret;

import com.google.gson.Gson;
import controllers.application.BaseController;
import java.util.HashMap;
import java.util.Locale;
import model.beans.Secret;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author skuarch-lap
 */
@Controller
public class SecretTable extends BaseController {

    private static final Logger logger = Logger.getLogger(SecretTable.class);

    @Autowired
    private MessageSource messageSource;

    //==========================================================================
    @RequestMapping(value = {"secretTable"})
    public ModelAndView secretTable(Locale locale) {

        ModelAndView mav = null;
        String json;
        HashMap<String,Object> parameters = new HashMap<>();
        Secret[] secrets;

        try {
            
            parameters.put("key", "value");
            json = RestPostClient.sendReceive(
                    parameters,
                    Constants.API_URL,
                    Constants.API_FIRST_VERSION,
                    Constants.URI_SECRET_GET_LIST
            );
            
            secrets = new Gson().fromJson(json, Secret[].class);            
            mav = new ModelAndView("secret/secretTable");
            mav.addObject("secrets", secrets);

        } catch (Exception e) {
            HandlerExceptionUtil.alert(mav, messageSource, e, logger, locale);
        }

        return mav;

    }
}
