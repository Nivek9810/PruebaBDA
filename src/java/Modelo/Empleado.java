/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Familia MV
 */
public class Empleado {
    
    private Integer Id_empleado ;
    private Integer Cargo ;
    private String Contrasena ;
    private Integer Id_personaFK ;

    public Integer getId_empleado() {
        return Id_empleado;
    }

    public void setId_empleado(Integer Id_empleado) {
        this.Id_empleado = Id_empleado;
    }

    public Integer getCargo() {
        return Cargo;
    }

    public void setCargo(Integer Cargo) {
        this.Cargo = Cargo;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public Integer getId_personaFK() {
        return Id_personaFK;
    }

    public void setId_personaFK(Integer Id_personaFK) {
        this.Id_personaFK = Id_personaFK;
    }
    
    
    
    
    
}
