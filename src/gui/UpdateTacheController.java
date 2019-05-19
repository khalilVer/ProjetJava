/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.ChauffeurController;
import Controller.TacheController;
import Controller.VoyageController;
import entities.Chauffeur;
import entities.Tache;
import entities.Voyage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class UpdateTacheController implements Initializable {

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
    @FXML
    private ComboBox<Voyage> listeVoyage;
    @FXML
    private Button ajouter;
    @FXML
    private ComboBox<Chauffeur> listChauffeur;
    
   
    

     ObservableList<Voyage> allVoyage = FXCollections.observableArrayList();
      ObservableList<Chauffeur> allChauffeur = FXCollections.observableArrayList();
    @FXML
    private Text voy;
    @FXML
    private Text chauff;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
            
       recupererVoyage();
       recupererChauffeur();
       
       ajouter.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(listChauffeur.getValue() == null || listeVoyage.getValue() == null )
               {
                   Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Des champs vides ! ");
            alert1.showAndWait();
               }
               else
               {
 Tache t = new Tache();
              t.setId_chauffeur(listChauffeur.getValue().getId());
              t.setId_voyage(listeVoyage.getValue().getId());
              t.setId_chef_station(10);
             
                
           
                TacheController ac = new TacheController();
                ArrayList<Tache> listeTache = new ArrayList<>();        
                 int test = 0;
        listeTache = ac.getAllTaches();
        for(Tache tache : listeTache)
        {
            if(tache.getId_chauffeur()==t.getId_chauffeur() && tache.getId_voyage()==t.getId_voyage())
               {
                   test = 1 ;
               }
            else if(tache.getId_voyage()==t.getId_voyage() && tache.getId_chauffeur()!=t.getId_voyage())
               {
                   test = 2;
               }
        }
                if(test == 0){
                ac.updateTache(t); 
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" Affectation avec succés ");
            alert1.showAndWait();}
                else if(test == 1)
                {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Tache deja affectée ");
            alert1.showAndWait();
                }
                else if(test == 2)
                {
                    Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Ce voyage est affecté à un autre chauffeur");
            alert1.showAndWait();
                }
                
               }
            }
        });
       
    }    

    @FXML
    private void retour(ActionEvent event) throws IOException {
        
        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilChef.fxml"));
                        Loder.load();
                      
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
    
    
    public void getVoyageAndChauffeur(int id_voyage,int id_chauffeur)
    {
       
         Voyage v ;
        Chauffeur c ;
        VoyageController vc = new VoyageController();
        ChauffeurController cc = new ChauffeurController();
       
        v = vc.getVoyageById(id_voyage);
        c = cc.getChauffeurById(id_chauffeur);
        
        
        voy.setText(v.toString());
        chauff.setText(c.toString());
    
    }
    
     public void recupererVoyage() {

        allVoyage.clear();
        List<Voyage> list = null;
        VoyageController ac = new  VoyageController();
        list = ac.getAllVoyages();
        for (Voyage ligne : list) {
        
            
            allVoyage.add(new Voyage(ligne.getId(), ligne.getType(), ligne.getHeure_depart(), ligne.getHeure_arrive(), ligne.getDestination_depart(), ligne.getDestination_arrive(),ligne.getId_ligne()));
        }
       
        listeVoyage.setItems(allVoyage);
    }
     
      public void recupererChauffeur() {

        allChauffeur.clear();
        List<Chauffeur> list = null;
        ChauffeurController ac = new  ChauffeurController();
        list = ac.getAllChauffeurs();
        for (Chauffeur chauff : list) {
        
            
            allChauffeur.add(new Chauffeur(chauff.getNbTacheTotal(), chauff.getNbTacheParJour(), chauff.getNomLigne(), chauff.getDispo(), chauff.getId(), chauff.getUsername(), chauff.getPassword(), chauff.getNom(), chauff.getPrenom(), chauff.getCin(), chauff.getAdresse(), chauff.getDate_naissance()));
        }
       
        listChauffeur.setItems(allChauffeur);
    }
    
}
