package com.out;

import java.util.List;

/**
 * Created by Victor on 06/10/2017.
 */

public class MessageHub {
    private static MessageHub messageHub = null;
    private MessageSubscriber messageSubscriber = null;
    private MessageHub() {

    }
    public static MessageHub getInstance() {
        if(messageHub == null) {
            messageHub = new MessageHub();
        }
        return messageHub;
    }

    public void setSubscirber(MessageSubscriber messageSubscriber) {
        this.messageSubscriber = messageSubscriber;
    }

    public void addMessage(Object message) {
        if (this.messageSubscriber != null){
            this.messageSubscriber.recieve(message);
        }
    }
}

