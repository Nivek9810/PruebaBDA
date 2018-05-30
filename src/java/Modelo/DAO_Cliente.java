/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class DAO_Cliente {

    private DTO_Cliente User;
    private Statement statement;
    private Email enviarE;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;
    private GeneradorPass generadorPass;

    public DAO_Cliente(DTO_Cliente User, Statement statement, Email enviarE, Conexion con, ResultSet resultSet, Connection conection, GeneradorPass generadorPass) {
        this.User = User;
        this.statement = statement;
        this.enviarE = enviarE;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
        this.generadorPass = generadorPass;
    }

    public DAO_Cliente() throws SQLException {
        this.statement = null;
        this.resultSet = null;
        this.con = new Conexion();
        this.enviarE = new Email();
        this.conection = con.getConnection();
        this.User = new DTO_Cliente();
        this.statement = conection.createStatement();
        this.generadorPass = new GeneradorPass();
    }

    public String crearUsuarioRes(String id_persona, int nro_habitacion) throws SQLException {
        String id = "";
        String pass = this.generadorPass.getPassword(8);
        String Sql = "INSERT INTO CLIENTE (contrasenac, id_persona, nro_habitacion) "
                + "VALUES ('" + pass + "', '" + id_persona + "', " + nro_habitacion + ");";
        int r = statement.executeUpdate(Sql);
        String SQLID = "SELECT * FROM CLIENTE WHERE id_persona = '" + id_persona + "';";
        if (r > 0) {
            resultSet = statement.executeQuery(SQLID);
            while (resultSet.next()) {
                id = resultSet.getString("id_cliente");
            }
        }
        return id;
    }

    public DTO_Cliente SessionU(String User, String Pass) throws SQLException {

        String query = "SELECT * FROM cliente WHERE id_persona='" + User + "' AND contrasenac='" + Pass + "';";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            this.User.setId_Cliente(resultSet.getString("id_cliente"));
            this.User.setContrasenaC(resultSet.getString("contrasenac"));
            this.User.setId_PerosonaFK(resultSet.getString("id_persona"));
            this.User.setNro_Habitacion(resultSet.getInt("nro_habitacion"));

        }
        return this.User;
    }

    public boolean CambiarContra(String User, String Pass, String PassAnt) throws SQLException {
        String Sql = "SELECT * FROM cliente WHERE  contrasenac = '" + PassAnt + "' AND id_cliente ='" + User + "';";
        resultSet = statement.executeQuery(Sql);
        Statement statementUPD = conection.createStatement();
        boolean Resp = false;
        while (resultSet.next()) {
            String Query = "UPDATE cliente SET contrasenac = '" + Pass + "' WHERE id_cliente ='" + User + "';";
            statementUPD.executeUpdate(Query);
            Resp = true;
        }
        return Resp;
    }

    public DTO_Cliente infoCliente(String id_cliente) throws SQLException {

        String sql = "SELECT * FROM cliente WHERE id_cliente = '" + id_cliente + "';";
        resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            this.User.setContrasenaC(resultSet.getString("contrasenac"));
            this.User.setId_Cliente(resultSet.getString("id_cliente"));
            this.User.setId_PerosonaFK(resultSet.getString("id_persona"));
            this.User.setNro_Habitacion(resultSet.getInt("nro_habitacion"));
        }
        return this.User;
    }
}
