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
public class DTO_Cliente {
    private String Id_Cliente ;
    private String ContrasenaC ;
    private String Id_PerosonaFK ;
    private Integer Nro_Habitacion ;

    public DTO_Cliente() {
        this.Id_Cliente = "";
        this.ContrasenaC = "";
        this.Id_PerosonaFK = "";
        this.Nro_Habitacion = 0;
    }

    public DTO_Cliente(String Id_Cliente, String ContrasenaC, String Id_PerosonaFK, Integer Nro_Habitacion) {
        this.Id_Cliente = Id_Cliente;
        this.ContrasenaC = ContrasenaC;
        this.Id_PerosonaFK = Id_PerosonaFK;
        this.Nro_Habitacion = Nro_Habitacion;
    }
    
    

    public String getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(String Id_Cliente) {
        this.Id_Cliente = Id_Cliente;
    }

    

    public String getContrasenaC() {
        return ContrasenaC;
    }

    public void setContrasenaC(String ContrasenaC) {
        this.ContrasenaC = ContrasenaC;
    }

    public String getId_PerosonaFK() {
        return Id_PerosonaFK;
    }

    public void setId_PerosonaFK(String Id_PerosonaFK) {
        this.Id_PerosonaFK = Id_PerosonaFK;
    }

    public Integer getNro_Habitacion() {
        return Nro_Habitacion;
    }

    public void setNro_Habitacion(Integer Nro_Habitacion) {
        this.Nro_Habitacion = Nro_Habitacion;
    }
    
    
}
