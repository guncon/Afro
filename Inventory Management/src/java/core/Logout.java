/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author samsung
 */
public class Logout extends ActionSupport implements SessionAware{

  




private Map<String, Object> session;


   

   
 
            public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public String execute() throws Exception {

session.clear();
return SUCCESS;


    }

  
    
}








