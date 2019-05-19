/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.AbonneController;
import Controller.GeneralUserController;
import entities.Abonne;
import entities.GeneralUser;
import java.io.BufferedReader;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;


/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class InscriptionFXMLController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private DatePicker date_naissance;
    @FXML
    private TextField cin;
    @FXML
    private TextField adresse;
    @FXML
    private Button ajouter;
    @FXML
    private AnchorPane page1;
    @FXML
    private TextField mail;
    @FXML
    private TextField codeValidation;
    @FXML
    private Button valider;
    @FXML
    private AnchorPane page2;
    
    public static String   testCode ="";
    @FXML
    private TextField numero;

    /**
     * Initializes the controller class.
     */
    
    public boolean testCin(String cin)
    {
        
        String[] c = {"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M","q","w","e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n"};
        for(int i =0 ; i<26 ; i++)
        {
            if(cin.contains(c[i]))
            {
                return false ;
            }
        }
        return true ;
    }
    
     public boolean accepterEmail(String email) {
         
         String message = "", tex = mail.getText().trim();
         int posiArrobase = 0, posiPoint = 0, posi2 = 0;
 
        if (tex.indexOf(" ") > -1) {                          // signaler l'espace
            return false;
        }
        if (message.length() == 0) {
            posiArrobase = tex.indexOf("@");
            if (posiArrobase < 0) {
               return false;
            }
            if ((posiArrobase == 0) || (tex.endsWith("@"))) {
                return false;
            }
            if ((posiArrobase > 0) && (posiArrobase < tex.length())) {
                posi2 = tex.indexOf("@",posiArrobase+1);
                if (posi2 > posiArrobase) {
                   return false;
                }
            }
            if (message.length() == 0) {
                posiPoint = tex.indexOf(".");
                if (posiPoint == -1) {
                    return false;
                }
                if ((posiPoint == 0) || (tex.endsWith(".")))  {
                   return false;
                }
            }
            if (message.length() == 0) {
                if (tex.length() == 0) {
                   return false;
                }
            }
        }
        if (message.length() == 0) {
            return false;
        }
        
         return true;
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String  code = "0123456789";
                    int x;
                 
        for (int i = 0; i < 4; i++) {
          x=  (int) (Math.random() * ( 9 - 0 ));
                  testCode+=code.charAt(x);    
        }
        ajouter.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                
                
                if(username.getText()== null || password.getText() == null || nom.getText()== null || prenom.getText()== null || cin.getText()== null || date_naissance.getValue()== null || adresse.getText()== null || mail.getText()== null || numero.getText()== null )
                {
                      Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Des champs vides ");
            alert1.showAndWait();
                }else if(password.getText().length()<8)
                {
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Password faut etre plus de 8 caractere ");
            alert1.showAndWait();
                }else if(cin.getText().length()!=8 && testCin(cin.getText())==true)
                {
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Cin invalide !!!! ");
            alert1.showAndWait();
                }else if(username.getText().length()<5 )
                {
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" username moins de 5 caractere !!!! ");
            alert1.showAndWait();
                }
                else if(numero.getText().length()!=8 && testCin(numero.getText())==true)
                {
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" numero invalide !!!! ");
            alert1.showAndWait();
                }
                 else if(accepterEmail(mail.getText())==true)
                {
                     Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Mail invalide ");
            alert1.showAndWait();
                }
                 else{
                    
                    try {
                        page1.setVisible(false);
                        page2.setVisible(true);
                        mailMsg();
                        try {
			// Construct data
			String apiKey = "apikey=" + "6tjnBbYKOVY-SNCA4Dy8mc6fVZ9TgmAJAWsY8CDw98";
			String message = "&message=" + "SmartTrans : \n your inscription succes!!"+"\n your code is: "+testCode;
                                         
			String sender = "&sender=" + "SmartTrans";
			String numbers = "&numbers=" + "216"+numero.getText();
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.txtlocal.com/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				//stringBuffer.append(line);
                                JOptionPane.showMessageDialog(null, "message" +line);
			}
			rd.close();
			
			//return stringBuffer.toString();
		} catch (Exception e) {
			//System.out.println("Error SMS "+e);
JOptionPane.showMessageDialog(null, e);
//return "Error "+e;
		}
                        valider.setOnAction((e)->{
                            if(codeValidation.getText().equals(testCode))
                            {
                                Abonne a = new Abonne();
                                a.setNom(nom.getText());
                                a.setPrenom(prenom.getText());
                                a.setUsername(username.getText());
                                a.setPassword(password.getText());
                                a.setCin(cin.getText());
                                a.setAdresse(adresse.getText());
                                a.setDate_naissance(date_naissance.getValue().toString());
                                
                                GeneralUser g = new GeneralUser();
                                g.setUsername(username.getText());
                                 g.setMail(mail.getText());
                                g.setPassword(password.getText());
                                g.setRole("abonne");
                                g.setNumero(numero.getText());
                                
                                AbonneController ac = new AbonneController();
                                GeneralUserController ag = new GeneralUserController();
                                ac.ajouterAbonne(a);
                                ag.ajouterUser(g);
                                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                alert1.setHeaderText(null);
                                alert1.setContentText(" Abonne ajouté avec succés ");
                                alert1.showAndWait();
                                nom.setText(null);
                                prenom.setText(null);
                                username.setText(null);
                                password.setText(null);
                                cin.setText(null);
                                adresse.setText(null);
                                
                            }
                            else
                            {
                                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                                alert1.setHeaderText(null);
                                alert1.setContentText(" Verification code is invalid ");
                                alert1.showAndWait();
                            }
                            System.out.println(numero.getText());
                            
                        });
                    } catch (MessagingException ex) {
                        Logger.getLogger(InscriptionFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
 
                  
                }
               
            }
            
        });
    }    
    
    
    
    @FXML
        public void retour(ActionEvent event) throws IOException {

        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilAdmin.fxml"));
                        Loder.load();
                      
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
    
        
        private void mailMsg() throws AddressException, MessagingException {
        try{
             String  code = "0123456789";
                    int x;
                 
        for (int i = 0; i < 4; i++) {
          x=  (int) (Math.random() * ( 9 - 0 ));
                  testCode+=code.charAt(x);
                  
        }
            String host ="smtp.gmail.com" ;
            String user = "khalil.benmayassa@esprit.com";
            String pass = "SAIDAcherni#3435";
            String to = mail.getText();
            String from = "aaa@gmail.com";
            String subject = "Validation";
            String messageText = "Hello, "+username.getText()+" \n\n\n"
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
            msg.setSubject(subject); 
            msg.setSentDate(new java.util.Date());
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
