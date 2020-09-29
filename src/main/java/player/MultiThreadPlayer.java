package player;

import comunicationOutput.OutPut;
import message.Message;

import java.io.File;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Show a player who has the ability to multiprocess and
 * be able to send and receive messages with other players
 *
 * @author Meysam Aminzadeh on 7/31/2020.
 */
public class MultiThreadPlayer implements IGeneralMessagingBetweenObjects,Runnable {
    /**
     * Player name
     */
    private String playerName;

    /**
     * Keep capacitystaus of each player which I can understand how many message
     * recieve from each players
     */
    private final Map<MultiThreadPlayer, Integer> capacityStauts = new HashMap<>();


    /**
     *
     * @param playerName
     */
    public MultiThreadPlayer(String playerName) {
        this.playerName = playerName;
    }

    @Override
    /**
     * Send a message to another player
     * @param Message get message with receiveplayer, message text ,
     *                and message status content
     * @return return message after make it on receiveMessage method
     */
    public String sendMessage(Message message) {
        MultiThreadPlayer player = (MultiThreadPlayer) message.getRecieverObject();


        Integer counter = findCountSendMessage(this);

        if (counter == 11) {
            return "exit";
        }
        OutPut.write(this.playerName + " sent a message '" + message.getMessage() + "' to "
                + player.getPlayerName(), player.getPlayerName());

        return player.receiveMessage(this, message, player);


    }

    @Override
    /**
     * get me the last count of capacity for each players
     * @param IGeneralMessagingBetweenObjects player that I need capacity counter
     * @return return capacity counter
     */
    public int findCountSendMessage(IGeneralMessagingBetweenObjects player) {
        return capacityStauts.getOrDefault(player, 0);
    }

    /**
     * this method get receive message and make reply message
     *
     * @param rPlayer show reciever player
     * @param message show message that receive
     * @param tPlayer show players that want to it message
     * @return return  reply message
     */
    public String receiveMessage(MultiThreadPlayer rPlayer, Message message, MultiThreadPlayer tPlayer) {
        Integer counter = findCountSendMessage(rPlayer) + 1;
        capacityStauts.put(rPlayer, counter);
        String returnMessage = rPlayer.playerName + " received a (counter: " + counter + ") message '" + message.getMessage()
                + "' from " + tPlayer.playerName;

        OutPut.write(returnMessage, tPlayer.getPlayerName());

        return returnMessage;
    }


    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

        if(playerName.equals("initiator")){
            System.out.println("intialer start");

        }
        if(playerName.equals("player2")){
            System.out.println("player start");
        }

    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }




}
