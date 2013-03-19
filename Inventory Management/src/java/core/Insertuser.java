package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import mysql.MySqlConnector;
import org.apache.struts2.ServletActionContext;



/**
 * <p> Validate a user login. </p>
 */
public  class Insertuser{
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
  private getXML gxml = new getXML();
  



   
  
  public void insertuser() throws Exception{
      
            HttpServletRequest request = ServletActionContext.getRequest();
            HttpSession session = request.getSession();
           String userid = session.getAttribute("logged-in").toString();
             try{
             
             con=mysql.getConnection();
             stmt=con.createStatement();
            
             }
             catch(Exception e){
             System.out.println(e.getMessage());
             }

 

           
             int val = stmt.executeUpdate("INSERT INTO users (DISPLAY_NAME,GRP_ID,PERM_ID) VALUES('"+userid+"','1','1')"); 
             gxml.refreshxml();
             con.close();
       
        }
  

  
        
  }



