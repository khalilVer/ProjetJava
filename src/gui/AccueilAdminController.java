/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.LigneController;
import Controller.TarifController;
import Controller.AbonneController;
import Controller.ChauffeurController;
import Controller.ChefStationController;
import Controller.GeneralUserController;
import entities.Abonne;
import entities.Chauffeur;
import entities.ChefStation;
import entities.Ligne;
import entities.Tarif;
import entities.Users;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class AccueilAdminController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
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
    private VBox pnItems;
    @FXML
    private ComboBox<String> listeTypeUser;
    
    private FilteredList<Users>filterData;

    ObservableList<String> AllType = FXCollections.observableArrayList();
    ObservableList<String> AllUserByType = FXCollections.observableArrayList();
    @FXML
    private TextField recherche;
    
    private GeneralUserController gc = new GeneralUserController();
    @FXML
    private Button btnAffecter;
    @FXML
    private Button btntache;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficheTypeUtilisateur();
    }    
    
    public void afficheTypeUtilisateur()
    {
        
        ObservableList<String> list = FXCollections.observableArrayList();;
        list.add("Abonnes");
        list.add("Chauffeurs");
        list.add("Chefs station");
        listeTypeUser.setItems(list);
    }
    
    
    
    @FXML
    public void afficheUtilisateur()
    {
         pnItems.getChildren().clear();
        
        AllUserByType.clear();
       List<Abonne> listAbonne = null;
       List<Chauffeur> listChauffeur = null;
       List<ChefStation> listChefStation = null;
         String type = listeTypeUser.getValue();
          if (type == null) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" il faut selectionner un type d'utilisateur  ");
            alert1.showAndWait();
            return;}
          else if(type.equals("Abonnes")) {
              
                AbonneController ac = new AbonneController();
        listAbonne = ac.getAllAbonnes();
        int i = 1;
        for (Abonne user : listAbonne) {
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(user.getCin());
                    label.setPrefWidth(120);
                    Label label2 = new Label(user.getUsername());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(user.getNom());
                    label4.setPrefWidth(80);
                    Label label5 = new Label(user.getPrenom());
                    label5.setPrefWidth(100);
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        ac.deleteAbonne(user.getCin());
                        gc.deleteUser(user.getUsername());
                       pnItems.getChildren().remove(h1);
                    });
                   Button detail = new Button("Detail");
                   detail.setOnAction((event) -> {
                        try {
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DetailsAbonneFXML.fxml"));
                     Loder.load();
                        DetailsAbonneFXMLController display = Loder.getController();
                        display.showinItems(user.getUsername(), user.getNom(), user.getPrenom(), user.getCin(), user.getDate_naissance(), user.getAdresse());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                        } catch (IOException ex) {
                     
                 }
                   });
                   
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5,delete,detail);
            pnItems.getChildren().add(h1);
        }
        
             
               }
          else if(type.equals("Chauffeurs")) {
              
                ChauffeurController ac = new ChauffeurController();
        listChauffeur = ac.getAllChauffeurs();
        int i = 1;
        for (Chauffeur user : listChauffeur) {
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(user.getCin());
                    label.setPrefWidth(120);
                    Label label2 = new Label(user.getUsername());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(user.getNom());
                    label4.setPrefWidth(80);
                    Label label5 = new Label(user.getPrenom());
                    label5.setPrefWidth(100);
                    
                   
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        ac.deleteChauffeur(user.getCin());
                        gc.deleteUser(user.getUsername());
                       pnItems.getChildren().remove(h1);
                    });
                   Button detail = new Button("Detail");
                   detail.setOnAction((event) -> {
                        try {
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DetailsAbonneFXML.fxml"));
                     Loder.load();
                        DetailsAbonneFXMLController display = Loder.getController();
                        display.showinItems(user.getUsername(), user.getNom(), user.getPrenom(), user.getCin(), user.getDate_naissance(), user.getAdresse());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                        } catch (IOException ex) {
                     
                 }
                   });
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5,delete,detail);
            pnItems.getChildren().add(h1);
        }
               }
          else if(type.equals("Chefs station")) {
              
                 ChefStationController ac = new ChefStationController();
        listChefStation = ac.getAllChefStations();
        int i = 1;
        for (ChefStation user : listChefStation) {
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(user.getCin());
                    label.setPrefWidth(120);
                    Label label2 = new Label(user.getUsername());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(user.getNom());
                    label4.setPrefWidth(80);
                    Label label5 = new Label(user.getPrenom());
                    label5.setPrefWidth(100);
                    Label label6 = new Label(user.getNomLigne());
                    label6.setPrefWidth(100);
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        ac.deleteChefStation(user.getCin());
                        gc.deleteUser(user.getUsername());
                       pnItems.getChildren().remove(h1);
                    });
                   Button detail = new Button("Detail");
                   detail.setOnAction((event) -> {
                        try {
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DetailsAbonneFXML.fxml"));
                     Loder.load();
                        DetailsAbonneFXMLController display = Loder.getController();
                        display.showinItems(user.getUsername(), user.getNom(), user.getPrenom(), user.getCin(), user.getDate_naissance(), user.getAdresse());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                        } catch (IOException ex) {
                     
                 }
                   });
                   
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5,label6,delete,detail);
            pnItems.getChildren().add(h1);
        }
              
               }
         
        
      }
    
    
    @FXML
    public void ajouterAbonne(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("InscriptionFXML.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
            }
    
    @FXML
     public void ajouterChauffeur(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("InsriptionChauffeurFXML.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
                        
            }
     
    @FXML
      public void ajouterChefStation(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("InscriptionChefStationFXML.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
            }
    
      @FXML
      public void versAffectationVoyage(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AffecterVoyageFXML.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
            }
      
       @FXML
      public void versUpdateVoyage(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilChef.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
            }
      
        @FXML
      public void versAccueilChauffeur(ActionEvent event) throws IOException {
        

           
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AccueilChauffeur.fxml"));
                        Loder.load();
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                    
                
            }
      
    @FXML
         public void onSearchUsers(){
             
              
              int i=1;
            Abonne abonne ;
            Chauffeur chauffeur ;
            ChefStation chef ;
             AbonneController ac = new AbonneController();
            ChauffeurController cc = new ChauffeurController();
            ChefStationController cf = new ChefStationController();
             if (recherche.getText().equals("")) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" Please enter CIN number  ");
            alert1.showAndWait();
            }
             else {
                 String type = listeTypeUser.getValue();
                  if(type.equals("Abonnes")) {
                pnItems.getChildren().clear();
                    abonne = ac.getAbonneByCIN(recherche.getText());
                    if(abonne ==null)
                    {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" No abonne Found ");
            alert1.showAndWait();
                 return;   }
                    else{
                        
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(abonne.getCin());
                    label.setPrefWidth(120);
                    Label label2 = new Label(abonne.getUsername());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(abonne.getNom());
                    label4.setPrefWidth(80);
                    Label label5 = new Label(abonne.getPrenom());
                    label5.setPrefWidth(100);
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        ac.deleteAbonne(abonne.getCin());
                       pnItems.getChildren().remove(h1);
                    });
                   Button detail = new Button("Detail");
                   detail.setOnAction((event) -> {
                        try {
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DetailsAbonneFXML.fxml"));
                     Loder.load();
                        DetailsAbonneFXMLController display = Loder.getController();
                        display.showinItems(abonne.getUsername(), abonne.getNom(), abonne.getPrenom(), abonne.getCin(), abonne.getDate_naissance(), abonne.getAdresse());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                        } catch (IOException ex) {
                     
                 }
                   });
                   
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5,delete,detail);
            pnItems.getChildren().add(h1);
        }
        
                  }   
               
          else if(type.equals("Chauffeurs")) {
                pnItems.getChildren().clear();
               
     chauffeur = cc.getChauffeurByCIN(recherche.getText());
     
                     if(chauffeur ==null)
                    {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" No chauffeur Found ");
            alert1.showAndWait();
                   return; }
                    else{
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(chauffeur.getCin());
                    label.setPrefWidth(120);
                    Label label2 = new Label(chauffeur.getUsername());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(chauffeur.getNom());
                    label4.setPrefWidth(80);
                    Label label5 = new Label(chauffeur.getPrenom());
                    label5.setPrefWidth(100);
                    Label label6 = new Label(Integer.toString(chauffeur.getNbTacheTotal()));
                    label6.setPrefWidth(100);
                    Label label7 = new Label(Integer.toString(chauffeur.getNbTacheParJour()));
                    label7.setPrefWidth(100);
                    Label label8 = new Label(Integer.toString(chauffeur.getDispo()));
                    label8.setPrefWidth(100);
                    Label label9 = new Label(chauffeur.getNomLigne());
                    label9.setPrefWidth(100);
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        cc.deleteChauffeur(chauffeur.getCin());
                       pnItems.getChildren().remove(h1);
                    });
                   Button detail = new Button("Detail");
                   detail.setOnAction((event) -> {
                        try {
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DetailsAbonneFXML.fxml"));
                     Loder.load();
                        DetailsAbonneFXMLController display = Loder.getController();
                        display.showinItems(chauffeur.getUsername(), chauffeur.getNom(), chauffeur.getPrenom(), chauffeur.getCin(), chauffeur.getDate_naissance(), chauffeur.getAdresse());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                        } catch (IOException ex) {
                     
                 }
                   });
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5,label6,label7,label8,label9,delete,detail);
            pnItems.getChildren().add(h1);
                     }
               }
          else if(type.equals("Chefs station")) {
                pnItems.getChildren().clear();
       chef = cf.getChefStationByCIN(recherche.getText());
              
        if(chef ==null)
                    {
                        Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" No chef Found ");
            alert1.showAndWait();
                   return; }
                    else{
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(chef.getCin());
                    label.setPrefWidth(120);
                    Label label2 = new Label(chef.getUsername());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(chef.getNom());
                    label4.setPrefWidth(80);
                    Label label5 = new Label(chef.getPrenom());
                    label5.setPrefWidth(100);
                    Label label6 = new Label(chef.getNomLigne());
                    label6.setPrefWidth(100);
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        cf.deleteChefStation(chef.getCin());
                       pnItems.getChildren().remove(h1);
                    });
                   Button detail = new Button("Detail");
                   detail.setOnAction((event) -> {
                        try {
                        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("DetailsAbonneFXML.fxml"));
                     Loder.load();
                        DetailsAbonneFXMLController display = Loder.getController();
                        display.showinItems(chef.getUsername(), chef.getNom(), chef.getPrenom(), chef.getCin(), chef.getDate_naissance(), chef.getAdresse());
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
                        } catch (IOException ex) {
                     
                 }
                   });
                   
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5,label6,delete,detail);
            pnItems.getChildren().add(h1);
        }
          }
               }
                 
             
             }
      
               
                     
         
         }
             
             
     
    

