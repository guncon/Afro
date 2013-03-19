package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.Statement;
import mysql.MySqlConnector;



/**
 * <p> Validate a user login. </p>
 */
public  class Insertitemtype  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
  
 private String itemtypename;
private getXML gxml = new getXML();
    public String getItemtypename() {
        return itemtypename;
    }

    public void setItemtypename(String itemtypename) {
        this.itemtypename = itemtypename;
    }
 
 
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 

 int val = stmt.executeUpdate("INSERT INTO item_types (NAME) VALUES('"+getItemtypename()+"')"); 
 gxml.refreshxml();
 con.close();
  if(val == 0){
  return ERROR;
 
  }
  else{
  return SUCCESS;
  
  }
  
        
  }


}
