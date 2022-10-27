/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

/**
 *
 * @author julen
 */
public class Usuario {
    private String nombre;
    private String apellidos;
    private String email;
    private String password;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void Password(String password) {
        this.password = password;
    }
    
    public Usuario(String nombre, String apellidos, String email, String password){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
    }
    
    public void getInfo(){
        System.out.println("Usuario registrado con éxito: " + "Nombre: " + getNombre() + "\n" 
                + "Apellidos:" + getApellidos() + "\n" + "Email:" + getEmail() + "\n" + "Contraseña:" + getPassword()) ;
    }
}
