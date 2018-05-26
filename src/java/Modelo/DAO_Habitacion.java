/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DAO_Habitacion {

    private DTO_Habitacion_V objHV;
    private DTO_Habitacion objH;
    private ArrayList<DTO_Tipo_Habitacion> lista_tipoh;
    private DTO_Tipo_Habitacion objHT;
    private ArrayList<DTO_Habitacion_V> lstHabV;
    private ArrayList<DTO_Habitacion> nro_Persona;
    
    private Statement statement;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;

    public DAO_Habitacion(DTO_Habitacion_V objHV, DTO_Habitacion objH, ArrayList<DTO_Tipo_Habitacion> lista_tipoh, DTO_Tipo_Habitacion objHT, ArrayList<DTO_Habitacion_V> lstHabV, ArrayList<DTO_Habitacion> nro_Persona, Statement statement, Conexion con, ResultSet resultSet, Connection conection) {
        this.objHV = objHV;
        this.objH = objH;
        this.lista_tipoh = lista_tipoh;
        this.objHT = objHT;
        this.lstHabV = lstHabV;
        this.nro_Persona = nro_Persona;
        this.statement = statement;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    }

      
    

    public DAO_Habitacion() throws SQLException {
        this.objHV = new DTO_Habitacion_V();
        this.objH = new DTO_Habitacion();
        this.objHT = new DTO_Tipo_Habitacion();
        
        this.lstHabV = new ArrayList<>();
        this.lista_tipoh = new ArrayList<>();
        this.nro_Persona = new ArrayList<>();
        
        this.resultSet = null;
        this.con = new Conexion();
        this.conection = con.getConnection();
        this.statement = conection.createStatement();
    }


    

    public ArrayList<DTO_Habitacion_V> listaHab(Integer id_tipo) throws SQLException {
        lstHabV.clear();
        String consulta = "SELECT * FROM habitacion WHERE id_tipo = " + id_tipo + "; "; 
        resultSet = statement.executeQuery(consulta);
        while (resultSet.next()) {
            this.objHV.setTipo(resultSet.getString("tipo_h"));
            this.objHV.setNro_Habitacion(resultSet.getInt("nro_habitacion"));
            this.objHV.setValor_Habitacion(resultSet.getFloat("valor_habitacion"));
            this.objHV.setDescripcion(resultSet.getString("descripcion"));
            this.objHV.setNro_persona(resultSet.getInt("nro_persona"));
            lstHabV.add(objHV);
        }
        return lstHabV;
    }
    
    public ArrayList<DTO_Tipo_Habitacion>listatp() throws SQLException{
        lista_tipoh.clear();
        String consulta="SELECT * FROM TIPO_HABITACION;";
        resultSet = statement.executeQuery(consulta);
        while(resultSet.next()){
         lista_tipoh.add(new DTO_Tipo_Habitacion(resultSet.getInt("Id_Tipo"),resultSet.getString("Tipo_h")));
        }
        return lista_tipoh;
    }
    
    public ArrayList<DTO_Habitacion>listanro() throws SQLException{
        nro_Persona.clear();
        String consulta="SELECT * FROM HABITACION;";
        resultSet = statement.executeQuery(consulta);
        while(resultSet.next()){
         nro_Persona.add(new DTO_Habitacion(resultSet.getInt("Nro_Habitacion"),resultSet.getInt("Id_Tipo"),resultSet.getFloat("Valor_Habitacion"),resultSet.getString("Descripcion"),resultSet.getInt("Nro_Persona")));
        }
        return nro_Persona;
    }
    
    
    
    private ArrayList<Integer> resInt(int i) {
        ArrayList<Integer> numero = new ArrayList<>();
        numero.add(i);
        return numero;
    }

    private ArrayList<String> resString(String t) {
        ArrayList<String> texto = new ArrayList<>();
        texto.add(t);
        return texto;
    }

    private ArrayList<Float> resFloat(Float d) {
        ArrayList<Float> dinero = new ArrayList<>();
        dinero.add(d);
        return dinero;
    }

}
