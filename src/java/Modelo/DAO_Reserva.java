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
import java.util.Date;

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

    public DTO_Reserva verReserva() {
        return objRes;
    }

    public ArrayList<DTO_Habitacion> listarReserva(String consulta) throws SQLException {
        listHab.clear();
        resultSet = statement.executeQuery(consulta);
        while (resultSet.next()) {
            listHab.add(new DTO_Habitacion(resultSet.getInt("nro_habitacion"),
                    resultSet.getInt("id_tipo"),
                    resultSet.getFloat("valor_habitacion"),
                    resultSet.getString("descripcion"),
                    resultSet.getInt("nro_persona")));
        }
        return listHab;
    }

    public ArrayList<DTO_Habitacion> buscarReserva(Date fecha_inicio, Date fecha_fin, int Cant_personas, int id_tipoh) throws SQLException {
        ArrayList<DTO_Habitacion> listh = new ArrayList<>();
        String sql = "SELECT H.* \n"
                + "FROM TIPO_HABITACION AS TH\n"
                + "INNER JOIN HABITACION AS H\n"
                + "ON TH.id_tipo = H.id_tipo \n"
                + "WHERE H.id_tipo = "+id_tipoh+" AND H.nro_persona >= "+Cant_personas+" AND H.nro_habitacion = (\n"
                + "	SELECT RH.nro_habitacion \n"
                + "FROM RESERVA_HABITACION AS RH \n"
                + "WHERE '"+fecha_inicio+"' NOT BETWEEN RH.fecha_llegada AND RH.fecha_salida AND '"+fecha_fin+"' NOT BETWEEN RH.fecha_llegada AND RH.fecha_salida);";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {            
            listh.add(new DTO_Habitacion(resultSet.getInt("nro_habitacion"),
                    resultSet.getInt("id_tipo"),
                    resultSet.getFloat("valor_habitacion"), 
                    resultSet.getString("descripcion"), 
                    resultSet.getInt("nro_persona")));
        }
        return listh;
    }

    public ArrayList<DTO_Tipo_Habitacion> tipoHReserva(Integer id_tipo) throws SQLException {
        String sql = "SELECT * FROM tipo_habitacion WHERE id_tipo = " + id_tipo + ";";
        ArrayList<DTO_Tipo_Habitacion> lista_TipoH = new ArrayList<>();
        lista_TipoH.clear();
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            lista_TipoH.add(new DTO_Tipo_Habitacion(resultSet.getInt("id_tipo"),
                    resultSet.getString("tipo_h")));
        }
        return lista_TipoH;
    }

    public boolean generarReservaLlegada(DTO_Reserva objRes) throws SQLException {
        String consulta = "INSERT INTO RESERVA (pago, fecha_hora_)";
        boolean r = false;
        int res = statement.executeUpdate(consulta);
        if (res > 0) {
            r = true;
        }
        return r;
    }

}
