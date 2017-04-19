package com.robertozimek.chatserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @author      Robert Ozimek
 * @version     1.0                 (current version number of the class)
 */

public class ChatServer implements Runnable {
    private ServerSocket serverSocket = null;
    
    
    public ChatServer(int port) {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started: " + serverSocket);   
        } catch (IOException e) {
            System.out.println("Failed to listen on port: " + port);
            System.out.println(e);
        }
    }
    

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
    }
}
