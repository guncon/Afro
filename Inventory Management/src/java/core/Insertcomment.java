package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mysql.MySqlConnector;
import org.apache.struts2.ServletActionContext;




public  class Insertcomment extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;

 


 private String itemid;
 private String comment;
    private String userid;
    private getXML gxml = new getXML();





    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
   
  
  public String execute() throws Exception {
 HttpServletRequest request = ServletActionContext.getRequest();
 HttpSession session = request.getSession();
userid = session.getAttribute("logged-in").toString();
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


 int val = stmt.executeUpdate("INSERT INTO comments (ITEM_ID, USER_ID,TEXT,DATE_COMMENT) VALUES('"+getItemid()+"','"+userid+"','"+getComment()+"','"+formattedDate+"')"); 


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
