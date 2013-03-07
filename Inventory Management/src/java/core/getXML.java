/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import mysql.MySqlConnector;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author samsung
 */
public class getXML extends ActionSupport{
    private MySqlConnector mysql = new MySqlConnector();
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    
    
public String execute() throws Exception {
       
        String query = "SELECT * from items";
        con = mysql.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.newDocument();
    Element results = doc.createElement("Results");
    doc.appendChild(results);
     ResultSetMetaData rsmd = rs.getMetaData();
    int colCount = rsmd.getColumnCount();
while(rs.next()){
             Element row = doc.createElement("Row");
      results.appendChild(row);
      for (int i = 1; i <= colCount; i++) {
        String columnName = rsmd.getColumnName(i);
        Object value = rs.getObject(i);
        Element node = doc.createElement(columnName);
        node.appendChild(doc.createTextNode(value.toString()));
        row.appendChild(node);
    
}   
}
      DOMSource domSource = new DOMSource(doc);
    TransformerFactory tf = TransformerFactory.newInstance();
    Transformer transformer = tf.newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.setOutputProperty(OutputKeys.METHOD, "xml");
    transformer.setOutputProperty(OutputKeys.ENCODING, "ISO-8859-1");
    transformer.setOutputProperty(OutputKeys.INDENT, "yes");
    
    
    StreamResult sr = new StreamResult(new File("output.xml"));
    transformer.transform(domSource, sr);

    con.close();
rs.close();

       
     return SUCCESS;
    } 
          
}


