package model.util;

import java.util.HashMap;
import javax.servlet.http.HttpSession;
import model.beans.PersonBasicInformation;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 *
 * @author skuarch
 */
public class PersonBasicInformationUtil {

    //==========================================================================
    private PersonBasicInformationUtil() {
    }

    //==========================================================================
    public static void resetPersonBasicInformationSession(HttpSession session, PersonBasicInformation personBasicInformation) {

        try {
            if (session != null) {

                Object object = session.getAttribute("personBasicInformation");

                if (object != null) {
                    session.removeAttribute("personBasicInformation");
                    object = null;
                    session.setAttribute("personBasicInformation", personBasicInformation);
                }

            }
        } catch (Exception e) {
            throw e;
        }

    }

    //==========================================================================
    public static HashMap<String, Object> createHashMapPerson(PersonBasicInformation personBasicInformation) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags
            hm.put("id", personBasicInformation.getId());
            hm.put("email", StringEscapeUtils.escapeHtml4(String.valueOf(personBasicInformation.getEmail())));
            hm.put("name", StringEscapeUtils.escapeHtml4(String.valueOf(personBasicInformation.getName())));
            hm.put("lastName", StringEscapeUtils.escapeHtml4(String.valueOf(personBasicInformation.getLastName())));
            hm.put("phone", StringEscapeUtils.escapeHtml4(String.valueOf(personBasicInformation.getPhone())));
            hm.put("gender.id", Integer.valueOf(personBasicInformation.getGender()));            

        } catch (Exception e) {
            throw e;
        }

        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createHashMapFreelancerUpdatePassword(String currentPassword, String newPassword, String newPassword2, long personId) {

        HashMap hm = new HashMap();

        try {

            //avoid some html tags            
            hm.put("currentPassword", StringEscapeUtils.escapeHtml4(currentPassword));
            hm.put("newPassword", StringEscapeUtils.escapeHtml4(newPassword));
            hm.put("newPassword2", StringEscapeUtils.escapeHtml4(newPassword2));
            hm.put("id", personId);

        } catch (Exception e) {
            throw e;
        }
        
        return hm;

    }
    
    //==========================================================================
    public static HashMap<String, Object> createHashMapGetAffiliatesbyCreator(long freelancerId) {

        HashMap hm = new HashMap();

        try {
            
            hm.put("creatorId", freelancerId);
            hm.put("other", "other");

        } catch (Exception e) {
            throw e;
        }
        
        return hm;

    }

    //==========================================================================
    public static PersonBasicInformation getPersonBasicInformation(HttpSession session) {
        PersonBasicInformation personBasicInformation = null;
        if (session != null) {
            personBasicInformation = (PersonBasicInformation) session.getAttribute("personBasicInformation");
        } else {
            throw new IllegalStateException("session is null");
        }
        return personBasicInformation;
    }

}
