package edu.baylor.ecs.csi3471.presentation.UI.form;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

/**
 * @author owenmurphy
 */
public class Email {

    public static String companyEmail = "volatiles.stocks@gmail.com";
    public static String host = "localhost";

    public static void getEmailWarning() {
        JOptionPane.showMessageDialog(null, "Unique email is required",
                "Warning", JOptionPane.WARNING_MESSAGE);
    }

    public static void sendEmail(String email, String subject, String text) {
        Properties properties = System.getProperties();

        properties.setProperty("mail.smtp.host", host);

        Session session = Session.getDefaultInstance(properties);

        try {

            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(email));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(companyEmail));

            message.setSubject(subject);

            message.setText(text);

            Transport.send(message);
            System.out.println("Sent Successfully!");

        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

}
