/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.ChauffeurController;
import Controller.TacheController;
import Controller.VoyageController;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import entities.Tache;
import entities.Voyage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class AccueilChauffeurController implements Initializable {

    @FXML
    private Label username;
    @FXML
    private Button btnOverview;
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
    private VBox pnItems;
    
    ObservableList<String> AllTache = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                        String info2=" " ; 
StringProperty info = new SimpleStringProperty();

         pnItems.getChildren().clear();
        
        AllTache.clear();
       List<Tache> listTache = null;
       
         
       
              
        TacheController ac = new TacheController();
        VoyageController vc = new VoyageController();
        ChauffeurController cc = new ChauffeurController();
        
        listTache = ac.getAllTaches();
        int i = 1;
        for (Tache tache : listTache) {
            Voyage v = new Voyage();
            v= vc.getVoyageById(tache.getId_voyage());
            
            
             HBox h1 = new HBox();
             
             Label espace = new Label("                       ");
              Label label3 = new Label(String.valueOf(i));
              i++;
              label3.setPrefWidth(70);
                    Label label = new Label(v.getDestination_depart());
                    label.setPrefWidth(120);
                    Label label2 = new Label(v.getDestination_arrive());
                    label2.setPrefWidth(80);
                    Label label4 = new Label(String.valueOf(v.getHeure_depart()));
                    label4.setPrefWidth(150);
                    Label label5 = new Label(String.valueOf(v.getHeure_arrive()));
                    label5.setPrefWidth(150);
                  
                       
                    
                    
                    
                
                   
                    
                    h1.getChildren().addAll(label3,label2,label,label4,label5);
            pnItems.getChildren().add(h1);
            info2+=("numero :"+label3.getText()+" Destination arrive :"+label2.getText()+" Destination depart :"+label.getText()+" heur depart :"+label4.getText()+" heur arrive "+label5.getText()+"\n");
                                info.set(info2);
        }
         
                    Document document = new Document();                 
        try{
            
            PdfWriter.getInstance(document, new FileOutputStream("Chauffeure.pdf"));
            document.open();
            Paragraph p1 = new Paragraph("Liste des chauffeurs");
            //Paragraph p2 = new Paragraph("numero :"+label3.getText()+" id :"+label.getText()+" date achat :"+label2.getText()+" date expiration :"+labelx.getText()+" "+labeles.getText());
                        Paragraph p2 = new Paragraph(info.getValue());
				document.add(p1);
            document.add(p2);
            System.out.println(info.getValue());

        }
        catch(Exception e){
            System.out.println(e);
        }
        document.close();
             
               }
    
      @FXML
    private void retour(ActionEvent event) throws IOException  {
        
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
        


    

