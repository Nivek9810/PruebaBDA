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
 * @author Estudiante
 */
public class DAO_Persona {

    private DTO_Persona obj_Persona;
    private ArrayList<DTO_Nacionalidad> lst_Nacionalidad;
    private ArrayList<DTO_Tipo_Doc> lst_TipoDoc;
    
    private Statement statement;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;

    public DAO_Persona(DTO_Persona obj_Persona, ArrayList<DTO_Nacionalidad> lst_Nacionalidad, Statement statement, Conexion con, ResultSet resultSet, Connection conection) {
        this.obj_Persona = obj_Persona;
        this.lst_Nacionalidad = lst_Nacionalidad;
        this.statement = statement;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    }

    public DAO_Persona() throws SQLException {
        this.obj_Persona = new DTO_Persona();
        this.lst_Nacionalidad = new ArrayList<>();
        this.lst_TipoDoc = new ArrayList<>();
        this.con = new Conexion();
        this.resultSet = null;
        this.conection = con.getConnection();
        this.statement = conection.createStatement();
    }

    public DTO_Persona crearUsuario(String id_persona, Integer id_nacionalidad, Integer Id_Tipo_Doc, String nombre, String correo) throws SQLException {
        String Verificacion = "SELECT * FROM PERSONA WHERE correo = '" + correo + "'";
        String consulta = "INSERT INTO PERSONA Values ('" + id_persona + "', " + id_nacionalidad + ", " + Id_Tipo_Doc + ", '" + nombre + "', '" + correo + "');";
        ResultSet resultado = statement.executeQuery(Verificacion);
        
        if (!resultado.next()) {
            int r = statement.executeUpdate(consulta);
            if (r > 0) {
                obj_Persona = new DTO_Persona(id_persona, id_nacionalidad, Id_Tipo_Doc, nombre, correo);
            } else {
                obj_Persona = null;
            }
        }

        return obj_Persona;
    }

    public ArrayList<DTO_Nacionalidad> listarNacionalidad() throws SQLException {
        lst_Nacionalidad.clear();
        String consulta = "SELECT * FROM NACIONALIDAD;";
        resultSet = statement.executeQuery(consulta);
        while (resultSet.next()) {
            lst_Nacionalidad.add(new DTO_Nacionalidad(resultSet.getInt("Id_Nacio"), resultSet.getString("Pais_Origen")));
        }

        return lst_Nacionalidad;
    }

    public ArrayList<DTO_Tipo_Doc> listarTipoDoc() throws SQLException {
        lst_TipoDoc.clear();
        String consulta = "SELECT * FROM TIPO_DOC;";
        resultSet = statement.executeQuery(consulta);
        while (resultSet.next()) {
            lst_TipoDoc.add(new DTO_Tipo_Doc(resultSet.getInt("Id_Tipo_Doc"), resultSet.getString("Tipo_Docu")));
        }
        return lst_TipoDoc;
    }
}
