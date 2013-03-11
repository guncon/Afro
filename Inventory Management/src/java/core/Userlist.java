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
public class Userlist extends ActionSupport{
    
    private ArrayList groupid = null;
     private ArrayList permid = null;
   
    
     private parseXML pxml = new parseXML();

    public ArrayList getGroupid() {
        return groupid;
    }

    public void setGroupid(ArrayList groupid) {
        this.groupid = groupid;
    }

    public ArrayList getPermid() {
        return permid;
    }

    public void setPermid(ArrayList permid) {
        this.permid = permid;
    }

 
 
 

    public String execute() throws Exception {


groupid = new ArrayList(new HashSet(pxml.xmlparse("GRP_ID", "groups.xml")));
permid = new ArrayList(new HashSet(pxml.xmlparse("PERM_ID", "permission.xml")));



        return SUCCESS;
    
    }


}





