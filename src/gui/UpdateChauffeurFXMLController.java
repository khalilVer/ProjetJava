/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.ChauffeurController;
import Controller.GeneralUserController;
import Controller.LigneController;
import entities.Chauffeur;
import entities.GeneralUser;
import entities.Ligne;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class UpdateChauffeurFXMLController implements Initializable {

    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private TextField cin;
    @FXML
    private TextField adresse;
    @FXML
    private ComboBox<Ligne> listeLigne;
    @FXML
    private DatePicker date_naissance;
    ObservableList<Ligne> AllLigne = FXCollections.observableArrayList();
    @FXML
    private Button modifier;
    @FXML
    private TextField mail;
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
        
//         username.setPromptText();
//        password.setPromptText();
//        nom.setPromptText();
//        prenom.setPromptText();
//        cin.setPromptText();
//        adresse.setPromptText();
//        date_naissance.setPromptText();
//          mail.setPromptText();
//          numero.setPromptText();
        
        recupererLigne();
       
        
        
         modifier.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    if(username.getText()== null || password.getText() == null || nom.getText()== null || prenom.getText()== null || cin.getText()== null || date_naissance.getValue()== null || adresse.getText()== null || listeLigne.getValue()== null || mail.getText()== null || numero.getText()== null  )
                {
                      Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Des champs vides ");
            alert1.showAndWait();
                }
                    
                    else if(password.getText().length()<8)
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
 Chauffeur a = new Chauffeur();
                a.setNom(nom.getText());
                a.setPrenom(prenom.getText());
                a.setUsername(username.getText());
                a.setPassword(password.getText());
                a.setCin(cin.getText());
                a.setAdresse(adresse.getText());
                a.setDate_naissance(date_naissance.getValue().toString());
                a.setNomLigne(listeLigne.getValue().toString());
                a.setDispo(1);
                a.setNbTacheTotal(0);
                a.setNbTacheParJour(0);
                
                 GeneralUser g = new GeneralUser();
                                g.setUsername(username.getText());
                                 g.setMail(mail.getText());
                                g.setPassword(password.getText());
                                g.setRole("chauffeur");
                                g.setNumero(numero.getText());
                                
                                
                                GeneralUserController ag = new GeneralUserController();
           
                ChauffeurController ac = new ChauffeurController();
                ac.updateChauffeur(a); 
                ag.updateUser(g);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" Chauffeur modifié avec succés ");
            alert1.showAndWait();
            
                
                    }
               
            }
        });
        
    }    
    
     public void recupererLigne() {

        AllLigne.clear();
        List<Ligne> list = null;
        LigneController ac = new  LigneController();
        list = ac.findAll();
        for (Ligne ligne : list) {
        
            
            AllLigne.add(new Ligne(ligne.getId(), ligne.getNom(), ligne.getMoyentransport()));
        }
       
        listeLigne.setItems(AllLigne);
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
         FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilChauffeur.fxml"));
                        Loder.load();
                      
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
    
}
