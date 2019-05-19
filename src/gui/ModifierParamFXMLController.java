/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.AbonneController;
import entities.Abonne;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class ModifierParamFXMLController implements Initializable {

    @FXML
    private TextField nouveauNom;
    @FXML
    private TextField nouveauPrenom;
    @FXML
    private TextField nouveauPass;
  

     Abonne a = new Abonne();
        AbonneController ac = new AbonneController();
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
    
        
         public void recevoirAbonne(String cin)
    {
        
        a= ac.getAbonneByCIN(cin);
       
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
    
   
   
    @FXML
    public void modifierNom(ActionEvent event) throws IOException {
        
                    ac.modifierNomAbonne(a, nouveauNom.getText());
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" Nom Modifié avec succés  ");
            alert1.showAndWait();
            
                    FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilAdmin.fxml"));
                        Loder.load();
                        
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
    
    @FXML
        public void modifierPrenom(ActionEvent event) throws IOException {
        
                    ac.modifierPrenomAbonne(a, nouveauPrenom.getText());
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" Prenom Modifié avec succés  ");
            alert1.showAndWait();
            
                    FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilAdmin.fxml"));
                        Loder.load();
                      
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
        
        
        
    @FXML
        public void modifierPass(ActionEvent event) throws IOException {
        
                    ac.modifierPasswordAbonne(a, nouveauPass.getText());
                     Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" mot de passe Modifié avec succés  ");
            alert1.showAndWait();
            
                    FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilAdmin.fxml"));
                        Loder.load();
                       
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
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
    
}
