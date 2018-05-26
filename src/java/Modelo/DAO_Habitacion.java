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

    private DTO_Habitacion objH;
    private DTO_Tipo_Habitacion objHT;
    private ArrayList<DTO_Habitacion> lst_Nacionalidad;
    private ArrayList<DTO_Tipo_Habitacion>lista_tipoh;
    private ArrayList<DTO_Habitacion> nro_Persona;
    
    private Statement statement;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;

    public DAO_Habitacion() throws SQLException {
        this.objH = new DTO_Habitacion();
        this.objHT = new DTO_Tipo_Habitacion();
        
        this.lst_Nacionalidad = new ArrayList<>();
        this.lista_tipoh = new ArrayList<>();
        this.nro_Persona = new ArrayList<>();
        
        this.statement = null;
        this.resultSet = null;
        this.con = new Conexion();
        this.conection = con.getConnection();
        this.statement = conection.createStatement();
    }

    public DAO_Habitacion(DTO_Habitacion objH, DTO_Tipo_Habitacion objHT, ArrayList<DTO_Habitacion> lst_Nacionalidad, ArrayList<DTO_Tipo_Habitacion> lista_tipoh, ArrayList<DTO_Habitacion> nro_Persona, Statement statement, Conexion con, ResultSet resultSet, Connection conection) {
        this.objH = objH;
        this.objHT = objHT;
        this.lst_Nacionalidad = lst_Nacionalidad;
        this.lista_tipoh = lista_tipoh;
        this.nro_Persona = nro_Persona;
        this.statement = statement;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
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
    
    
    public ArrayList<DTO_Habitacion> listaHab(){
        String consulta = ""; 
        return lst_Nacionalidad;
    } 

}
