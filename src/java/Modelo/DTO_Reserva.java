/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.*;

/**
 *
 * @author Familia MV
 */
public class DTO_Reserva {
    
    private Integer Id_Reserva;
    private Float Pago;
    private Date Fecha_Hora_Entrada;
    private Date Fecha_Hora_Salida;
    private Integer Id_EmpleadoFK;
    private Integer Id_Cliente;

    public Integer getId_Reserva() {
        return Id_Reserva;
    }

    public void setId_Reserva(Integer Id_Reserva) {
        this.Id_Reserva = Id_Reserva;
    }

    public Float getPago() {
        return Pago;
    }

    public void setPago(Float Pago) {
        this.Pago = Pago;
    }

    public Date getFecha_Hora_Entrada() {
        return Fecha_Hora_Entrada;
    }

    public void setFecha_Hora_Entrada(Date Fecha_Hora_Entrada) {
        this.Fecha_Hora_Entrada = Fecha_Hora_Entrada;
    }

    public Date getFecha_Hora_Salida() {
        return Fecha_Hora_Salida;
    }

    public void setFecha_Hora_Salida(Date Fecha_Hora_Salida) {
        this.Fecha_Hora_Salida = Fecha_Hora_Salida;
    }

    public Integer getId_EmpleadoFK() {
        return Id_EmpleadoFK;
    }

    public void setId_EmpleadoFK(Integer Id_EmpleadoFK) {
        this.Id_EmpleadoFK = Id_EmpleadoFK;
    }

    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }
    
    
    
    
    
}
