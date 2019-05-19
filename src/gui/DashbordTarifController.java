/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.LigneController;
import Controller.TarifController;
import entities.Tarif;
import static gui.DashbordAbonnementController.ErrorNotification;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class DashbordTarifController implements Initializable {

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
    private VBox pnItems;
    @FXML
    private Button btnAjouter;

    ObservableList<Tarif> allTarif = FXCollections.observableArrayList();
    @FXML
    private Pane AbnOverview;
    @FXML
    private Button btnAjouter1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        recupererTarif();
        btnAjouter1.setOnAction((e) -> {
            Parent redir;
            try {
                redir = FXMLLoader.load(getClass().getResource("DashbordAbonnementFXML.fxml"));
                Scene scene = new Scene(redir);
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
            }
        });
       
    }    
    public static void ErrorNotification(String title, String message) {
        
        Notifications notificationBuilder = Notifications.create()
               // .darkStyle()
                .hideAfter(javafx.util.Duration.seconds(2))
                .position(Pos.BOTTOM_RIGHT)
                .title(title)
                .text(message)
                
                ;
        notificationBuilder.showInformation();
    }
     public void recupererTarif() {

        
        allTarif.clear();
        List<Tarif> list = null;
       TarifController ac = new TarifController();
       LigneController lc = new LigneController();
        list = ac.getAllTarifs();
        int i = 1;
        for (Tarif tarif : list) {
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
             Label espace2 = new Label("    ");

              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(String.valueOf(tarif.getTarif()));
                    label.setPrefWidth(180);
                    Label label2 = new Label(lc.searchLigneById(tarif.getId_ligne()).toString());
                    label2.setPrefWidth(165);
                    Button delete = new Button("Supprimer");
                    Button update = new Button("Update Prix");
                    update.setOnAction((event) -> {
                       TextInputDialog dialog = new TextInputDialog(label.getText());
 
        dialog.setTitle("Update Tarif");
        dialog.setHeaderText("pour ligne "+label2.getText());
        dialog.setContentText("Tarif Old");
            
        Optional<String> result = dialog.showAndWait();
 
        result.ifPresent(name -> {
            
            ac.modifierprixdTarif(tarif,name);
                    ErrorNotification("SUCCES!!", "Prix Tarif "+ tarif.getId()+" modifier ");

           // service_controller.modifierTrafic(t, x);
        });
        Parent redir;
            try {
                redir = FXMLLoader.load(getClass().getResource("DashbordTarif.fxml"));
                Scene scene = new Scene(redir);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
             } catch (IOException ex) {
            }
        });
        
        
                  
                    delete.setOnAction((event) -> {
                        ac.deleteTarif(tarif);
                       pnItems.getChildren().remove(h1);
                    ErrorNotification("SUCCES!!", "Tarif "+ tarif.getId()+" supprimer");

                    });
                    
                    
                    h1.getChildren().addAll(espace,label3,label2,label,delete,espace2,update);
            pnItems.getChildren().add(h1);
           
        }
        
    
}
     
    @FXML
       public void AjouterTarif(ActionEvent event) throws IOException {

        FXMLLoader Loder = new FXMLLoader();
                        Loder.setLocation(getClass().getResource("AjouterTarifFXML.fxml"));
                        Loder.load();
                       
                        Parent AnchorPane = Loder.getRoot();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                          Scene scene = new Scene(AnchorPane);
                         stage.setScene(scene);
                        stage.showAndWait();
    }
}
