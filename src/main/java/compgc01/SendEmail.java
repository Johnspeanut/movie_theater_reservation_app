package compgc01;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * A class that allows the sending of emails to customers of our application.
 * Uses the JavaMail library by http://www.oracle.com/technetwork/java/index-138643.html
 * and is adapted from the example at https://www.mkyong.com/java/javamail-api-sending-email-via-gmail-smtp-example/.
 *
 * @author Qiong Peng
 * @since May/05/2021
 */
public class SendEmail {

    static void sendEmail(String recipient, String type) {

        final String username = "qiongpengcinema@gmail.com";
        final String password = "qiongpengcinema123";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("qiongpengcinema@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(recipient));
            
            if (type.equals("reminder")) {
            message.setSubject("Booking Confirmation");
            message.setText("Dear " + Main.getCurrentUser().getFirstName() + ",\n\n" +
                    "Your booking for the film " + Main.getSelectedFilmTitle() + " has been confirmed. Please, keep this email as proof of your booking.\n\nLooking forward to seeing you on " + Main.getSelectedDate() +
                    ", at " + Main.getSelectedTime() + "!\n\nStay Awesome!,\nManager");
            }
            else {
                message.setSubject("Feedback");
                message.setText("Customer: " + Main.getCurrentUser().getUsername() + "\nFilm: " + Main.feedbackFilmTitle +
                        "\nStars: " + Main.stars +
                        "\nExperience: " + Main.experience + "\nComment: " + Main.comment
                        );
            }
            
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}