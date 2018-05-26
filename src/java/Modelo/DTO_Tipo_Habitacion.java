
package Modelo;


public class DTO_Tipo_Habitacion {
    
    
    private Integer Id_Tipo;
    private String Tipo_h;

    public DTO_Tipo_Habitacion(Integer Id_Tipo, String Tipo_h) {
        this.Id_Tipo = Id_Tipo;
        this.Tipo_h = Tipo_h;
    }

    
    public DTO_Tipo_Habitacion() {
        this.Id_Tipo =0;
        this.Tipo_h ="";
    }
    
    public String getTipo_h() {
        return Tipo_h;
    }

    public void setTipo_h(String Tipo_h) {
        this.Tipo_h = Tipo_h;
    }

    public Integer getId_Tipo() {
        return Id_Tipo;
    }

    public void setId_Tipo(Integer Id_Tipo) {
        this.Id_Tipo = Id_Tipo;
    }
    
    
    
}
