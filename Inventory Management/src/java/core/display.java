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
public class display extends ActionSupport{
    private MySqlConnector mysql = new MySqlConnector();
    private List<displayer> list = null;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    public List<displayer> getList(){
        return list;
    }
     public void setList(List<displayer> list) {
        this.list = list;
    }

    public String execute() throws Exception {
        list = new ArrayList<displayer>();
        String query = "SELECT * from employees";
        con = mysql.getConnection();
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);
        
while(rs.next()){
        displayer bean = new displayer();
       bean.setName(rs.getString("name"));
       bean.setId(rs.getInt("emp_id"));
       
        list.add(bean);
}
    

        return SUCCESS;
    
    }


}
