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
public class DTO_Habitacion {
    private Integer Nro_Habitacion;
    private Integer Id_Tipo;
    private float Valor_Habitacion;
    private String Descripcion;
    private Integer Nro_persona;

    public Integer getNro_Habitacion() {
        return Nro_Habitacion;
    }

    public void setNro_Habitacion(Integer Nro_Habitacion) {
        this.Nro_Habitacion = Nro_Habitacion;
    }

    public Integer getId_Tipo() {
        return Id_Tipo;
    }

    public void setId_Tipo(Integer Id_Tipo) {
        this.Id_Tipo = Id_Tipo;
    }

    public float getValor_Habitacion() {
        return Valor_Habitacion;
    }

    public void setValor_Habitacion(float Valor_Habitacion) {
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
    
    
}
