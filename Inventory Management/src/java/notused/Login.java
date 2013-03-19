/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package notused;

import com.opensymphony.xwork2.ActionSupport;
import core.parseXML;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mysql.MySqlConnector;
import org.apache.struts2.interceptor.SessionAware;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author samsung
 */
public class Login extends ActionSupport implements SessionAware{

 
    
private String userid;
private String password;
public String user ="";
private ArrayList<String> users;
private ArrayList<String> passwords;
private int x = 0;
private Map<String, Object> session;
private parseXML pxml = new parseXML();

   
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<String> getPasswords() {
        return passwords;
    }

    public void setPasswords(ArrayList<String> passwords) {
        this.passwords = passwords;
    }

   
 
        public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    public String execute() throws Exception {


users = new ArrayList(new HashSet(pxml.xmlparse("USER_ID", "users.xml")));
passwords = new ArrayList(new HashSet(pxml.xmlparse("LDAP_ID", "users.xml")));
user = userid;

 if(users.contains(userid)&&passwords.contains(password)) {
            
            session.put("logged-in", getUserid());
            return SUCCESS;
        }
 else {
            return ERROR;
        }


    }

  
    
}








