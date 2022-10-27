package com.mycompany.practica_tema1;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static utilidades.CRUD_Usuarios.comprobarCampos;
import static utilidades.CRUD_Usuarios.comprobarEmail;
import utilidades.Usuario;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private TextField nombre;
    
    @FXML
    private TextField apellidos;
    
    @FXML
    private TextField email;
    
    @FXML
    private Label emailError;
    
    @FXML
    private TextField pass;
    
    @FXML
    private Label errorVacio;
    
    @FXML
    private Button limpiar;
    
    @FXML
    private Button ok;
    
    @FXML
    private void limpiarCampo(){
        nombre.setText("");
        apellidos.setText("");
        email.setText("");
        pass.setText("");
        
    }
    
    @FXML 
    private void registrar(ActionEvent Event) throws IOException{
        Usuario user = new Usuario(nombre.getText(), apellidos.getText(), email.getText(), pass.getText());
        if(comprobarCampos(user) == false){
            errorVacio.setVisible(true);
            limpiarCampo();
        }
        if(comprobarEmail(user) == false){
            emailError.setVisible(true);
            limpiarCampo();
        }
        
        if(comprobarCampos(user) && comprobarCampos(user) == true ){
            user.getInfo();
            switchToSecondary();
        }
    }
    
}
