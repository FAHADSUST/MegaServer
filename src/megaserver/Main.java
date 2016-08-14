/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaserver;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fahad-PC
 */


public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static DBConnector dbConnector;
    
    public static GsonMaker gsMaker;
    
    public static void main(String[] args) throws SQLException, IOException, Exception {
        // TODO code application logic here
        
        System.out.println("Hello ");
        gsMaker = new GsonMaker();
        dbConnector = new DBConnector();
        dbConnector.createConnection();
        ResultSet rs =  dbConnector.queryResult("select * from person");
        
        String jsonData = gsMaker.GetJsonData(rs);
        
        System.out.println(jsonData);
        
        TCPServer tcpServer = new TCPServer();
        Thread thread = new Thread(tcpServer);
        thread.start();
        
        System.out.println("Here");
        
    }
    
}
