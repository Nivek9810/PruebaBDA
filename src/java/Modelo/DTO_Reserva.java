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
    private Integer Cantidad;

    public DTO_Reserva(Integer Id_Reserva, Float Pago, Date Fecha_Hora_Entrada, Date Fecha_Hora_Salida, Integer Id_EmpleadoFK, Integer Id_Cliente, Integer Cantidad) {
        this.Id_Reserva = Id_Reserva;
        this.Pago = Pago;
        this.Fecha_Hora_Entrada = Fecha_Hora_Entrada;
        this.Fecha_Hora_Salida = Fecha_Hora_Salida;
        this.Id_EmpleadoFK = Id_EmpleadoFK;
        this.Id_Cliente = Id_Cliente;
        this.Cantidad = Cantidad;
    }

    public DTO_Reserva() {
        this.Id_Reserva = 0;
        this.Pago = null;
        this.Fecha_Hora_Entrada = null;
        this.Fecha_Hora_Salida = null;
        this.Id_EmpleadoFK = 0;
        this.Id_Cliente = 0;
        this.Cantidad = 0;
    }

    public Integer getCantidad() {
        return Cantidad;
    }

    public void setCantidad(Integer Cantidad) {
        this.Cantidad = Cantidad;
    }

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
