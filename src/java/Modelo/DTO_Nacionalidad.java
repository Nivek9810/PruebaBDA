/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author user
 */
public class DTO_Nacionalidad {

    private Integer Id_Nacio;
    private String Pais_Origen;

    public DTO_Nacionalidad(Integer Id_Nacio, String Pais_Origen) {
        this.Id_Nacio = Id_Nacio;
        this.Pais_Origen = Pais_Origen;
    }

    public DTO_Nacionalidad() {
        this.Id_Nacio = 0;
        this.Pais_Origen = "";
    }

    public Integer getId_Nacio() {
        return Id_Nacio;
    }

    public void setId_Nacio(Integer Id_Nacio) {
        this.Id_Nacio = Id_Nacio;
    }

    public String getPais_Origen() {
        return Pais_Origen;
    }

    public void setPais_Origen(String Pais_Origen) {
        this.Pais_Origen = Pais_Origen;
    }
    
}
