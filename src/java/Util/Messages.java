/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Matthew
 */
public class Messages {

    private String _message;

    private MessageType _level;
    
    public Messages(){}

    public Messages(String Message) 
    {
        this._message = Message;
    }

    public Messages(String Message, MessageType MessageType) 
    {
        this.setMessage(Message);
        this.setLevel(MessageType);
    }

    /**
     * @return the _message
     */
    public String getMessage() {
        return _message;
    }

    /**
     * @param _message the _message to set
     */
    public void setMessage(String _message) {
        this._message = _message;
    }

    /**
     * @return the _level
     */
    public MessageType getLevel() {
        return _level;
    }

    /**
     * @param _level the _level to set
     */
    public void setLevel(MessageType _level) {
        this._level = _level;
    }


}
