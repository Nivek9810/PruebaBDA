/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Familia MV
 */
public class Reserva_Habitacion {
    
    private Integer Id_ReservaFK;
    private Integer Nro_HabitacionFK;
    private Date Fecha_Llegada;
    private Date Fecha_Salida;

    public Integer getId_ReservaFK() {
        return Id_ReservaFK;
    }

    public void setId_ReservaFK(Integer Id_ReservaFK) {
        this.Id_ReservaFK = Id_ReservaFK;
    }

    public Integer getNro_HabitacionFK() {
        return Nro_HabitacionFK;
    }

    public void setNro_HabitacionFK(Integer Nro_HabitacionFK) {
        this.Nro_HabitacionFK = Nro_HabitacionFK;
    }

    public Date getFecha_Llegada() {
        return Fecha_Llegada;
    }

    public void setFecha_Llegada(Date Fecha_Llegada) {
        this.Fecha_Llegada = Fecha_Llegada;
    }

    public Date getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(Date Fecha_Salida) {
        this.Fecha_Salida = Fecha_Salida;
    }
    
    
    
    
}
