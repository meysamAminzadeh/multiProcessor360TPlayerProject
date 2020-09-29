package message;

/**
 * This enum class is not very efficient in this program in practice,
 * but if the program wants to develop and the status of messages
 * in different modes is important to us, then it is a good capability.
 * @author Meysam Aminzadeh on 7/31/2020.
 */
public enum MessageStatus {
    SEND, RECIEVE, WAIT;
}
