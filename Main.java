import java.sql.SQLException;
import java.sql.ResultSet;

import singleton.ConexionSingleton;

public class Main{
    public static void main(String args[]){
        try {
            ConexionSingleton conexionSingleton = ConexionSingleton.getInstance(
                "jdbc:mysql://localhost:3306/IDGS101N", 
                "root", 
                "root");

            ResultSet resultSet = conexionSingleton.getConexion().query("select * from alumnos");
            while(resultSet.next()){
                System.out.printf("%-40s | %-40s", resultSet.getString("nombre"), resultSet.getString("email"));
              }
              System.out.println();
            conexionSingleton.getConexion().ejecutar("insert into alumnos values('Jordan', 'jordan@gmail.com')");
            conexionSingleton.getConexion().ejecutar("insert into alumnos values('Jaime', 'jaime@gmail.com')");
            conexionSingleton.getConexion().ejecutar("update alumnos set nombre = 'Gabriel', email = 'gabriel@gmail.com' where nombre = 'Jaime'");
            conexionSingleton.getConexion().ejecutar("delete from alumnos where nombre = 'Jordan'");
            //Segunda tabla
            ConexionSingleton conexionSingleton2 = ConexionSingleton.getInstance(
                "jdbc:mysql://localhost:3306/IDGS101N", 
                "root", 
                "root");

                ResultSet resultSet2 = conexionSingleton2.getConexion().query("select * from matriculas");
                while(resultSet2.next()){
                    System.out.printf(resultSet2.getString("matricula") + " ");
                  }
                  System.out.println();
            conexionSingleton2.getConexion().ejecutar("insert into matriculas values('1118150005')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}