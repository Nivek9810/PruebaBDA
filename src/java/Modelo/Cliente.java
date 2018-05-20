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
public class Cliente {
    private Integer Id_Cliente ;
    private String ContrasenaC ;
    private Integer Id_PerosonaFK ;
    private Integer Nro_Habitacion ;

    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    public String getContrasenaC() {
        return ContrasenaC;
    }

    public void setContrasenaC(String ContrasenaC) {
        this.ContrasenaC = ContrasenaC;
    }

    public Integer getId_PerosonaFK() {
        return Id_PerosonaFK;
    }

    public void setId_PerosonaFK(Integer Id_PerosonaFK) {
        this.Id_PerosonaFK = Id_PerosonaFK;
    }

    public Integer getNro_Habitacion() {
        return Nro_Habitacion;
    }

    public void setNro_Habitacion(Integer Nro_Habitacion) {
        this.Nro_Habitacion = Nro_Habitacion;
    }
    
    
}
