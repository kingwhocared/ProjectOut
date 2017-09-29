package com.out.MessagesContentView;

/**
 * Created by Victor on 21/09/2017.
 */

import com.out.PrivateChatScreen.Chat;

import java.util.Random;

public class ChatMessage {

    public String body, sender, receiver, senderName;
    public String Date, Time;
    public String msgid;
    public boolean isMine;// Did I send the message.
    public Chat chatPartOf;

    public ChatMessage(String Sender, String Receiver, String messageString,
                       String ID, boolean isMINE, Chat chatPartOf) {
        this.chatPartOf = chatPartOf;
        body = messageString;
        isMine = isMINE;
        sender = Sender;
        msgid = ID;
        receiver = Receiver;
        senderName = sender;
    }

    public void setMsgID() {

        msgid += "-" + String.format("%02d", new Random().nextInt(100));
        ;
    }
}