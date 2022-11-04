/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static utilidades.ConnectionDB.conexion;
import static utilidades.ConnectionDB.getConexion;

/**
 *
 * @author julen
 */
public class CRUD_Clientes {

    public static void insertarCliente(Connection conexion, Cliente c) {

        PreparedStatement ps;

        try {
            String sql = "Insert into cliente values(?,?,?,?,?)";
            ps = (PreparedStatement) conexion.prepareStatement(sql);

            ps.setString(1, c.getEmail());
            ps.setString(2, c.getNombre());
            ps.setString(3, c.getApellidos());
            ps.setString(4, c.getTlf());
            ps.setString(5, c.getTarifa());

            ps.executeUpdate();
            //javax.swing.JOptionPane.showMessageDialog(null, "Usuario Insertado CORRECTAMENTE"); //EN VEZ DE JOptionPane, SCENE BUILDER

        } catch (SQLException ex) {
            System.out.print("ERROR AL INSERTAR");
        }

    }

    public static boolean comprobarTlf(Cliente c) {
        if (c.getTlf().length() == 9 && c.getTlf().substring(0).equalsIgnoreCase("6") || c.getTlf().substring(0).equalsIgnoreCase("6")) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean comprobarTarifa(Cliente c) {
        if (c.getTarifa().equalsIgnoreCase("")) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean comprobarEmail(Cliente cliente) {

        String pattern = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if (cliente.getEmail().matches(pattern)) {
            return true;
        } else {
            return false;
        }
    }

    public static void eliminarCliente(Connection con, String tlf) {
        PreparedStatement ps;
        try {
            String sql = "Delete from cliente where tlf = ?";
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.setString(1, tlf);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("ERROR AL BORRAR");
        }

    }

    

    public static ObservableList<Cliente> tablaCliente() {
        Connection con;
        con=getConexion();
        ObservableList <Cliente> listaTabla;
        listaTabla = FXCollections.observableArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from cliente");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaTabla.add(new Cliente(rs.getString("email_usuario"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("tlf"), rs.getString("tarifa")));

            }
        } catch (SQLException ex) {
          
        }
        
        return listaTabla;
    }
    
    public static ArrayList<String> encontrarCliente(Connection con, String tlf){
        ArrayList<String> datos = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * from cliente where tlf = "+ tlf);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datos.add(rs.getString("email_usuario"));
                datos.add(rs.getString("nombre"));
                datos.add(rs.getString("apellidos")); 
                datos.add(rs.getString("tlf"));
                datos.add(rs.getString("tarifa"));
            }
            datos.toString();

        } catch (SQLException ex) {
            System.out.print("ERROR AL ENCONTRAR");
        }
        return datos;
    }
    
    public static void modificarCliente(Connection con, String email, String nombre, String apellidos, String tlf, String tarifa, String tlfNuevo){
        PreparedStatement ps;
        try {
            String sql = ("Update cliente set email_usuario = " + email + ", nombre =" +nombre+", apellidos" + apellidos +
                    ", tlf =" + tlfNuevo +", tarifa = "+ tarifa +" where tlf ="+ tlf );
            
            ps = (PreparedStatement) conexion.prepareStatement(sql);
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.print("ERROR AL MODIFICAR");
        }
    }
}
