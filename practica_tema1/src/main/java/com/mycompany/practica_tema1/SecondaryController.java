package com.mycompany.practica_tema1;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import static utilidades.CRUD_Clientes.comprobarTarifa;
import static utilidades.CRUD_Clientes.comprobarTlf;
import static utilidades.CRUD_Clientes.eliminarCliente;
import static utilidades.CRUD_Clientes.encontrarCliente;
import static utilidades.CRUD_Clientes.insertarCliente;
import static utilidades.CRUD_Clientes.modificarCliente;
import static utilidades.CRUD_Clientes.tablaCliente;
import utilidades.Cliente;
import static utilidades.ConnectionDB.getConexion;
import utilidades.Usuario;

public class SecondaryController implements Initializable {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    private Connection con;
    public SecondaryController() throws SQLException{
        this.con = getConexion();
    }
    
    @FXML
    private Label mensajeMod;
    
    @FXML
    private Label mensajeBuscar;
    
    @FXML
    private Label tlfNew;
    
    @FXML
    private TextField nombre;
    
    @FXML
    private TextField apellidos;
    
    @FXML
    private TextField emailVendedor;
    
    @FXML
    private TextField tlf;
    
    @FXML
    private TextField tlfEliminar;
    
    @FXML
    private TextField tlfNuevo;
    
    @FXML
    private ComboBox tarifa;
    
    @FXML
    private Button nuevo;
            
    @FXML
    private Button modificar;
            
    @FXML
    private Button borrar;
    
    @FXML
    private Button borrarConfirmado;
            
    @FXML
    private Button buscar;
    
    @FXML
    private TableView<Cliente> tabla;
    
    @FXML
    private TableColumn<Cliente, String> cEmailUsuario;
    
    @FXML
    private TableColumn<Cliente, String> cNombre;
    
    @FXML
    private TableColumn<Cliente, String> cApellidos;
    
    @FXML
    private TableColumn<Cliente, String> cTlf;
    
    @FXML
    private TableColumn<Cliente, String> cTarifa;
    
    @FXML
    private AnchorPane mensajeBorrar;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Connection con = getConexion();
        tarifa.getItems().add("Sencilla");
        tarifa.getItems().add("Premium");
        tarifa.getItems().add("Familiar");
        tarifa.getItems().add("Estudiante");
        
        this.cEmailUsuario.setCellValueFactory(new PropertyValueFactory("email_usuario"));
        this.cNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        this.cApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
        this.cTlf.setCellValueFactory(new PropertyValueFactory("tlf"));
        this.cTarifa.setCellValueFactory(new PropertyValueFactory("tarifa"));
        
        ObservableList<Cliente> items = tablaCliente();
        this.tabla.setItems(items);
    }
    
    @FXML
    private void nuevoCliente(){
       Cliente cliente = new Cliente(emailVendedor.getText(), nombre.getText(), apellidos.getText(), tlf.getText(), tarifa.getValue().toString());
      /* if(comprobarTlf(cliente) == false){
           System.out.println("Error");
       }
       if(comprobarTarifa(cliente) == false){
           System.out.println("error");
       }*/
       
       //if(comprobarTlf(cliente) && comprobarTarifa(cliente) == true){
           System.out.println("Cliente añadido: " + cliente.getNombre() + " " + cliente.getApellidos() + " " + cliente.getEmail()+ " " + cliente.getTlf() + cliente.getTarifa());
           insertarCliente(con, cliente);
       //}
       }
    
    
    @FXML
    private void borrarCliente(){ // ESTE MÉTODO ABRE EL PANE DE ELIMINACIÓN DE CLIENTE
        mensajeBorrar.setVisible(true);
    }
    
    @FXML
    private void borrarClienteDef(){ //ESTE ELIMINA AL CLIENTE DEFINITIVAMENTE
        eliminarCliente(con, tlfEliminar.getText());
    }
        
    @FXML
    private void buscarCliente(){ //OBTENEMOS UN ARRAYLIST DE UNA CONSULTA Y MOSTRAMOS LOS DATOS EN LOS CAMPOS
        if(tlf.getText().equalsIgnoreCase("")){
            mensajeBuscar.setVisible(true);
        }else {
        mensajeBuscar.setVisible(false);
        ArrayList<String> dat = encontrarCliente(con, tlf.getText());
        emailVendedor.setText(dat.get(0));
        nombre.setText(dat.get(1));
        apellidos.setText(dat.get(2));
        tlf.setText(dat.get(3));
        tarifa.setValue(dat.get(4));
        }
    }
    
    @FXML
    private void modCliente(){
        if(emailVendedor.getText().equalsIgnoreCase("") || nombre.getText().equalsIgnoreCase("") || apellidos.getText().equalsIgnoreCase("") || tlf.getText().equalsIgnoreCase("") || emailVendedor.getText().equalsIgnoreCase("") || tarifa.toString().equalsIgnoreCase("")){
            mensajeMod.setVisible(true);
        }else
            mensajeMod.setVisible(false);
            tlfNew.setVisible(true);
            tlfNuevo.setVisible(true);
            modificarCliente(con, emailVendedor.getText(), nombre.getText(), apellidos.getText(), tlf.getText(), tarifa.toString(), tlfNuevo.getText());
           
    }
        
        
  }
    
    

    
    
