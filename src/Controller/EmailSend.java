package Controller;

/**
 *
 * @author Naveen
 */
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.internet.MimeMessage;
public class EmailSend {

    public static String host ="smtp.gmail.com" ;
    public static String user = "khalil.benmayassa@esprit.tn";
    public static String pass = "SAIDAcherni#3435";
    public static String to = "ghazi_slema@outlook.fr";
    public static String from = "khalil.benmayassa@esprit.tn";
    public static String username="";
    public static String tripid="";
    public static String testCode ;
    public static void main(String args[]){
        try{
           String  code = "0123456789";
                    int x;
                 String   testCode ="";
        for (int i = 0; i < 4; i++) {
          x=  (int) (Math.random() * ( 9 - 0 ));
                  testCode+=code.charAt(x);
                  
        }
        
            System.out.println(testCode);
    

            String subject ="Smart Roots notification";
            String messageText = "Hello, "+username+" \n\n\n"
                    + "Your confirmation code is : "
                    + testCode;
            boolean sessionDebug = false;

            Properties props = System.getProperties();

            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.required", "true");

            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
            Session mailSession = Session.getDefaultInstance(props, null);
            mailSession.setDebug(sessionDebug);
            Message msg = new MimeMessage(mailSession);
            msg.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            msg.setRecipients(Message.RecipientType.TO, address);
            msg.setSubject(subject); msg.setSentDate(new Date());
            msg.setText(messageText);

           Transport transport=mailSession.getTransport("smtp");
           transport.connect(host, user, pass);
           transport.sendMessage(msg, msg.getAllRecipients());
           transport.close();
           System.out.println("message send successfully");
        }catch(Exception ex)
        {
            System.out.println(ex);
        }

    }
    
}