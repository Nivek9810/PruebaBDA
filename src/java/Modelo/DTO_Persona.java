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
public class DTO_Persona {
    private Integer Id_persona ;
    private Integer Id_Nacionalidad;
    private Integer Id_Tipo_Documento;
    private String Nombre, Correo;

    public DTO_Persona() {
        this.Id_persona = 0;
        this.Id_Nacionalidad = 0;
        this.Id_Tipo_Documento = 0;
        this.Nombre = "";
        this.Correo = "";
    }
 
    
    public DTO_Persona(Integer Id_persona, Integer Id_Nacionalidad, Integer Id_Tipo_Documento, String Nombre, String Correo) {
        this.Id_persona = Id_persona;
        this.Id_Nacionalidad = Id_Nacionalidad;
        this.Id_Tipo_Documento = Id_Tipo_Documento;
        this.Nombre = Nombre;
        this.Correo = Correo;
    }

    
    public Integer getId_persona() {
        return Id_persona;
    }

    public void setId_persona(Integer Id_persona) {
        this.Id_persona = Id_persona;
    }

    public Integer getId_Nacionalidad() {
        return Id_Nacionalidad;
    }

    public void setId_Nacionalidad(Integer Id_Nacionalidad) {
        this.Id_Nacionalidad = Id_Nacionalidad;
    }

    public Integer getId_Tipo_Documento() {
        return Id_Tipo_Documento;
    }

    public void setId_Tipo_Documento(Integer Id_Tipo_Documento) {
        this.Id_Tipo_Documento = Id_Tipo_Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
    
}
