/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.LigneController;
import Controller.AbonnementController;
import Controller.AbonneController;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import entities.Abonnement;
import entities.Abonne;
import static gui.ReserverAbonnementFXMLController.ErrorNotification;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author mahmo
 */
public class DashbordAbonnementController implements Initializable {

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

        ObservableList<Abonnement> allAbonnements = FXCollections.observableArrayList();
    @FXML
    private Label lb1;
    @FXML
    private Button btnAjouter1;
    @FXML
    private Button pdfbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             recupererTarif();
             btnAjouter1.setOnAction((e) -> {
            Parent redir;
            try {
                redir = FXMLLoader.load(getClass().getResource("DashbordTarif.fxml"));
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

        
        allAbonnements.clear();
        List<Abonnement> list = null;
       AbonnementController ac = new AbonnementController();
       LigneController lc = new LigneController();
       AbonneController ab = new AbonneController();
        list = ac.getAllAbonnements();
        int i = 1;
        for (Abonnement abonnement : list) {
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                 ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(103);
                    Label label = new Label(String.valueOf(abonnement.getId()));
                    label.setPrefWidth(98);
                    Label label2 = new Label(abonnement.getDate_achat());
                    label2.setPrefWidth(165);
                    Label labelx = new Label(abonnement.getDate_expiration());
                    label2.setPrefWidth(140);
                    Label labeles = new Label();
                    labeles.setPrefWidth(140);
                    Button delete = new Button("Supprimer");
                    delete.setOnAction((event) -> {
                        ac.deleteAbonnement(abonnement);
                       pnItems.getChildren().remove(h1);
                                   ErrorNotification("SUCCES!!", "abonnement "+ abonnement.getId()+" supprimer");

                    });
                    
                    h1.getChildren().addAll(espace,label3,label,label2,labelx,labeles,delete);
            pnItems.getChildren().add(h1);
                
        }
        
    
}
    
}
