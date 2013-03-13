/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import mysql.MySqlConnector;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author samsung
 */
public class Borrowlist extends ActionSupport{
    
    private ArrayList userid = null;
     private ArrayList itemid = null;
     private ArrayList borroweditem = null;
     private ArrayList borrower = null;
    
     private parseXML pxml = new parseXML();

    public ArrayList getUserid() {
        return userid;
    }

    public void setUserid(ArrayList userid) {
        this.userid = userid;
    }

    public ArrayList getItemid() {
        return itemid;
    }

    public void setItemid(ArrayList itemid) {
        this.itemid = itemid;
    }

    public ArrayList getBorroweditem() {
        return borroweditem;
    }

    public void setBorroweditem(ArrayList borroweditem) {
        this.borroweditem = borroweditem;
    }

    public ArrayList getBorrower() {
        return borrower;
    }

    public void setBorrower(ArrayList borrower) {
        this.borrower = borrower;
    }


 
 

    public String execute() throws Exception {


itemid = new ArrayList(new HashSet(pxml.xmlparse("ITEM_ID", "items.xml")));
userid = new ArrayList(new HashSet(pxml.xmlparse("USER_ID", "users.xml")));
borroweditem = new ArrayList(pxml.xmlparse("ITEM_ID", "borrowed.xml"));
borrower = new ArrayList(pxml.xmlparse("USER_ID", "borrowed.xml"));



        return SUCCESS;
    
    }


}





