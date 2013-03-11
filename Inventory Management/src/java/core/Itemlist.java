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
public class Itemlist extends ActionSupport{
    
    private ArrayList prodidlist = null;
     private ArrayList itemtypeidlist = null;
    private String xmlname = "items.xml";
    
     private parseXML pxml = new parseXML();

    public ArrayList getProdidlist() {
        return prodidlist;
    }

    public void setProdidlist(ArrayList prodidlist) {
        this.prodidlist = prodidlist;
    }

    public ArrayList getItemtypeidlist() {
        return itemtypeidlist;
    }

    public void setItemtypeidlist(ArrayList itemtypeidlist) {
        this.itemtypeidlist = itemtypeidlist;
    }
 
 
 

    public String execute() throws Exception {


prodidlist = new ArrayList(new HashSet(pxml.xmlparse("PROD_ID", xmlname)));
itemtypeidlist = new ArrayList(new HashSet(pxml.xmlparse("ITEM_TYPE_ID", xmlname)));



        return SUCCESS;
    
    }

    private static String getValue(String tag, Element element) {
NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
Node node = (Node) nodes.item(0);
return node.getNodeValue();
}
}





