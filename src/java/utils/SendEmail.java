/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import tblUser.UserDTO;

/**
 *
 * @author lehuuhieu
 */
public class SendEmail {

    public void sendEmail(String email, String code) throws Exception {

        //recipient: nguoi nhan
        String recipient = email;

        String myEmail = "hoangpreyt01@gmail.com";
        String password = "cksipybnabumwjyr";

        Properties prop = new Properties();
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myEmail, password);
            }

        });
        Message message = prepareMessage(session, myEmail, recipient, code);

        Transport.send(message);
    }

    public static Message prepareMessage(Session session, String myEmail, String recipient, String code) {
        Message message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(myEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Confirm your account");
            message.setText("Hi ! \nPlease verfiry your account using this code: " + code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return message;
    }
}
