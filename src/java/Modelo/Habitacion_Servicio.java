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
public class Habitacion_Servicio {
   private Integer Nro_HabitacionFK;
   private Integer Id_ServicioFK;
   private Integer Cantidad;

    public Integer getNro_HabitacionFK() {
        return Nro_HabitacionFK;
    }

    public void setNro_HabitacionFK(Integer Nro_HabitacionFK) {
        this.Nro_HabitacionFK = Nro_HabitacionFK;
    }

    public Integer getId_ServicioFK() {
        return Id_ServicioFK;
    }

    public void setId_ServicioFK(Integer Id_ServicioFK) {
        this.Id_ServicioFK = Id_ServicioFK;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }
   
   
}
