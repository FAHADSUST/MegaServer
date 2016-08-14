/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaserver;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBConnector
{

    public String url, dbName, driver, userName, password;
    Connection conn;
    public DBConnector() 
    {
        url = "jdbc:mysql://localhost:3306/";
        dbName = "imgjosh_db";
        driver = "com.mysql.jdbc.Driver";
        userName = "imgjosh_user";
        password = "123456789";
    }

    public void createConnection()
    {
        try {
            Class.forName(driver).newInstance();
            conn=(Connection) DriverManager.getConnection(url + dbName+"?useUnicode=true&characterEncoding=utf-8", userName, password);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oppps");
        }
    }

    public void closeConnection() throws SQLException
    {
      conn.close();
    }
 
    public void queryExecute(String query) throws SQLException
    {
        createConnection();
        Statement st = conn.createStatement();
        st.executeUpdate(query);       
        closeConnection();
        System.out.println("Query Executed");
    }
    public ResultSet queryResult(String query) throws SQLException
    {
        createConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);
        /*while(rs.next())
        {
            System.out.println(rs.getInt("person_id"));
            System.out.println(rs.getString("person_name"));
        }*/
        return rs;
    }
}