/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import com.opensymphony.xwork2.ActionSupport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mysql.MySqlConnector;

/**
 *
 * @author samsung
 */
public class Itemlist extends ActionSupport{
    private MySqlConnector mysql = new MySqlConnector();
    private List list = null;

    
     private List list2 = null;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
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
        list = new ArrayList();
        list2 = new ArrayList();
        String query = "SELECT * from items";
        con = mysql.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
while(rs.next()){
       
        list.add(rs.getString("PROD_ID"));
        list2.add(rs.getInt("ITEM_TYPE_ID"));
}   
    con.close();
rs.close();

        return SUCCESS;
    
    }


}
