/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static utilidades.ConnectionDB.conexion;

/**
 *
 * @author julen
 */
public class CRUD_Usuarios {
   
    public static void insertarUsuario(Connection conexion, Usuario usu){
     
        PreparedStatement ps;
     
        try {
            String sql = "Insert into usuario values(?,?,?,?)";
             ps = (PreparedStatement) conexion.prepareStatement(sql);
             
            ps.setString(1,usu.getNombre());
            ps.setString(2,usu.getApellidos());
            ps.setString(3, usu.getEmail());
            ps.setString(4, usu.getPassword());
            
                  
            ps.executeUpdate();
            //javax.swing.JOptionPane.showMessageDialog(null, "Usuario Insertado CORRECTAMENTE"); //EN VEZ DE JOptionPane, SCENE BUILDER
            
        } catch (SQLException ex) {
            System.out.print("ERROR AL INSERTAR");
        }
        
    }
    
    public static boolean comprobarCampos(Usuario usu){
        if (usu.getNombre().equalsIgnoreCase("")){
            
            return false;
        }
        else if (usu.getApellidos().equalsIgnoreCase("")){
            return false;
        }
        else if (usu.getEmail().equalsIgnoreCase("")){
            return false;
        }
        else if (usu.getPassword().equalsIgnoreCase("")){
            return false;
        }else{
            return true;
        }
}
    
    public static boolean comprobarEmail(Usuario usu){
        
        String pattern = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        if(usu.getEmail().matches(pattern)){
            return true;
        }else{
            return false;
        }
    }
    
    
}
