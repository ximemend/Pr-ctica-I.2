package conexiondb;
//Paquetes para la conexion con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Conexion {
    
    private Connection connection;
    private Statement statement;

    public Conexion(String url, String user, String password){

        //Llamar la clase de conexión
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Método para intrucciones INSERT, UPDATE Y DELETE  
    public void ejecutar(String sql) throws SQLException{
        connection.createStatement().execute(sql);
    }

    //Método para SELECT
    public ResultSet query(String sqlQuery) throws SQLException{
        Statement statement = connection.createStatement();
        return statement.executeQuery(sqlQuery);
    }
}
