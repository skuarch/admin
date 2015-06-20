package controllers.person;

import java.util.HashMap;
import java.util.Locale;
import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import model.logic.Constants;
import model.logic.RestPostClient;
import model.util.PersonBasicInformationUtil;
import model.util.HandlerExceptionUtil;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 *
 * @author skuarch
 */
@Controller
public class UpdatePersonProfileProcess {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private HttpSession session;
    private static final Logger logger = Logger.getLogger(UpdatePersonProfileProcess.class);

    //==========================================================================    
    @RequestMapping(value = {"/updatePersonProfileProcess", "updatePersonProfileProcess"})
    public ModelAndView updateFreelancerProcess(@ModelAttribute PersonBasicInformation personBasicInformation, Locale locale) {
        
        HashMap<String, Object> parameters = null;
        String json = null;
        ModelAndView mav = new ModelAndView("application/json");
        JSONObject jsono = null;
        PersonBasicInformation personBasicInformationSession = null;        

        try {

            personBasicInformationSession = PersonBasicInformationUtil.getPersonBasicInformation(session);
            personBasicInformation.setId(personBasicInformationSession.getId());
            personBasicInformation.setKey(personBasicInformationSession.getKey());            
            
            parameters = PersonBasicInformationUtil.createHashMapPerson(personBasicInformation);            
            
            json = RestPostClient.sendReceive(parameters, 
                    Constants.API_URL, 
                    Constants.API_FIRST_VERSION, 
                    Constants.URI_PERSON_UPDATE);            
            
            
            jsono = new JSONObject(json);            
            mav.addObject("json", jsono);
            
            PersonBasicInformationUtil.resetPersonBasicInformationSession(session, personBasicInformation);

        } catch (Exception e) {
            HandlerExceptionUtil.json(mav, messageSource, e, logger, locale, "text116");
        }

        return mav;

    }
}
