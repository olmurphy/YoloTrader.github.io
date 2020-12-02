package edu.baylor.ecs.csi3471.presentation.ui.form;

import edu.baylor.ecs.csi3471.main.YoloTrader;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;
import java.util.Random;

/**
 * @author owenmurphy
 */
public class Email {

    /** represents the company email */
    public static String companyEmail = "volatiles.stocks@gmail.com";

    /**
     * dialog responsible for letting the user know that the email was not unique upond creating
     * an account with YoloTrader
     */
    public static void getEmailWarning() {
        JOptionPane.showMessageDialog(null, "Unique email is required",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * sends an email from Company email to the recipients ${@param email}
     *
     * @param email user's email
     * @param subject subject line of email
     * @param text description of email
     */
    public static void sendEmail(String email, String subject, String text) {

        // sending from company email
        String from = Email.companyEmail;

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        // Get the default Session object.
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() { return new PasswordAuthentication(Email.companyEmail, "Hint@123"); }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));

            // Set Subject: header field
            message.setSubject(subject);

            // Now set the actual message
            message.setText(text);

            // Send message
            Transport.send(message);
            YoloTrader.logger.info("Sent message successfully....");
        } catch (MessagingException mex) { mex.printStackTrace(); }
    }

    /**
     * Dialog asks for the user to enter email to send the new password associated with email
     * @return email that user inputs
     */
    public static String getEmailInputDialog() {
        return JOptionPane.showInputDialog(null, "input email",
                "Pass Recovery", JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * method invokes a dialog letting the user know that the email entered to send an new
     * recovery password to was not associated with any account
     */
    public static void getEmailNotFound() {
        JOptionPane.showMessageDialog(null, "Email is not associated with any account",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * this method generates a random string of length 18 with A-Z chars and 0-9 integers
     * @return random string
     */
    public static String getRandomString() {
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ALPHABET.length());
            salt.append(ALPHABET.charAt(index));
        }
        return salt.toString();
    }

    public static String getRandomNumberString () {
        String ALPHABET = "1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * ALPHABET.length());
            salt.append(ALPHABET.charAt(index));
        }
        return salt.toString();
    }

    /**
     * opens dialog letting user know the password to email was successfully changed and the new password
     * was email to the
     */
    public static void getPasswordChangedSuccessful() {
        JOptionPane.showMessageDialog(null, "Password successfully changed, check your " +
                "email inbox for it.");
    }

    /** opens dialog telling user that the email input is not valid */
    public static void getEmailNotValidWarning() {
        JOptionPane.showMessageDialog(null, "Email is not valid.",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    /**
     * takes the email and calls ${@link #sendEmail(String, String, String)} to send email of the
     * salt string generated from ${@link #getRandomNumberString()}
     * asks the user to input the code sent and checks if it is valid. Allows user up to 3 tries.
     * @param email email to send message to
     * @return true if user input the right code, false after 3 failed attempts
     */
    public static boolean getEmailSentCodeValidation(String email) {
        String actualCode = getRandomNumberString();

        sendEmail(email, "Code to Validate email", actualCode);
        int count = 1;

        do {
            String code = JOptionPane.showInputDialog(null, "Email with code has been sent." +
                            "\nInput code: (Attempt: " + count + " of 3)", "Email Validation", JOptionPane.QUESTION_MESSAGE);

            if (code.equals(actualCode)) { return true; }
            else { count++; }

        } while (count < 4);

        JOptionPane.showMessageDialog(null, "Code is not valid: ");
        return false;
    }

    /** opens dialog letting user know the they have not entered the right code to validate email after 3 failed attempts */
    public static void getEmailValidationCodeNotValid() {
        JOptionPane.showMessageDialog(null, "Code is not valid", "Warning", JOptionPane.WARNING_MESSAGE);
    }
}
