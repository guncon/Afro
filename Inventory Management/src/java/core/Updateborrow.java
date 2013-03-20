package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mysql.MySqlConnector;
import org.apache.struts2.ServletActionContext;



/**
 * <p> Validate a user login. </p>
 */
public  class Updateborrow  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
 private String query = "";
 private String userid;
 private SendMailSSL sml = new SendMailSSL();
 private ArrayList itemlist;
 private int itemid;
 private getXML gxml = new getXML();
 private ArrayList itemidlist;
 private parseXML pxml = new parseXML();
    private String query2;

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public ArrayList getItemlist() {
        return itemlist;
    }

    public void setItemlist(ArrayList itemlist) {
        this.itemlist = itemlist;
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
query = "update borrowed set DATE_RETURNED = ? where ITEM_ID = ? AND USER_ID = ? AND DATE_RETURNED = '0000-00-00 00:00:00'";
PreparedStatement preparedStmt = con.prepareStatement(query);
preparedStmt.setString(1, formattedDate);
preparedStmt.setInt(2,  getItemid());
preparedStmt.setString(3,  userid);
preparedStmt.executeUpdate();
query2 = "update items set Isborrowed = ? where ITEM_ID = ?";
PreparedStatement preparedStmt2 = con.prepareStatement(query2);
preparedStmt2.setInt(1, 0);
preparedStmt2.setInt(2, getItemid());
preparedStmt2.executeUpdate();
con.close();
gxml.createxml("items", "*", "ITEM_ID = \""+getItemid()+"\"", 1, "itemid");
itemidlist = new ArrayList(pxml.xmlparse("NAME", "itemid.xml"));
String device = itemidlist.get(0).toString();
String username = session.getAttribute("logged-in").toString();
sml.sendmailreturn(username, device);

 
  return SUCCESS;
  
  
  
        
  }


}
