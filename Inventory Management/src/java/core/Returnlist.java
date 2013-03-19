/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import notused.Login;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mysql.MySqlConnector;
import org.apache.struts2.ServletActionContext;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author samsung
 */
public class Returnlist extends ActionSupport{
    

     private ArrayList borroweditem = null;

    
     private parseXML pxml = new parseXML();
     private getXML gxml = new getXML();
     private Login login = new Login();
     private String userid;




    public ArrayList getBorroweditem() {
        return borroweditem;
    }

    public void setBorroweditem(ArrayList borroweditem) {
        this.borroweditem = borroweditem;
    }




 
 

    public String execute() throws Exception {
 HttpServletRequest request = ServletActionContext.getRequest();
 HttpSession session = request.getSession();
userid = session.getAttribute("logged-in").toString();
gxml.createxml("borrowed", " ITEM_ID,USER_ID ", "USER_ID = "+userid+" AND DATE_RETURNED = 0000-00-00", 1,"borrowedbyuser");
borroweditem = new ArrayList(pxml.xmlparse("ITEM_ID", "borrowedbyuser.xml"));


        return SUCCESS;
    
    }


}





