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
  
     private String ID = null;


  public String getID() {
  return ID;
  }
  public void setID(String value) {
  ID = value;
  }

  
  private String name = null;



  public String getNAME() {
  return name;
  }

  public void setNAME(String value) {
  name = value;
  }
   private int prodid = 0;
   public int getPRODID() {
  return prodid;
  }

  public void setPRODID(int value) {
  prodid = value;
  }
  private int itemtypeid = 0;
   public int getITEMTYPEID() {
  return itemtypeid;
  }

  public void setITEMTYPEID(int value) {
  itemtypeid = value;
  }
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 

 int val = stmt.executeUpdate("INSERT INTO items (ITEM_ID,NAME,PROD_ID,ITEM_TYPE_ID) VALUES('"+getID()+"','"+getNAME()+"','"+getPRODID()+"','"+getITEMTYPEID()+"')"); 
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
