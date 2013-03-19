import com.opensymphony.xwork2.ActionSupport;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;


public class LDAPAuthenticator extends ActionSupport {
    private  String username;
    private  String password;

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
    
    
	 public String execute() 
	{   String usern =" uid="+getUsername()+",ou=auth,o=sec" ;
                
       
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, "ldap://165.213.248.99:11389");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
//	    env.put(Context.SECURITY_PRINCIPAL, "uid=iggy.tan,ou=auth,o=sec");
            env.put(Context.SECURITY_PRINCIPAL, usern);
	    env.put(Context.SECURITY_CREDENTIALS, getPassword());


		SearchControls searchCtrls = new SearchControls();
		searchCtrls.setReturningAttributes(new String[] {});
		searchCtrls.setSearchScope(SearchControls.SUBTREE_SCOPE);

		String filter = "(&(departmentNumber=" + "C10DB03DB030135" + "))";

		DirContext ctx = null;
		try {
			ctx = new InitialDirContext(env);
//			NamingEnumeration<SearchResult> answer = ctx.search(
//					   "ou=emp, ou=reg, o=sec", filter, searchCtrls);
//
//			String fullDN = null;
//			while (answer.hasMore()) {
//			    fullDN = answer.next().getNameInNamespace();
//			    System.out.println(fullDN + "\n");
//			}
                        return SUCCESS;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
                        return ERROR;
		}
		
	}
}
