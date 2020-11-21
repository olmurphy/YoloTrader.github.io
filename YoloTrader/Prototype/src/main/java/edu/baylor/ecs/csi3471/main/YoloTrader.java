package edu.baylor.ecs.csi3471.main;

import edu.baylor.ecs.csi3471.presentation.UI.mainPage.MainPanel;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

/**
 * @author owenmurphy
 */
public class YoloTrader {

    public static Logger logger = Logger.getLogger(YoloTrader.class.getName());

    static {
        try {
            InputStream configFile = YoloTrader.class.getClassLoader().getResourceAsStream("logger.properties");
            LogManager.getLogManager().readConfiguration(configFile);
            assert configFile != null;
            configFile.close();
        } catch (IOException ex) {
            System.out.println("WARNING: Could not open configuration file");
            System.out.println("WARNING: Logging not configured (console output only)");
        }
        logger.info("starting the app");
    }

    public static void main(String[] args) {


        MainPanel.getStartFrame();


        // String email, String subject, String text /

        //Email.sendEmail("owen261@icloud.com", "Test", "Hi!");
    }
    /*public static void main(String [] args) {


        // Recipient's email ID needs to be mentioned.
        String to = "owen261@icloud.com";

        // Sender's email ID needs to be mentioned
        String from = Email.companyEmail;

        // Assuming you are sending email from localhost
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");



        // Setup mail server
        //properties.setProperty("mail.smtp.host", host);

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(Email.companyEmail, "Hint@123");

            }
        });

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("This is the Subject Line!");

            // Now set the actual message
            message.setText("This is actual message");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }*/
}
