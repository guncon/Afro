package core;

import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import org.apache.struts2.interceptor.SessionAware;


public class LDAPAuthenticator extends ActionSupport implements SessionAware{
    private  String username;
    private  String password;
    private Map<String, Object> session;
    private parseXML pxml = new parseXML();
    private ArrayList<String> users;
    private ArrayList groupid = null;
     private ArrayList permid = null;
     private Insertuser iu = new Insertuser();
     private getXML gxml = new getXML();
     private String userid;
     private ArrayList useridatm;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList getGroupid() {
        return groupid;
    }

    public void setGroupid(ArrayList groupid) {
        this.groupid = groupid;
    }

    public ArrayList getPermid() {
        return permid;
    }

    public void setPermid(ArrayList permid) {
        this.permid = permid;
    }
    
     public void setSession(Map<String, Object> session) {
        this.session = session;
    }
    @Override
	 public String execute()
	{   String usern ="uid="+username+",ou=auth,o=sec" ;
            
            
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://165.213.248.99:11389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
                System.out.println(usern);
            env.put(Context.SECURITY_PRINCIPAL, usern);
	    env.put(Context.SECURITY_CREDENTIALS, password);


		SearchControls searchCtrls = new SearchControls();
		searchCtrls.setReturningAttributes(new String[] {});
		searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		String filter = "(&(departmentNumber=" + "C10DB03DB030135" + "))";

		DirContext ctx = null;
		try {try {
                    gxml.refreshxml();
                } catch (Exception ex) {
                    Logger.getLogger(LDAPAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
                }
			ctx = new InitialDirContext(env);
               
            
                                            try { users = new ArrayList(new HashSet(pxml.xmlparse("DISPLAY_NAME", "users.xml")));
                                            } catch (Exception ex) {
                                                     Logger.getLogger(LDAPAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
                            
                                            }
                                            session.put("logged-in", username);
                try {
                    getuserid();
                } catch (Exception ex) {
                    Logger.getLogger(LDAPAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
                }   
                try {
                    useridatm = new ArrayList(new HashSet(pxml.xmlparse("USER_ID", "userid.xml")));
                } catch (Exception ex) {
                    Logger.getLogger(LDAPAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
                }
                userid = useridatm.get(0).toString();
                                            session.put("user-id", userid);
                        if(users.contains(username))
                        { 
                        return SUCCESS;
                        }
                        else 
                        {    
                        try {
                            iu.insertuser(); 
                            gxml.refreshxml();
                            return SUCCESS;
                           
                        } catch (Exception ex) {
                            Logger.getLogger(LDAPAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
                                try {
                                    gxml.refreshxml();
                                } catch (Exception ex1) {
                                    Logger.getLogger(LDAPAuthenticator.class.getName()).log(Level.SEVERE, null, ex1);
                                }
                            return ERROR;
                        }
                      
                        }
                        
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        return ERROR;
		}
		
	}
    public void getuserid() throws Exception{
       
        gxml.createxml("users", "*", "DISPLAY_NAME = \""+username+"\"", 1, "userid");
    }
}
