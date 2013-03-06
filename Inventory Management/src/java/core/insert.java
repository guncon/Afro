package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.Statement;
import mysql.MySqlConnector;



/**
 * <p> Validate a user login. </p>
 */
public  class insert  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
  
     private int ID = 0;


  /**
 * <p>Provide User username.</p>
 *
 * @return Returns the User username.
 */
  public int getID() {
  return ID;
  }

  /**
 * <p>Store new User username</p>
 *
 * @param value The username to set.
 */
  public void setID(int value) {
  ID = value;
  }

  // ---- Username property ----

  /**
 * <p>Field to store User password.</p>
 * <p/>
 */
  private String name = null;


  /**
 * <p>Provide User password.</p>
 *
 * @return Returns the User password.
 */
  public String getNAME() {
  return name;
  }

  /**
 * <p>Store new User password</p>
 *
 * @param value The password to set.
 */
  public void setNAME(String value) {
  name = value;
  }
  
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 

 int val = stmt.executeUpdate("INSERT INTO employees (name) VALUES('"+getNAME()+"')"); 
 con.close();
  if(val == 0){
  return ERROR;
 
  }
  else{
  return SUCCESS;
  
  }
  
        
  }
//    public void validate() {
//        if (getNAME().length() == 0) {
//            addFieldError("NAME", "User Name is required");
//        } else if (!getNAME().equals("Eswar")) {
//            addFieldError("NAME", "Invalid User");
//        }
//       
//    }

}
