package com.robertozimek.chatserver;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;


/**
 * @author      Robert Ozimek
 * @version     1.0                 (current version number of the class)
 */

public class ChatThread extends Thread {
    private Socket socket = null;
    private int idThread = -1;
    private DataInputStream dataInputStream = null;
    
    /*
     * ChatThread Constructor
     * @param socket instance of Socket object 
     */
    
    public ChatThread(Socket socket) {
        this.socket = socket;
        this.idThread = socket.getPort();
    }
    
    public void run() {
        System.out.println("Chat Thread " + idThread + " running.");
        while(true) {
            try {
                System.out.println(dataInputStream.readUTF());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Opens input stream
    public void openStream() throws IOException {
        dataInputStream = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
    }
    
    // Closes stream and socket
    public void close() throws IOException {
        if(dataInputStream != null) { dataInputStream.close(); }
        if(socket != null) { socket.close(); }
    }
}


