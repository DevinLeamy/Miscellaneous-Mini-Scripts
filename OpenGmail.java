//To run this program you will have to download and install JavaMail https://www.oracle.com/technetwork/java/javase/overview/index.html
//As well as javax.activation https://mvnrepository.com/artifact/javax.activation/activation/1.1.1

import java.util.*;
import javax.mail.*;

public class OpenGmail {
    public static void main(String[] args){
        int port = 993;
        String username = "email";
        String password = "password";
        String hostAccount = "imap.gmail.com";


        Properties properties = System.getProperties();
        properties.setProperty("mail.store.protocol", "imaps");
        properties.setProperty("mail.imaps.host", "imap.gmail.com");
        properties.setProperty("mail.imaps.port", String.valueOf(port));

        try {
            Session session = Session.getInstance(properties,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });
            Store store = session.getStore("imaps");
            store.connect(hostAccount, username, password);

            System.out.println("Connected to Gmail Account");

            Folder inbox = store.getFolder("[Gmail]/Sent Mail");
            inbox.open(Folder.READ_ONLY);

            int count = inbox.getMessageCount();
            Message[] messages = inbox.getMessages();
            for (int i = (count - 3); i < count; i++){
                System.out.println("From: " + Arrays.toString(messages[i].getFrom()));
                System.out.println("Date: " + messages[i].getSentDate());
                System.out.println("Subject: " + messages[i].getSubject());
                System.out.println("********************");
                System.out.println("********************");
            }

        } catch (NullPointerException npe){
            npe.printStackTrace();
        } catch (NoSuchProviderException e){
            e.printStackTrace();
        } catch (MessagingException me){
            me.printStackTrace();
        }
    }
}
