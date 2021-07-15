package de.dummyapt.internship.email;

/**
 * Interface providing methods for {@link EmailService}
 */
public interface EmailSender {

    /**
     * Method to send an email via {@link EmailService}
     * @param to Receiver address
     * @param email Sender address
     */
    void send(String to, String email);
}