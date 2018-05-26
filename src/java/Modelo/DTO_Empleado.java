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
public class DTO_Empleado {
    
    private String Id_Empleado ;
    private Integer Cargo ;
    private String Contrasena ;
    private String Id_PersonaFK ;

    public DTO_Empleado() {
        this.Id_Empleado = "";
        this.Cargo = 0;
        this.Contrasena = "";
        this.Id_PersonaFK = "";
    }

    public DTO_Empleado(String Id_Empleado, Integer Cargo, String Contrasena, String Id_PersonaFK) {
        this.Id_Empleado = Id_Empleado;
        this.Cargo = Cargo;
        this.Contrasena = Contrasena;
        this.Id_PersonaFK = Id_PersonaFK;
    }
    
    

    public String getId_Empleado() {
        return Id_Empleado;
    }

    public void setId_Empleado(String Id_Empleado) {
        this.Id_Empleado = Id_Empleado;
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

    public String getId_PersonaFK() {
        return Id_PersonaFK;
    }

    public void setId_PersonaFK(String Id_PersonaFK) {
        this.Id_PersonaFK = Id_PersonaFK;
    }

    
    
    
    
}
