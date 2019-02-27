/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;


import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author LENGUE
 */
public class EmailSender {
  private String smtpServer;
  private String port;
  private String user;
  private String password;
  private String auth;
  private String from;

    public EmailSender(String smtpServer, String port, String user, String password, String auth, String from) {
        this.smtpServer = smtpServer;
        this.port = port;
        this.user = user;
        this.password = password;
        this.auth = auth;
        this.from = from;
    }
  
    private Properties prepareProperties(){
       Properties props = new Properties();
       props.setProperty("mail.smtp.host", smtpServer);
       props.setProperty("mail.smtp.port", port);
       props.setProperty("mail.smtp.auth", auth);
       props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
       return props;
   }
					
					
   private MimeMessage prepareMessage(Session mailSession,String charset,String from, String subject,String HtmlMessage,String[] recipient) {
        //Multipurpose Internet Mail Extensions
        MimeMessage message = null;
        try {
            message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(from));
            message.setSubject(subject);
            for (int i=0;i<recipient.length;i++)
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient[i]));
            message.setContent(HtmlMessage, "text/html; charset=\""+charset+"\"");
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(EmailSender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
   }
					
					
   public void sendEmail(String subject,String HtmlMessage,String[] to) {
        try {
            Authenticator authenticator = new Authenticator() {
                //override the getPasswordAuthentication method
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(from, password);
                }
            };     
            Properties props = prepareProperties();
            Session mailSession = Session.getDefaultInstance( props,authenticator);
            mailSession.setDebug(true);
            MimeMessage message = prepareMessage(mailSession, "ISO-8859-2",from, subject, HtmlMessage, to);
            Transport.send(message);
        } catch (Exception ex) {ex.printStackTrace(); }
   }
}

