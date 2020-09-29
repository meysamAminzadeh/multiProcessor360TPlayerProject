package player;

import message.Message;

/**
 * The main interface of the program, which can implement
 * its methods in different classes, such as players or any
 * other class that is created later in the program to send
 * messages between objects.
 *
 * @author Meysam Aminzadeh on 7/31/2020.
 */
public interface IGeneralMessagingBetweenObjects  {
     String sendMessage(Message message);
     int findCountSendMessage(IGeneralMessagingBetweenObjects player);

}
