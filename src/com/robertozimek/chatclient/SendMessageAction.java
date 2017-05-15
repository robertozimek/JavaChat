package com.robertozimek.chatclient;

import java.awt.event.ActionEvent;

import javax.swing.*;

public class SendMessageAction extends AbstractAction {
    private static final long serialVersionUID = -8086044726216236584L;
                        
    public SendMessageAction(String desc) {
        super(desc);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Send Button Pressed");
    }

}
