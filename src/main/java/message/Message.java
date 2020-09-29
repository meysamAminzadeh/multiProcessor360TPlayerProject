package message;


import player.IGeneralMessagingBetweenObjects;

/**
 * This class is used to create a message between two objects in the program.
 * The advantage is that it can be used between all objects in the program
 * (two players - or any object that may be created later in the program).
 * @author Meysam Aminzadeh on 7/31/2020.
 */
public class Message {

    /**
     * The object that receives the message
     */
    IGeneralMessagingBetweenObjects recieverObject;

    /**
     * The object that send the message
     */
    IGeneralMessagingBetweenObjects senderObject;
    /**
     * message text
     */
    String message;

    /**
     * Specifies the status of a message
     */
    MessageStatus messageStatus;

    public IGeneralMessagingBetweenObjects getRecieverObject() {
        return recieverObject;
    }

    public void setRecieverObject(IGeneralMessagingBetweenObjects recieverObject) {
        this.recieverObject = recieverObject;
    }

    public IGeneralMessagingBetweenObjects getSenderObject() {
        return senderObject;
    }

    public void setSenderObject(IGeneralMessagingBetweenObjects senderObject) {
        this.senderObject = senderObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Message(IGeneralMessagingBetweenObjects recieverObject, String message, MessageStatus messageStatus) {
        this.recieverObject = recieverObject;
        this.message = message;
        this.messageStatus = messageStatus;
    }


}
