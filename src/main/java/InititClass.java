import comunicationInput.ComunicationUI;
import comunicationInput.FactoryCommunicationType;
import message.Message;
import message.MessageStatus;
import player.MultiThreadPlayer;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This class is a initit class and prepares the program for further tasks with the help of its methods.
 * @author Meysam Aminzade on 8/2/2020.
 */
public class InititClass {

    public MultiThreadPlayer player1;
    public MultiThreadPlayer player2;

    /**
     * This method is used to prepare the type of input and messages of the program.
     */
    public void prepareInputFile() {
        ComunicationUI comunicationUI = FactoryCommunicationType.factoryComunicationtype("file");
        comunicationUI.makeCommunicationInfoBetween2Player();
        playComunication();
    }

    /**
     * This method is used to start the resume and start transmitting messages
     * between two players in multiprocess.
     */

    public void playComunication() {
        player1 = new MultiThreadPlayer("initiator");
        player2 = new MultiThreadPlayer("player2");

        Thread initiator = new Thread(player1) {
            @Override
            public void run() {
                super.run();
                satrtIntiatorPlayer();
            }
        };
        initiator.start();

        Thread otherPlayer = new Thread(player2) {
            @Override
            public void run() {
                super.run();
                satrtOtherPlayer();
            }
        };
        otherPlayer.start();
    }

    /**
     * This method sends messages from the initiator as a thread (server)
     * and receives messages from another player. Exit from the
     * program is also done by this method.
     */

    public void satrtIntiatorPlayer() {

        ServerSocket server;
        int port = 9876;
        try {
            server = new ServerSocket(port);
            Scanner sc = new Scanner(System.in);
            int counter = 0;
            otter:
            while (true) {
                Socket socket = server.accept();
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                String message = (String) ois.readObject();
                if (!message.equals(" I am ready to recieve message")) {
                    String returnStringFromObject = player1.sendMessage(new Message(player2, message, MessageStatus.SEND));
                }
                System.out.println(" Intialier thread reicieve  message ");
                Thread.sleep(1000);
                if (counter != 10) {
                    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(sc.nextLine());
                    System.out.println(" Intialier thread send  message ");
                    counter++;
                    ois.close();
                    oos.close();
                    socket.close();
                } else {
                    break otter;
                }
            }

            sc.close();
            server.close();
            System.exit(0);
        } catch (Exception e) {
            System.out.println("error : " + e.toString());
        }
    }

    /**
     * This method is designed as a second Thread for the second player
     * that receives messages from the initiator and returns
     * the appropriate message.
     */
    public void satrtOtherPlayer() {
        Socket socket = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        String message = " I am ready to recieve message";
        try {
            while (true) {
                socket = new Socket("localhost", 9876);
                oos = new ObjectOutputStream(socket.getOutputStream());
                oos.writeObject(message);
                System.out.println(" player2 thread send message ");
                ois = new ObjectInputStream(socket.getInputStream());
                message = (String) ois.readObject();
                System.out.println(" player2 thread recieve message ");
                ois.close();
                oos.close();
            }
        } catch (Exception e) {
            System.out.println(" Intialtor finish chat");
        }
    }
}
