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
public class DTO_Tipo_Habitacion {

    private Integer id_tipo;
    private String tipo_h;
    
    public DTO_Tipo_Habitacion(Integer id_tipo, String tipo_h) {
        this.id_tipo = id_tipo;
        this.tipo_h = tipo_h;
    }

    public DTO_Tipo_Habitacion() {
        this.id_tipo = 0;
        this.tipo_h = "";
    }

    public Integer getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(Integer id_tipo) {
        this.id_tipo = id_tipo;
    }

    public String getTipo_h() {
        return tipo_h;
    }

    public void setTipo_h(String tipo_h) {
        this.tipo_h = tipo_h;
    }

}
