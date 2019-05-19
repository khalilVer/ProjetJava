/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import Controller.LigneController;
import Controller.TarifController;
import Controller.LigneController;

import entities.Ligne;
import entities.Ligne;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class AjouterTarifFXMLController implements Initializable {

    @FXML
    private TextField prix;
    @FXML
    private ComboBox<Ligne> ListeLigne;

    ObservableList<Ligne> AllLigne = FXCollections.observableArrayList();
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recupererLigne();
         FXMLLoader loader = new FXMLLoader();
         
    }    
    
    public void recupererLigne() {

        AllLigne.clear();
        List<Ligne> list = null;
        LigneController ac = new  LigneController();
        list = ac.findAll();
        for (Ligne ligne : list) {
        
            
            AllLigne.add(new Ligne(ligne.getId(), ligne.getNom(), ligne.getMoyentransport()));
        }
       
        ListeLigne.setItems(AllLigne);
    }
    
    @FXML
    public void ajouterTarif()
    {
         Ligne s1 = ListeLigne.getValue();
        if (s1 == null) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" il faut selectionner une ligne  ");
            alert1.showAndWait();
            return;
        } else {

            for (Ligne recl : AllLigne) {
                if (s1.equals(recl)) {
                    TarifController tc = new TarifController();
                    System.out.println(s1.getId());
                    //System.out.println(s1.getDestination_depart());
                    tc.addTarif(Double.parseDouble(prix.getText()), s1);
                    Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" Tarif ajouté avec succés ");
            alert1.showAndWait();
            prix.setText(null);
             
                    
                }}}
    }
    
    @FXML
     public void retour(ActionEvent event) throws IOException {

        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DashbordTarif.fxml"));
                        Loder.load();
                        
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
    
}
