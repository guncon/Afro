package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import mysql.MySqlConnector;



/**
 * <p> Validate a user login. </p>
 */
public  class Updateborrow  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
 private String query = "";
  
 private String userid;
 private String itemid;
    private String query2;

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
query = "update borrowed set DATE_RETURNED = ? where ITEM_ID = ? AND USER_ID = ? AND DATE_RETURNED = '0000-00-00 00:00:00'";
PreparedStatement preparedStmt = con.prepareStatement(query);
preparedStmt.setString(1, formattedDate);
preparedStmt.setString(2,  getItemid());
preparedStmt.setString(3,  getUserid());
preparedStmt.executeUpdate();
query2 = "update items set Isborrowed = ? where ITEM_ID = ?";
PreparedStatement preparedStmt2 = con.prepareStatement(query2);
preparedStmt2.setInt(1, 0);
preparedStmt2.setString(2, getItemid());
preparedStmt2.executeUpdate();
con.close();


 
  return SUCCESS;
  
  
  
        
  }


}
