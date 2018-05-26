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

/**
 *
 * @author user
 */
public class DAO_Empleado {

    private DTO_Empleado User;
    private Statement statement;
    private Email enviarE;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;

    public DAO_Empleado(DTO_Empleado User, Statement statement, Email enviarE, Conexion con, ResultSet resultSet, Connection conection) {
        this.User = User;
        this.statement = statement;
        this.enviarE = enviarE;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    }

    
    public DAO_Empleado() throws SQLException {
        this.resultSet = null;
        this.con = new Conexion();
        this.enviarE = new Email();
        this.conection = con.getConnection();
        this.User = new DTO_Empleado();
        this.statement = conection.createStatement();
    }

    public DTO_Empleado SessionE(String usuario, String Pass) throws SQLException {

        String query = "SELECT * FROM empleado WHERE id_empleado='" + usuario + "' AND contrasena='" + Pass + "';";
        resultSet = statement.executeQuery(query);
        while (resultSet.next()) {

            this.User.setId_Empleado(resultSet.getString("id_empleado"));
            this.User.setContrasena(resultSet.getString("contrasena"));
            this.User.setId_PersonaFK(resultSet.getString("id_persona"));
            this.User.setCargo(resultSet.getInt("id_cargo"));

        }
        return User;
    }

    

}
