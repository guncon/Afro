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
  
  private String itemid;
  private String itemname;
  private int prodid;
  private int itemtypeid;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }

    public int getItemtypeid() {
        return itemtypeid;
    }

    public void setItemtypeid(int itemtypeid) {
        this.itemtypeid = itemtypeid;
    }
  
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 

 int val = stmt.executeUpdate("INSERT INTO items (ITEM_ID,NAME,PROD_ID,ITEM_TYPE_ID) VALUES('"+getItemid()+"','"+getItemname()+"','"+getProdid()+"','"+getItemtypeid()+"')"); 
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
