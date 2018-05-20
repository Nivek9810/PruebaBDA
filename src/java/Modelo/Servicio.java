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
public class Servicio {
    private Integer Id_Servicio;
    private Integer Id_Noms;
    private Integer Id_Categoria;
    private String Descripcion;
    private float Precio;

    public Integer getId_Servicio() {
        return Id_Servicio;
    }

    public void setId_Servicio(Integer Id_Servicio) {
        this.Id_Servicio = Id_Servicio;
    }

    public Integer getId_Noms() {
        return Id_Noms;
    }

    public void setId_Noms(Integer Id_Noms) {
        this.Id_Noms = Id_Noms;
    }

    public Integer getId_Categoria() {
        return Id_Categoria;
    }

    public void setId_Categoria(Integer Id_Categoria) {
        this.Id_Categoria = Id_Categoria;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public float getPrecio() {
        return Precio;
    }

    public void setPrecio(float Precio) {
        this.Precio = Precio;
    }
    
    
}
