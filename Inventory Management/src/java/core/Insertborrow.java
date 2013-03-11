package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import mysql.MySqlConnector;



/**
 * <p> Validate a user login. </p>
 */
public  class Insertborrow  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
 
  
 private String userid;
 private String itemid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }
   
  
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 Date date = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String formattedDate = sdf.format(date);
String defaulttime = "0000-00-00 00:00:00";

 int val = stmt.executeUpdate("INSERT INTO borrowed (ITEM_ID, USER_ID,DATE_BORROWED,DATE_RETURNED) VALUES('"+getItemid()+"','"+getUserid()+"','"+formattedDate+"','"+defaulttime+"')"); 
 con.close();
  if(val == 0){
  return ERROR;
 
  }
  else{
  return SUCCESS;
  
  }
  
        
  }


}
