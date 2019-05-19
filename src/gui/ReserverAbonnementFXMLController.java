/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Controller.AbonnementController;
import Controller.LigneController;
import Controller.TarifController;
import Controller.LigneController;
import entities.Abonnement;
import entities.Ligne;
import entities.Tarif;
import entities.Ligne;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.net.HttpURLConnection;
import java.time.Duration;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author Khalil
 */
public class ReserverAbonnementFXMLController implements Initializable {
             List<String> codeList = new ArrayList<>();


    @FXML
    private ComboBox<Ligne> listeLigne;
    @FXML
    private Text lePrix;

    ObservableList<Ligne> AllLigne = FXCollections.observableArrayList();
    
   private int durrée; 
    @FXML
    private RadioButton sixMois;
    @FXML
    private RadioButton douzeMois;
    Tarif t = new Tarif();
    @FXML
    private TextField phnum;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       recupererLigne();
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
     ;
    
    @FXML
    public void affichePrix()
    {
        Alert alrt2 = new Alert(Alert.AlertType.INFORMATION);
                                        alrt2.setContentText("3andek remize 10% khater fi septembre");

            Calendar dateRmz;
dateRmz= Calendar.getInstance();
         Ligne s1 = listeLigne.getValue();
        if (s1 == null) {
            Alert alert1 = new Alert(Alert.AlertType.ERROR);
            alert1.setHeaderText(null);
            alert1.setContentText(" il faut selectionner une ligne  ");
            alert1.showAndWait();
            return;
        } else {

            for (Ligne recl : AllLigne) {
                if (s1.equals(recl)) {
                    double prixAffiche;
                    TarifController tc = new TarifController();
                    
                    
                   t= tc.getTarifByLigne(s1.getId());
                   prixAffiche = t.getTarif();
                if ((sixMois.isSelected()) && ((dateRmz.getTime().getMonth()+1)==9)){
                    durrée=6;
                                lePrix.setText(String.valueOf(prixAffiche*0.9));
                                alrt2.showAndWait();
                                System.out.println(dateRmz.getTime().getMonth()+1);
                }else if((sixMois.isSelected())){
                    lePrix.setText(String.valueOf(prixAffiche));
                }else if (douzeMois.isSelected()&& ((dateRmz.getTime().getMonth()+1)==9)) {
                    durrée=12;
                    prixAffiche *=1.7;
                        lePrix.setText(String.valueOf(prixAffiche));
                                   alrt2.showAndWait();

                    }else if(douzeMois.isSelected()){
                        prixAffiche *=1.8;
                         lePrix.setText(String.valueOf(prixAffiche));
                    }
{
                    
                }
    }
            }
}
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
    public boolean testCin(String num)
    {
        
        String[] c = {"Q","W","E","R","T","Y","U","I","O","P","A","S"
                     ,"D","F","G","H","J","K","L","Z","X","C","V","B","N"
                     ,"M","q","w","e","r","t","y","u","i","o","p","a","s"
                     ,"d","f","g","h","j","k","l","z","x","c","v","b","n"};
        for(int i =0 ; i<c.length ; i++)
        {
            if(num.contains(c[i]))
            {
                return false ;
            }
        }
        return true ;
    }
    public void ajouterAbonnement()
    {
     if((phnum.getText().length()==8)&& testCin(phnum.getText())==true){
                    String code = "K678LMNOghijkPQRSTUV01234FGHIJ59abcdeflmABCDEnop";
                    int x;
                    String cd="";
        for (int i = 0; i < 9; i++) {
          x=  (int) (Math.random() * ( (code.length()-1) - 0 ));
                  cd+=code.charAt(x);
                  
        }
        codeList.add(cd);
        System.out.println("unique code :"+cd+"\n");
        
         /*for (String codL : codeList) {
             System.out.print(codL+" | \n");
         }*/
        AbonnementController ac = new AbonnementController();
        Abonnement ab = new Abonnement();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	
       String dateFin = ac.incrDate(dateFormat.format(date), durrée);
       
       ab.setDate_achat(dateFormat.format(date));
       ab.setDate_expiration(dateFin);
       ab.setTarif(t.getId());
       ab.setAbonne(21);
       ac.ajouterAbonnement(ab);
         System.out.println(ab.getDate_expiration());
         System.out.println();
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
            alert1.setHeaderText(null);
            alert1.setContentText(" Abonnement ajouté ");
            alert1.showAndWait();
            ErrorNotification("SUCCES!!", "reservasion avec succé");
           /*try {
			// Construct data
			String apiKey = "apikey=" + "6tjnBbYKOVY-SNCA4Dy8mc6fVZ9TgmAJAWsY8CDw98";
			String message = "&message=" + "SmartTrans : \n your reservation succes!!"+"\n your code is: "+cd+
                                         "\n de "+ab.getDate_achat()+" à "+ab.getDate_expiration();
			String sender = "&sender=" + "SmartTrans";
			String numbers = "&numbers=" + "216"+phnum.getText();
			
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
		}*/
            return;
        
    
    }else{
          Alert alert3 = new Alert(Alert.AlertType.ERROR);
            alert3.setHeaderText(null);
            alert3.setContentText(" il faut que num tel 8 chiffre  ");
            alert3.showAndWait();
     }
    
}}