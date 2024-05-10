package ejemploclase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    public static final Logger LOGGER = Logger.getLogger(Main.class);
    public static String SQL_CREATE =
            "DROP TABLE IF EXISTS ANIMAL;" +
            "CREATE TABLE ANIMAL (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "TIPO VARCHAR(50) NOT NULL, NOMBRE VARCHAR(50) NOT NULL);";
    public static String SQL_INSERT =
            "INSERT INTO ANIMAL VALUES" +
            "(DEFAULT, 'PERRO', 'ODIN')," +
            "(DEFAULT, 'GATO', 'ÑAÑA')," +
            "(DEFAULT, 'PEZ', 'JULIA')," +
            "(DEFAULT, 'PEZ', 'DORIS')," +
            "(DEFAULT, 'SAPO', 'PEPE');";
    public static String SQL_SELECT = "SELECT * FROM ANIMAL;";
    public static String SQL_DELETE = "DELETE FROM ANIMAL WHERE ID = 5;";

    public static void main(String[] args) {

        Connection connection = null;
        try {

            //Crear conexión a la base de datos
            connection = getConnection();
            Statement stmt = connection.createStatement();

            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            stmt.execute(SQL_CREATE);

            //Código para insertar registros en la tabla ANIMAL
            stmt.execute(SQL_INSERT);

            //Código para consultar todos los registros de la tabla ANIMAL
            ResultSet rd = stmt.executeQuery(SQL_SELECT);

            //Código para recorrer el resultado de la consulta
            while(rd.next()) {
                LOGGER.info("Animal: " + rd.getInt(1) + " - " + rd.getString(2) +
                        " - " + rd.getString(3));
            }

            //Código para eliminar un registro en la tabla ANIMAL
            stmt.execute(SQL_DELETE);

            //Consultamos nuevamente despues de eliminar el registro
            LOGGER.info("-------------------------------------------------------");
            rd = stmt.executeQuery(SQL_SELECT);

            //Recorremos el resultado de la consulta
            while(rd.next()) {
                LOGGER.info("Animal: " + rd.getInt(1) + " - " + rd.getString(2) +
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

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase8", "sa", "sa");
    }

}
