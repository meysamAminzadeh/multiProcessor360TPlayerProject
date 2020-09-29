import comunicationInput.ComunicationUI;
import comunicationInput.FactoryCommunicationType;
import message.Message;
import message.MessageStatus;
import player.MultiThreadPlayer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class starts comunication between two players
 * * @author Meysam Aminzadeh on 7/31/2020.
 */

public class MainClass {
    /**
     * The job of this method is to create an object from the InititClass class
     * and call the main methods of the program.
     *
     * @author Meysam Aminzadeh on 7/31/2020.
     */
    public static void main(String[] args) {

        InititClass init = new InititClass();
        init.prepareInputFile();
    }


}