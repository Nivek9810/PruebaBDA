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
public class DTO_Nombre_Servicio {
    
    private Integer Id_Noms;
    private String Servicio;

    public DTO_Nombre_Servicio(Integer Id_Noms, String Servicio) {
        this.Id_Noms = Id_Noms;
        this.Servicio = Servicio;
    }

    public DTO_Nombre_Servicio() {
        this.Id_Noms = 0;
        this.Servicio = "";
    }

    
    public Integer getId_Noms() {
        return Id_Noms;
    }

    public void setId_Noms(Integer Id_Noms) {
        this.Id_Noms = Id_Noms;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String Servicio) {
        this.Servicio = Servicio;
    }
    
    
    
}
