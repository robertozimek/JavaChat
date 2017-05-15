package com.robertozimek.chatclient;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class ChatView {

    public static void render() {
        JFrame mainFrame = new JFrame("Chat Window");
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainFrame.setSize(640, 300);
        mainFrame.setLocationRelativeTo(null);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BorderLayout());

        JTextArea chatTextArea = new JTextArea();
        chatTextArea.setEditable(false);
        textPanel.add(chatTextArea, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        JTextField chatInputField = new JTextField();
        inputPanel.add(chatInputField, BorderLayout.CENTER);
        

        Action sendAction = new SendMessageAction("Send");

        JButton sendButton = new JButton(sendAction);
        inputPanel.add(sendButton, BorderLayout.EAST);
        mainFrame.getRootPane().setDefaultButton(sendButton);


        Container contentPane = mainFrame.getContentPane();
        contentPane.add(textPanel, BorderLayout.CENTER);
        contentPane.add(inputPanel, BorderLayout.SOUTH);


        mainFrame.setVisible(true);
    }

}
