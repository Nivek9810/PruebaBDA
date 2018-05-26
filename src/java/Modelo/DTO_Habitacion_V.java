/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Familia MV
 */
public class DTO_Habitacion_V {

    private Integer Nro_Habitacion;
    private String Tipo;
    private Float Valor_Habitacion;
    private String Descripcion;
    private Integer Nro_persona;
    private Integer id_tipo;

    public DTO_Habitacion_V() {
        this.Nro_Habitacion = 0;
        this.Tipo = "";
        this.Valor_Habitacion = null;
        this.Descripcion = "";
        this.Nro_persona = 0;
        this.id_tipo = 0;
    }

    public DTO_Habitacion_V(Integer Nro_Habitacion, String Tipo, Float Valor_Habitacion, String Descripcion, Integer Nro_persona, Integer id_tipo) {
        this.Nro_Habitacion = Nro_Habitacion;
        this.Tipo = Tipo;
        this.Valor_Habitacion = Valor_Habitacion;
        this.Descripcion = Descripcion;
        this.Nro_persona = Nro_persona;
        this.id_tipo = id_tipo;
    }

    public Integer getNro_Habitacion() {
        return Nro_Habitacion;
    }

    public void setNro_Habitacion(Integer Nro_Habitacion) {
        this.Nro_Habitacion = Nro_Habitacion;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public Float getValor_Habitacion() {
        return Valor_Habitacion;
    }

    public void setValor_Habitacion(Float Valor_Habitacion) {
        this.Valor_Habitacion = Valor_Habitacion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public Integer getNro_persona() {
        return Nro_persona;
    }

    public void setNro_persona(Integer Nro_persona) {
        this.Nro_persona = Nro_persona;
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    

}
