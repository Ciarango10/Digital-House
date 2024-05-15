package ejemploclase.dh.backend;

import ejemploclase.dh.backend.db.H2Connection;
import ejemploclase.dh.backend.model.Cuenta;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    public static Logger LOGGER = Logger.getLogger(Main.class);
    public static String SQL_CREATE = "DROP TABLE IF EXISTS CUENTAS; " +
            "CREATE TABLE CUENTAS(ID INT AUTO_INCREMENT PRIMARY KEY, NROCUENTA INT NOT NULL," +
            "NOMBRE VARCHAR(50) NOT NULL, SALDO NUMERIC(7,2) NOT NULL);";
    public static String SQL_INSERT = "INSERT INTO CUENTAS VALUES(DEFAULT,?,?,?);";
    public static String SQL_SELECT = "SELECT * FROM CUENTAS;";
    public static String SQL_UPDATE = "UPDATE CUENTAS SET SALDO = ? WHERE NROCUENTA = ?;";

    public static void main(String[] args) throws Exception{

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Cuenta cuenta = new Cuenta(1235,"cuenta.mp", 1000);
        Cuenta cuentaDesdeDb = null;

        try {

            connection = H2Connection.getConnection();
            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            Statement statement = connection.createStatement();
            statement.execute(SQL_CREATE);

            //Empiezo a insertar en la base de datos
            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setInt(1,cuenta.getNroCuenta());
            preparedStatement.setString(2, cuenta.getNombre());
            preparedStatement.setDouble(3, cuenta.getSaldo());

            preparedStatement.executeUpdate();

            //Mostramos los datos desde la base de datos
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()) {
                Integer id = rs.getInt(1);
                Integer nroCuenta = rs.getInt(2);
                String nombre = rs.getString(3);
                double saldo = rs.getDouble(4);
                cuentaDesdeDb = new Cuenta(id, nroCuenta, nombre, saldo);
            }
            LOGGER.info("Datos de la cuenta: " + cuentaDesdeDb);

            //Update de la cuenta
            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setDouble(1, cuenta.getSaldo()+10);
            preparedStatement.setInt(2,cuenta.getNroCuenta());

            preparedStatement.executeUpdate();
            cuenta.setSaldo(cuenta.getSaldo()+10);

            //Mostramos los datos desde la base de datos
            rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()) {
                Integer id = rs.getInt(1);
                Integer nroCuenta = rs.getInt(2);
                String nombre = rs.getString(3);
                double saldo = rs.getDouble(4);
                cuentaDesdeDb = new Cuenta(id, nroCuenta, nombre, saldo);
            }
            LOGGER.info("Datos de la cuenta: " + cuentaDesdeDb);

            //Update con transaccion
            connection.setAutoCommit(false);
            try {

                PreparedStatement preparedStatement1 = connection.prepareStatement(SQL_UPDATE);
                preparedStatement1.setDouble(1, cuenta.getSaldo()+15);
                preparedStatement1.setInt(2,cuenta.getNroCuenta());

                preparedStatement1.executeUpdate();
                //Generamos Excepcion
                int num = 10/0;
                connection.commit();
                cuenta.setSaldo(cuenta.getSaldo()+15);

            }catch (Exception e) {
                connection.rollback();
                LOGGER.error(e.getMessage());
            }
            connection.setAutoCommit(true);

            //Mostramos los datos desde la base de datos
            rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()) {
                Integer id = rs.getInt(1);
                Integer nroCuenta = rs.getInt(2);
                String nombre = rs.getString(3);
                double saldo = rs.getDouble(4);
                cuentaDesdeDb = new Cuenta(id, nroCuenta, nombre, saldo);
            }
            LOGGER.info("Datos de la cuenta: " + cuentaDesdeDb);

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
