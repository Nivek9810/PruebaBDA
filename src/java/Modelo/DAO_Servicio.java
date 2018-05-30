
package Modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Familia MV
 */
public class DAO_Servicio {
    
    
    private DTO_Servicio objS;
    private DTO_Nombre_Servicio obsnS;
    
    private ArrayList<DTO_Nombre_Servicio> lista;

    
    
    private Statement statement;
    private Conexion con;
    private ResultSet resultSet;
    private Connection conection;
    
    
    
    
    
    public DAO_Servicio() throws SQLException {
        
        this.objS = new DTO_Servicio();
        this.obsnS = new DTO_Nombre_Servicio();
        
        this.lista = new ArrayList<>();
  
        this.statement = null;
        this.resultSet = null;
        this.con = new Conexion();
        this.conection = con.getConnection();
        this.statement = conection.createStatement();
    }

    public DAO_Servicio(DTO_Servicio objS, DTO_Nombre_Servicio obsnS, ArrayList<DTO_Nombre_Servicio> lista, Statement statement, Conexion con, ResultSet resultSet, Connection conection) {
        this.objS = objS;
        this.obsnS = obsnS;
        this.lista = lista;
        this.statement = statement;
        this.con = con;
        this.resultSet = resultSet;
        this.conection = conection;
    }

   
    

    
    
    public ArrayList<DTO_Nombre_Servicio>lista_Ali() throws SQLException{
    
       lista.clear();
       
       String consulta ="SELECT *"
               + "FROM Categoria,Nombre_Servicio, Servicio "
               + "WHERE Servicio.Id_Categoria = Categoria.Id_Categoria "
               + "AND Servicio.Id_Noms = Nombre_Servicio.Id_Noms "
               + "AND Categoria.Categoria = 'Alimentos';";
       resultSet = statement.executeQuery(consulta);
       while(resultSet.next()){
           lista.add(new DTO_Nombre_Servicio(resultSet.getInt("Id_Noms"),resultSet.getString("Servicio")));
       }
    
    return lista;
    }
    
    
    public ArrayList<DTO_Nombre_Servicio>lista_Bebi() throws SQLException{
    
       lista.clear();
       
       String consulta ="SELECT *"
               + "FROM Categoria,Nombre_Servicio, Servicio "
               + "WHERE Servicio.Id_Categoria = Categoria.Id_Categoria "
               + "AND Servicio.Id_Noms = Nombre_Servicio.Id_Noms "
               + "AND Categoria.Categoria = 'Bebidas Alcolicas';";
       resultSet = statement.executeQuery(consulta);
       while(resultSet.next()){
           lista.add(new DTO_Nombre_Servicio(resultSet.getInt("Id_Noms"),resultSet.getString("Servicio")));
       }
    
    return lista;
    }
    
    
    public ArrayList<DTO_Nombre_Servicio>lista_Ase() throws SQLException{
    
       lista.clear();
       
       String consulta ="SELECT *"
               + "FROM Categoria,Nombre_Servicio, Servicio "
               + "WHERE Servicio.Id_Categoria = Categoria.Id_Categoria "
               + "AND Servicio.Id_Noms = Nombre_Servicio.Id_Noms "
               + "AND Categoria.Categoria = 'Productos Aseo';";
       resultSet = statement.executeQuery(consulta);
       while(resultSet.next()){
           lista.add(new DTO_Nombre_Servicio(resultSet.getInt("Id_Noms"),resultSet.getString("Servicio")));
       }
    
    return lista;
    }
    
    
    
    
    
}
