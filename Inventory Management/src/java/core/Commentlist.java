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
public class Commentlist extends ActionSupport{
    
     private ArrayList itemid = null;


     private getXML gxml = new getXML();
    
     private parseXML pxml = new parseXML();


    public ArrayList getItemid() {
        return itemid;
    }

    public void setItemid(ArrayList itemid) {
        this.itemid = itemid;
    }






 
 

    public String execute() throws Exception {
gxml.refreshxml();
itemid = new ArrayList(new HashSet(pxml.xmlparse("ITEM_ID", "items.xml")));


        return SUCCESS;
    
    }


}





