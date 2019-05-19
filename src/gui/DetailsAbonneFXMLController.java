/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.AbonneController;
import entities.Users;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class DetailsAbonneFXMLController implements Initializable {

    @FXML
    private Label nom;
    @FXML
    private Label dateNaissance;
    @FXML
    private Label prenom;
    @FXML
    private Label cin;
    @FXML
    private Label adresse;
    @FXML
    private Label user;
    @FXML
    private Label username;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnTarif;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;

    /**
     * Initializes the controller class.
     */
    
    public void showinItems(String user,String nom,String prenom,String cin,String date,String adresse){
       
         this.user.setText(user);
        this.nom.setText(nom);
        this.prenom.setText(prenom);
        this.cin.setText(cin);
        this.dateNaissance.setText(String.valueOf(date));
        this.adresse.setText(adresse);
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     
        
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
       
     
         
             public void modifier(ActionEvent event) throws IOException {

        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("UpdateAbonneFXML.fxml"));
                        Loder.load();
                        ModifierParamFXMLController display = Loder.getController();
                        display.recevoirAbonne(cin.getText());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
    
}
