package uz.pdp.shaftoli.service.service;

import org.springframework.stereotype.Service;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Service
public class EmailCodeServiceImpl implements EmailCodeService {

    public String SendAndReturnCodeToEmail(String email) {
        String username = "shaftolipayment@gmail.com";
        String password = "afarznnpqykhkvps";
        Session session = getSession(getProperties(), username, password);

        MimeMessage message = new MimeMessage(session);

        String emailCode = String.valueOf(new Random().nextInt(900000) + 100000);

        try {
            message.setContent(
                    "<h3>Your verification code:<h3>" +
                            "<h1>"+ emailCode + "</h1>" , "text/html");

            message.setSubject("Verification");
            message.setFrom(new InternetAddress(username));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            Transport.send(message);
            System.out.println("Successfully sent");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return emailCode;
    }

    private static Properties getProperties(){
        Properties properties = new Properties();

        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");
        return properties;
    }

    public static Session getSession(Properties properties, String username, String password) {
        return Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
    }
}
