package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.Statement;
import mysql.MySqlConnector;



/**
 * <p> Validate a user login. </p>
 */
public  class Insertproduct  extends ActionSupport {
  private MySqlConnector mysql = new MySqlConnector();
  private Connection con;
  private Statement stmt;
  
 private String prodname;
 private String proddesc;
 private getXML gxml = new getXML();

    public String getProdname() {
        return prodname;
    }

    public void setProdname(String prodname) {
        this.prodname = prodname;
    }

    public String getProddesc() {
        return proddesc;
    }

    public void setProddesc(String proddesc) {
        this.proddesc = proddesc;
    }
 
  public String execute() throws Exception {

  try{
  
  con=mysql.getConnection();
  stmt=con.createStatement();
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }

 

 int val = stmt.executeUpdate("INSERT INTO products (NAME,DESCRIPTION) VALUES('"+getProdname()+"','"+getProddesc()+"')"); 
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
