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
public class Cliente_Tipo_Pago {
    
    private Integer Id_ClienteFK;
    private Integer Id_Tipo_PagoFK;
    private float Nro_Cuenta;

    public Integer getId_ClienteFK() {
        return Id_ClienteFK;
    }

    public void setId_ClienteFK(Integer Id_ClienteFK) {
        this.Id_ClienteFK = Id_ClienteFK;
    }

    public Integer getId_Tipo_PagoFK() {
        return Id_Tipo_PagoFK;
    }

    public void setId_Tipo_PagoFK(Integer Id_Tipo_PagoFK) {
        this.Id_Tipo_PagoFK = Id_Tipo_PagoFK;
    }

    public float getNro_Cuenta() {
        return Nro_Cuenta;
    }

    public void setNro_Cuenta(float Nro_Cuenta) {
        this.Nro_Cuenta = Nro_Cuenta;
    }
    
    
}
