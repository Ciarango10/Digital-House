package ejemplomesas;

import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(ejemploclase.Main.class);
    public static void main(String[] args) throws Exception {

        Class.forName("org.h2.Driver").newInstance();
        Connection connection = null;

        try {
            //Crear conexión a la base de datos
            connection = DriverManager.getConnection("jdbc:h2:~/clase8", "sa", "sa");
            Statement stmt = connection.createStatement();

            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            String SQL_CREATE = "DROP TABLE IF EXISTS FIGURA;" +
                    "CREATE TABLE FIGURA (ID INT AUTO_INCREMENT PRIMARY KEY, " +
                    "FIGURA VARCHAR(20) NOT NULL, COLOR VARCHAR(20) NOT NULL);";
            stmt.execute(SQL_CREATE);

            //Código para insertar registros en la tabla FIGURA
            String SQL_INSERT = "INSERT INTO FIGURA VALUES" +
                    "(DEFAULT, 'CIRCULO', 'ROJO')," +
                    "(DEFAULT, 'CIRCULO', 'ROJO')," +
                    "(DEFAULT, 'CIRCULO', 'VERDE')," +
                    "(DEFAULT, 'CUADRADO', 'BLANCO')," +
                    "(DEFAULT, 'CUADRADO', 'NEGRO')," +
                    "(DEFAULT, 'CUADRADO', 'AMARILLO');";
            stmt.execute(SQL_INSERT);

            //Código para consultar todos los circulos rojos de la tabla FIGURA
            String SQL_SELECT_CIRCULO_ROJO = "SELECT * FROM FIGURA WHERE FIGURA = 'CIRCULO' AND COLOR = 'ROJO';";
            ResultSet rd = stmt.executeQuery(SQL_SELECT_CIRCULO_ROJO);

            //Código para recorrer el resultado de la consulta
            while(rd.next()) {
                LOGGER.info("Figura: " + rd.getInt(1) + " - " + rd.getString(2) +
                        " - " + rd.getString(3));
            }

            //Código para consultar todos los registros de la tabla FIGURA
            LOGGER.info("-------------------------------------------------------");
            String SQL_SELECT = "SELECT * FROM FIGURA;";
            rd = stmt.executeQuery(SQL_SELECT);

            //Código para recorrer el resultado de la consulta
            while(rd.next()) {
                LOGGER.info("Figura: " + rd.getInt(1) + " - " + rd.getString(2) +
                        " - " + rd.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                LOGGER.error(e.getMessage());
            }
        }

    }

}
