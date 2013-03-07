/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


/**
 *
 * @author samsung
 */
public class MySqlConnector {
    
public Connection getConnection(){
     String url = "jdbc:mysql://localhost:3306/";
  String dbName = "assetdb";
  String driverName = "com.mysql.jdbc.Driver";
  String userName = "root";
  String password = "root";
  Connection con=null;
  Statement stmt=null;
 try{
  Class.forName(driverName).newInstance();
//  con=DriverManager.getConnection(url+dbName, userName, 
//  password);
  con =  DriverManager.getConnection(url+dbName, userName, password);
 
  }
  catch(Exception e){
  System.out.println(e.getMessage());
  }
 return con;
}
}
