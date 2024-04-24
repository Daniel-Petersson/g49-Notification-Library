package se.lexicon.util;

import se.lexicon.exception.EmailException;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    private static final String USERNAME = "test@test.com";
    private static final String PASSWORD = "password";

    public static void sendEmail(String recipient, String subject, String message) throws EmailException {
        // Step 1: Set up email server properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Step 2: Create a Session object using specified properties and Authenticator
        // Session represents the settings for sending emails, like the mail server and authentication details.
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(USERNAME, PASSWORD);
            }
        });

        try {


        /*
            A MimeMessage is essentially an email message in a format that allows for various types of content,
            like plain text, HTML, attachments, and inline images.
            It provides methods to set the sender, recipients, subject, and content of the email.
         */
            Message mimeMessage = new MimeMessage(session);

            // Step 4: Set the sender of the email
            /*
                InternetAddress is a class in JavaMail API used to handle email addresses.
                It helps in creating, formatting, and validating email addresses according to Internet standards.
                In the code, it's used to represent the sender's email address before setting it in the email message.
                It ensures that the email address is correctly formatted.
             */
            Address myAddress = new InternetAddress(USERNAME);
            mimeMessage.setFrom(myAddress);
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(message);

            Transport.send(mimeMessage);
            System.out.println("Email sent successfully to: " + recipient);

        } catch (MessagingException e) {
            throw new EmailException("Failed to send Email." + e.getMessage());
        }

    }


}
