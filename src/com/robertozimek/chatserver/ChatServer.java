package com.robertozimek.chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author      Robert Ozimek
 * @version     1.0                 (current version number of the class)
 */

public class ChatServer implements Runnable {
    private ServerSocket serverSocket = null;
    private Thread clientWaitingThread = null;
    private ChatThread chatClient = null;
    
    /*
     * ChatServer Constructor
     * @param port port the server should listen on for new clients
     */
    
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
        while(clientWaitingThread != null) {
            try {
                System.out.println("Waiting for client...");
                addChatThread(serverSocket.accept());
            } catch (IOException e) {
                System.out.println("Error accepting cleint: " + e);
            }
        }
        
    }
    
    /*
     * Creates a thread for a client
     * @param socket Socket client was accepted on
     */
    
    public void addChatThread(Socket socket) {
        System.out.println("Client accepted on socket: " + socket);
        chatClient = new ChatThread(socket);
        try {
            chatClient.openStream();
            chatClient.start();
        } catch (IOException e){
            System.out.println("Error starting thread: " + e);
        }
    }
}
