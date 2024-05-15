package ejemplomesas.dh.backend;

import ejemploclase.dh.backend.db.H2Connection;
import ejemplomesas.dh.backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static Logger LOGGER = Logger.getLogger(Main.class);
    public static String SQL_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY, " +
            "NOMBRE VARCHAR(50) NOT NULL, APELLIDO VARCHAR(50) NOT NULL, MATRICULA VARCHAR(50) NOT NULL);";
    public static String SQL_SELECT = "SELECT * FROM ODONTOLOGOS;";
    public static String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT,?,?,?);";
    public static String SQL_UPDATE= "UPDATE ODONTOLOGOS SET MATRICULA = ? WHERE ID = ?";

    public static void main(String[] args) throws Exception {

        Connection connection = null;
        Statement statement = null;
        Odontologo odontologo = new Odontologo ("Carlos", "Arango", "FA1_0");
        Odontologo odontologoDesdeDb = null;

        try {

            connection = H2Connection.getConnection();
            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            //Empiezo a insertar en la base de datos
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setString(3, odontologo.getMatricula());

            preparedStatement.executeUpdate();

            //Mostramos los datos desde la base de datos
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()) {
                Integer id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String matricula = rs.getString(4);
                odontologoDesdeDb = new Odontologo(id, nombre, apellido, matricula);
            }
            LOGGER.info("Datos del odontologo: " + odontologoDesdeDb);

            //Update del odontologo
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1, "CIA_1901");
            preparedStatement.setInt(2, 1);

            preparedStatement.executeUpdate();
            odontologo.setMatricula("CIA_1901");


            //Mostramos los datos desde la base de datos
            rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()) {
                Integer id = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String matricula = rs.getString(4);
                odontologoDesdeDb = new Odontologo(id, nombre, apellido, matricula);
            }
            LOGGER.info("Datos del odontologo: " + odontologoDesdeDb);

        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            }catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

    }

}
