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
public class DTO_Tipo_Doc {
    private Integer Id_Tipo_Doc;
    private String Tipo_Docu;

    public DTO_Tipo_Doc(Integer Id_Tipo_Doc, String Tipo_Docu) {
        this.Id_Tipo_Doc = Id_Tipo_Doc;
        this.Tipo_Docu = Tipo_Docu;
    }

    public DTO_Tipo_Doc() {
        this.Id_Tipo_Doc = 0;
        this.Tipo_Docu = "";
    }

    public Integer getId_Tipo_Doc() {
        return Id_Tipo_Doc;
    }

    public void setId_Tipo_Doc(Integer Id_Tipo_Doc) {
        this.Id_Tipo_Doc = Id_Tipo_Doc;
    }

    public String getTipo_Docu() {
        return Tipo_Docu;
    }

    public void setTipo_Docu(String Tipo_Docu) {
        this.Tipo_Docu = Tipo_Docu;
    }
    
    
}
