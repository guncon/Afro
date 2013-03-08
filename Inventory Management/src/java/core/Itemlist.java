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
    
    private List list = null;
     private List list2 = null;
     private ArrayList temp;
     private ArrayList temp2;
 
    public List getList2() {
        return list2;
    }

    public void setList2(List list2) {
        this.list2 = list2;
    }
    public List getList(){
        return list;
    }
     public void setList(List list) {
        this.list = list;
    }

    public String execute() throws Exception {
       
        temp = new ArrayList();
        temp2 = new ArrayList();
        
       File items = new File("items.xml");
DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(items);
doc.getDocumentElement().normalize();
NodeList nodes = doc.getElementsByTagName("Row");

for (int i = 0; i < nodes.getLength(); i++) {
Node node = nodes.item(i);

if (node.getNodeType() == Node.ELEMENT_NODE) {
Element element = (Element) node;
temp.add(getValue("PROD_ID", element));
temp2.add(getValue("ITEM_TYPE_ID", element));
}
list = new ArrayList(new HashSet(temp));
list2 = new ArrayList(new HashSet(temp2));
}


        return SUCCESS;
    
    }
private static String getValue(String tag, Element element) {
NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
Node node = (Node) nodes.item(0);
return node.getNodeValue();
}




}
