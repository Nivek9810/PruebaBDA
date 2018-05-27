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
public class DAO_Reserva {
    
    private DTO_Reserva objRes;
    private DTO_Habitacion objHab;
    private ArrayList<DTO_Habitacion> listHab;
    private ArrayList<DTO_Reserva> listR;
    
    private Statement statement;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;

    public DAO_Reserva() throws SQLException {
        this.objRes = new DTO_Reserva();
        this.listR = new ArrayList<>();
        this.objHab = new DTO_Habitacion();
        this.listHab = new ArrayList<>();
        
        this.con = new Conexion();
        this.resultSet = null;
        this.conection = con.getConnection();
        this.statement = conection.createStatement();
    }

    public DAO_Reserva(DTO_Reserva objRes, DTO_Habitacion objHab, ArrayList<DTO_Habitacion> listHab, ArrayList<DTO_Reserva> listR, Statement statement, Conexion con, ResultSet resultSet, Connection conection) {
        this.objRes = objRes;
        this.objHab = objHab;
        this.listHab = listHab;
        this.listR = listR;
        this.statement = statement;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    }

   
    
    public DTO_Reserva verReserva (){
        return objRes;
    }    
 
    public ArrayList<DTO_Habitacion> listarReserva (String consulta) throws SQLException{
        listHab.clear();
        resultSet = statement.executeQuery(consulta);
        while (resultSet.next()){
            listHab.add(new DTO_Habitacion(resultSet.getInt("nro_habitacion"),
                    resultSet.getInt("id_tipo"), 
                    resultSet.getFloat("valor_habitacion"), 
                    resultSet.getString("descripcion"), 
                    resultSet.getInt("nro_persona")));
        }
        return listHab;
    }
    
}
