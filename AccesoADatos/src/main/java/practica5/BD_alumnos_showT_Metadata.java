package practica5;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD_alumnos_showT_Metadata {
    private static final String JDBC_URL = "jdbc:mysql://localhost/bd_alumnos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void ListarTablas() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet resultSet = metaData.getTables("bd_alumnos", null, "%", new String[]{"TABLE"});

                System.out.println("Dada la Base de datos bd_alumnos.");
                while (resultSet.next()) {
                    String tableName = resultSet.getString("TABLE_NAME");
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
        BD_alumnos_showT_Metadata bdAlumnosShowT = new BD_alumnos_showT_Metadata();
        bdAlumnosShowT.ListarTablas();
    }
}
