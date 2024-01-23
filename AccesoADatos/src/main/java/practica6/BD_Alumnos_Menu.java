package practica6;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BD_Alumnos_Menu {

    private static final String JDBC_URL = "jdbc:mysql://localhost/bd_alumnos";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public Connection getConexion() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);
    }

    public void listarTablas() {
        try (Connection connection = getConexion()) {
            if (connection != null) {
                DatabaseMetaData metaData = connection.getMetaData();
                ResultSet resultSet = metaData.getTables("BD_Alumnos", null, "%", new String[]{"TABLE"});

                System.out.println("Tablas en la base de datos BD_Alumnos:");
                while (resultSet.next()) {
                    String tableName = resultSet.getString("TABLE_NAME");
                    System.out.println(tableName);
                }

            } else {
                System.out.println("No se pudo establecer la conexión con la base de datos.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet obtenerTabla(String tabla) {
        try {
            Connection connection = getConexion();
            if (connection == null) {
                System.out.println("Error al obtener datos de la tabla.");
                return null;
            }
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM " + tabla;
            ResultSet rs = stmt.executeQuery(sql);
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void mostrarTabla(String tabla) {
        ResultSet rs = obtenerTabla(tabla);
        if (rs == null) {
            System.out.println("Error al obtener datos de la tabla.");
            return;
        }
        try {
            int columnCount = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println(rs.getString(i) + "\t");
                }
                System.out.println();
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
