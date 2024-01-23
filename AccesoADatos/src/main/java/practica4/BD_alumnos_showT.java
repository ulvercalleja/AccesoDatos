package practica4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD_alumnos_showT {
    private static final String JDBC_URL = "jdbc:mysql://localhost/bd_alumnos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void ListarTablas() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            if (connection != null) {
                System.out.println("Dada la Base de datos bd_alumnos.");
                Statement statement = connection.createStatement();
                String query = "SHOW TABLES";
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String tableName = resultSet.getString(1);
                    System.out.println("TABLA " + tableName);
                }

            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BD_alumnos_showT bdAlumnosShowT = new BD_alumnos_showT();
        bdAlumnosShowT.ListarTablas();
    }
}
