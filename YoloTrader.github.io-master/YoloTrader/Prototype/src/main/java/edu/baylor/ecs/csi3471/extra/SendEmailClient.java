package edu.baylor.ecs.csi3471.extra;

import edu.baylor.ecs.csi3471.presentation.UI.form.Email;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * could possibly use
 */
public class SendEmailClient extends JFrame {
    private JTextField fromField = new JTextField();
    private JLabel toField = new JLabel(Email.companyEmail);
    private JTextField subjectField = new JTextField();
    private JComboBox<String> mailSmtpHostComboBox = new JComboBox<>();
    private JTextField usernameField = new JTextField();
    private JPasswordField passwordField = new JPasswordField();
    private JTextArea contentTextArea = new JTextArea();

    private SendEmailClient() {
        InitializeUI();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SendEmailClient client = new SendEmailClient();
            client.setVisible(true);
        });
    }

    private void InitializeUI() {
        setTitle("Send E-mail Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(400, 280));

        getContentPane().setLayout(new BorderLayout());

        // Header Panel
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new GridLayout(6, 2));
        headerPanel.add(new JLabel("From:"));
        headerPanel.add(fromField);

        headerPanel.add(new JLabel("To:"));
        headerPanel.add(toField);

        headerPanel.add(new JLabel("Subject:"));
        headerPanel.add(subjectField);

        headerPanel.add(new JLabel("STMP Server:"));
        headerPanel.add(mailSmtpHostComboBox);
        mailSmtpHostComboBox.addItem("smtp.gmail.com");
        mailSmtpHostComboBox.addItem("smtp.mail.me.com");

        headerPanel.add(new JLabel("Username:"));
        headerPanel.add(usernameField);

        headerPanel.add(new JLabel("Password:"));
        headerPanel.add(passwordField);

        // Body Panel
        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(new BorderLayout());
        bodyPanel.add(new JLabel("Message:"), BorderLayout.NORTH);
        bodyPanel.add(contentTextArea, BorderLayout.CENTER);

        JPanel footerPanel = new JPanel();
        footerPanel.setLayout(new BorderLayout());
        JButton sendMailButton = new JButton("Send E-mail");
        sendMailButton.addActionListener(new SendEmailActionListener());

        footerPanel.add(sendMailButton, BorderLayout.SOUTH);

        getContentPane().add(headerPanel, BorderLayout.NORTH);
        getContentPane().add(bodyPanel, BorderLayout.CENTER);
        getContentPane().add(footerPanel, BorderLayout.SOUTH);
    }

    private class SendEmailActionListener implements ActionListener {
        SendEmailActionListener() {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Properties props = new Properties();
            props.put("mail.smtp.host", mailSmtpHostComboBox.getSelectedItem());
            props.put("mail.transport.protocol", "smtp");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

            // property for sending an email from an icloud email associated with Apple
            props.put("smtp.mail.me.com", "587");

            Session session = Session.getDefaultInstance(props);
            try {
                InternetAddress fromAddress = new InternetAddress(fromField.getText());
                InternetAddress toAddress = new InternetAddress(toField.getText());

                Message message = new MimeMessage(session);
                message.setFrom(fromAddress);
                message.setRecipient(Message.RecipientType.TO, toAddress);
                message.setSubject(subjectField.getText());
                message.setText(contentTextArea.getText());

                Transport.send(message, usernameField.getText(),
                        new String(passwordField.getPassword()));
            } catch (MessagingException ex) {
                ex.printStackTrace();
            }
        }
    }
}