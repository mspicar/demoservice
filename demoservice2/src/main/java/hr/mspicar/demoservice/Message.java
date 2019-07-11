/**
 * FOI 2019. 
 * Kolegij: Sigurnost informacijskih sustava
 *
 * Author: mario.spicar@gmail.com
 * 
 */
package hr.mspicar.demoservice;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * Poruka (REST servisa)
 * 
 */

@JsonInclude(JsonInclude.Include.NON_NULL)

public class Message {
            
    private Integer messageID;
    private String messageDescription;

    public Message() {
    }

    public Message(Integer messageID, String messageDescription) {
        this.messageID = messageID;
        this.messageDescription = messageDescription;
    }

    public Integer getMessageID() {
        return messageID;
    }

    public void setMessageID(Integer messageID) {
        this.messageID = messageID;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    @Override
    public String toString() {
        return "Message{" + "messageID=" + messageID + ", messageDescription=" + messageDescription + '}';
    }
}