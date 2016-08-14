/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megaserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fahad-PC
 */
public class TCPServer implements Runnable
{
    String clientSentence;
    String capitalizedSentence;
    String outToclientString;
    
    ServerSocket mySocket;
    
    TCPServer() throws IOException
    {
        mySocket = new ServerSocket(6789);
    }

    @Override
    public void run() 
    {
        while(true)
        {
            try {
                Socket connectionSocket = mySocket.accept();
                
                BufferedReader inFromClient = new BufferedReader (new InputStreamReader (connectionSocket.getInputStream()));
                
                clientSentence = inFromClient.readLine();
                System.out.println(clientSentence);
                
                DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
                
                capitalizedSentence = clientSentence.toUpperCase() + "\r\n";
                
                //ResultSet rs = Main.dbConnector.queryResult("select * from person");
                //outToclientString = Main.gsMaker.GetJsonData(rs);
                
                
                outToclientString = "I have received: " + clientSentence;
                outToClient.writeBytes(outToclientString);
                
            } catch (Exception ex) {
                Logger.getLogger(TCPServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
    }
    
    
    
}
