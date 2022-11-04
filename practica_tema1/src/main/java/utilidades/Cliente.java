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
public class Cliente {
    private String emailVendedor;
    private String nombre;
    private String apellidos;
    private String tlf;
    private String tarifa;

    public String getEmail() {
        return emailVendedor;
    }

    public void setEmail(String email) {
        this.emailVendedor = email;
    }
    
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

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    
    public Cliente(String email, String nombre, String apellidos, String tlf, String tarifa){
        this.emailVendedor = email;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.tlf = tlf;
        this.tarifa = tarifa;
}
}
