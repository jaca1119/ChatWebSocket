package com.itvsme.ChatWebSocket;

public class OutputMessage
{
    private String userName;
    private String messageContent;
    private String outputTime;

    public OutputMessage(String userName, String messageContent, String outputTime)
    {
        this.userName = userName;
        this.messageContent = messageContent;
        this.outputTime = outputTime;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getMessageContent()
    {
        return messageContent;
    }

    public void setMessageContent(String messageContent)
    {
        this.messageContent = messageContent;
    }

    public String getOutputTime()
    {
        return outputTime;
    }

    public void setOutputTime(String outputTime)
    {
        this.outputTime = outputTime;
    }
}
