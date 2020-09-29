package comunicationInput;

/**
 * To create the object, an attempt has been made to use a factory design pattern
 * to make it easier to manage the instantiation of the object during program development.
 * @author Meysam Aminzadeh on 8/2/2020.
 */
public class FactoryCommunicationType {


    /**
     * Manages the instantiation of objects from different classes of information input.
     *
     * @param comunicationType help to instance object
     * @return Application required object.
     */
    public static ComunicationUI factoryComunicationtype(String comunicationType) {

        ComunicationUI instance = null;

        switch (comunicationType) {

            case "file": {
                instance = CommunicationWithFile.instanceForCommunicationWithFile();
                break;
            }


        }

        return instance;

    }
}
