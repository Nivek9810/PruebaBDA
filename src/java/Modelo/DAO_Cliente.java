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
    

    public DAO_Cliente(DTO_Cliente User, Statement statement, Email enviarE, Conexion con, ResultSet resultSet, Connection conection) {
        this.User = User;
        this.statement = statement;
        this.enviarE = enviarE;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    
    }

    public DAO_Cliente() throws SQLException {
        this.statement = null;
        this.resultSet = null;
        this.con = new Conexion();
        this.enviarE = new Email();
        this.conection = con.getConnection();
        this.User = new DTO_Cliente();
        this.statement = conection.createStatement();
        
    }

    public DTO_Cliente SessionU(String User, String Pass) throws SQLException {

        String query = "SELECT * FROM cliente WHERE id_cliente='" + User + "' AND contrasenac='" + Pass + "';";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            
            this.User.setId_Cliente(resultSet.getString("id_cliente"));
            this.User.setContrasenaC(resultSet.getString("contrasenac"));
           
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
            int res = statementUPD.executeUpdate(Query);
            /*if (res > 0) {
                enviarE.enviarCorreo(Mail, "Se ha modificado correctamente su nueva contraseña: " + Pass.substring(0, 2) + "**** ", "Contraseña nueva", null);
                Resp = true;
            }*/
        }
        return Resp;
    }
}
