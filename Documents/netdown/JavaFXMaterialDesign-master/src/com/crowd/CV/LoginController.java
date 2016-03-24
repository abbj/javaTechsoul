/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crowd.CV;

import com.crowd.DAO.MembreDAO;
import com.crowd.IDAO.IMembre;
import com.crowd.entities.Membre;
import com.crowd.helper.LoadStage;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASR1
 */
public class LoginController implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label inscription;
    @FXML
    private AnchorPane viewPane;
    private LoadStage loadStage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onclick(ActionEvent event) throws IOException {
        
        
          Membre membre=new Membre();
        IMembre im=new MembreDAO();
        System.out.println(im.authentification(username.getText(), password.getText()));
        if(im.authentification(username.getText(), password.getText())==true){
        ((Node)event.getSource()).getScene().getWindow().hide();
            Stage primaryStage=new Stage();

           Parent root = FXMLLoader.load(getClass().getResource("/com/crowd/mainform/MainForm.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
     
    }else{
            System.out.println("mot de passe or username incorrect");
        }
    
}

//    @FXML
//    private void btnInscription(MouseEvent event) {
//                loadStage = new LoadStage();
//
//        System.out.println("About Click Success !!!");
//                loadStage.loadAnchorPane(viewPane, "/about/About.fxml");
//    }

    @FXML
    private void btnInscription(MouseEvent event) {
           loadStage = new LoadStage();

       System.out.println("About Click Success !!!");
               loadStage.loadAnchorPane(viewPane, "/CV/Inscription.fxml");

    }

}