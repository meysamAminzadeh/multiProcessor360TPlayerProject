

import message.Message;
import message.MessageStatus;
import org.junit.Before;
import org.junit.Test;
import player.IGeneralMessagingBetweenObjects;
import player.MultiThreadPlayer;

import static org.junit.Assert.*;

/**
 * @author Meysam Aminzade on 8/1/2020.
 */

public class UnitTests {
    private IGeneralMessagingBetweenObjects initiator;
    private IGeneralMessagingBetweenObjects player2;

    /**
     * Create two players, initiator and player2
     */
    @Before
   public void initialization() {
        initiator = new MultiThreadPlayer("initiator");
        player2 = new MultiThreadPlayer("player2");
    }

    /**
     * Initiator sends a message to player2
     */
    @Test
    public void sendMessageToPlayer2() {
        assertNotNull(initiator.sendMessage(new Message(player2,"hello", MessageStatus.SEND)));
    }

    /**
     * When initiator sends a message to player2, check if player2 received the same message
     */
    @Test
    public void whenInitiatorSendsMessageToPlayer_thenPlayer2SendsBackMessageWithCounter() {
        String receivedMessage = initiator.sendMessage(new Message(player2,"this is test message", MessageStatus.SEND));
        assertEquals("initiator received a (counter: 1) message 'this is test message' from player2", receivedMessage);
    }


}

