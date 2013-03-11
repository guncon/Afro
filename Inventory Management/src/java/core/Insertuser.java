package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.Statement;
import mysql.MySqlConnector;



/**
 * <p> Validate a user login. </p>
 */
public  class Insertuser  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
  
  private String userid;
  private String username;
  private String ldapid;
  private int groupid;
  private int permid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLdapid() {
        return ldapid;
    }

    public void setLdapid(String ldapid) {
        this.ldapid = ldapid;
    }

    public int getGroupid() {
        return groupid;
    }

    public void setGroupid(int groupid) {
        this.groupid = groupid;
    }

    public int getPermid() {
        return permid;
    }

    public void setPermid(int permid) {
        this.permid = permid;
    }

   
  
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 

 int val = stmt.executeUpdate("INSERT INTO users (USER_ID,DISPLAY_NAME,LDAP_ID,GRP_ID,PERM_ID) VALUES('"+getUserid()+"','"+getUsername()+"','"+getLdapid()+"','"+getGroupid()+"','"+getPermid()+"')"); 
 con.close();
  if(val == 0){
  return ERROR;
 
  }
  else{
  return SUCCESS;
  
  }
  
        
  }


}
