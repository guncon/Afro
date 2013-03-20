package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mysql.MySqlConnector;
import org.apache.struts2.ServletActionContext;



/**
 * <p> Validate a user login. </p>
 */
public  class Insertborrow  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;

 


 private int itemid;
    private String query;
    private String userid;
    private getXML gxml = new getXML();
    private parseXML pxml = new parseXML();
    private SendMailSSL sml = new SendMailSSL();
    private ArrayList itemidlist;
    private ArrayList itemlist;
    private ArrayList userlist;
    

    public ArrayList getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList itemlist) {
        this.itemlist = itemlist;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public ArrayList getUserlist() {
        return userlist;
    }

    public void setUserlist(ArrayList userlist) {
        this.userlist = userlist;
    }






   
  
  public String execute() throws Exception {
 HttpServletRequest request = ServletActionContext.getRequest();
 HttpSession session = request.getSession();
userid = session.getAttribute("user-id").toString();


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

 int val = stmt.executeUpdate("INSERT INTO borrowed (ITEM_ID, USER_ID,DATE_BORROWED,DATE_RETURNED) VALUES('"+getItemid()+"','"+userid+"','"+formattedDate+"','"+defaulttime+"')"); 
 query = "update items set Isborrowed = ? where ITEM_ID = ?";


PreparedStatement preparedStmt = con.prepareStatement(query);
preparedStmt.setInt(1, 1);
preparedStmt.setInt(2, getItemid());
preparedStmt.executeUpdate();
gxml.refreshxml();
gxml.createxml("items", "*", "ITEM_ID = \""+getItemid()+"\"", 1, "itemid");
itemidlist = new ArrayList(pxml.xmlparse("NAME", "itemid.xml"));
String device = itemidlist.get(0).toString();
String username = session.getAttribute("logged-in").toString();
sml.sendmailborrow(username, device);

 con.close();
  if(val == 0){
  return ERROR;
 
  }
  else{
  return SUCCESS;
  
  }
  
        
  }


}
