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
    private ArrayList<DTO_Habitacion> lst_Nacionalidad;

    private Statement statement;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;

    public DAO_Habitacion() throws SQLException {
        this.objH = new DTO_Habitacion();
        this.lst_Nacionalidad = new ArrayList<>();

        this.statement = null;
        this.resultSet = null;
        this.con = new Conexion();
        this.conection = con.getConnection();
        this.statement = conection.createStatement();
    }

    public DAO_Habitacion(DTO_Habitacion objH, ArrayList<DTO_Habitacion> lst_Nacionalidad, Statement statement, Conexion con, ResultSet resultSet, Connection conection) {
        this.objH = objH;
        this.lst_Nacionalidad = lst_Nacionalidad;
        this.statement = statement;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    }
    
    public ArrayList<DTO_Habitacion> listaHab(){
        
        return lst_Nacionalidad;
    } 

}
