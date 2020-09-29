package comunicationInput;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * This class is designed to enter information (messages sent from the initialer) through a file.
 * The class is designed as a singleton because there is no need to rebuild the object for this class.
 * The class is defined as final because there is no need to extend this class.
 * <p>
 *
 * @author Meysam Aminzadeh on 8/2/2020.
 */
public final class CommunicationWithFile implements ComunicationUI {

    /**
     * static object for CommunicationWithFile (help in singlton)
     */
    public static CommunicationWithFile communicationWithFile = null;


    /**
     *  class default constructor
     */
    private CommunicationWithFile() {
    }


    /**
     * This method was created to build the Singleton object for this class.
     *
     * @return return an object of class type
     */
    public static CommunicationWithFile instanceForCommunicationWithFile() {

        if (communicationWithFile != null)
            return communicationWithFile;
        else
            return new CommunicationWithFile();
    }


    /**
     * This method generates messages using the input file so that the initialer
     * can send these messages to the next player.
     */
    @Override
    public void makeCommunicationInfoBetween2Player() {

        File file = new File("text.txt");

        byte[] bytesArray = new byte[(int) file.length()];


        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytesArray);

            System.setIn(new ByteArrayInputStream(bytesArray));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
