package com.springbootwebsocket.model;

public class WsMessage {
    private String sender;
    private String content;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "WsMessage{" +
                "sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
