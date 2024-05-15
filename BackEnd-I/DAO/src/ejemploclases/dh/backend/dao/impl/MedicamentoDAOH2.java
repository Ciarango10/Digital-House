package ejemploclases.dh.backend.dao.impl;

import ejemploclases.dh.backend.dao.IDao;
import ejemploclases.dh.backend.db.H2Connection;
import ejemploclases.dh.backend.model.Medicamento;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoDAOH2 implements IDao<Medicamento> {

    public static Logger LOGGER = Logger.getLogger(MedicamentoDAOH2.class);
    public static String SQL_INSERT = "INSERT INTO MEDICAMENTOS VALUES (DEFAULT,?,?,?,?,?);";
    public static String SQL_SELECT = "SELECT * FROM MEDICAMENTOS WHERE NOMBRE = ?;";
    public static String SQL_SELECT_ID = "SELECT * FROM MEDICAMENTOS WHERE ID = ?;";
    public static String SQL_SELECT_ALL = "SELECT * FROM MEDICAMENTOS;";

    @Override
    public Medicamento registrar(Medicamento medicamento) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamentoARetornar = null;
        try {

            //1 Levantar el driver y Conectarnos
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, medicamento.getCodigo());
            preparedStatement.setString(2, medicamento.getNombre());
            preparedStatement.setString(3, medicamento.getLaboratorio());
            preparedStatement.setInt(4, medicamento.getCantidad());
            preparedStatement.setDouble(5, medicamento.getPrecio());

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();

            //4 Obtener resultados
            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                medicamentoARetornar = new Medicamento(id, medicamento.getCodigo(), medicamento.getNombre(),
                        medicamento.getLaboratorio(), medicamento.getCantidad(), medicamento.getPrecio());
            }
            LOGGER.info("Medicamento persistido: " + medicamentoARetornar);

            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e) {
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.error(ex.getMessage());
                }
            }
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

        return medicamentoARetornar;
    }

    @Override
    public Medicamento buscarPorCampo(String campo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamentoARetornar = null;
        try {

            //1 Levantar el driver y Conectarnos
            connection = H2Connection.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT);
            preparedStatement.setString(1, campo.toUpperCase());

            //3 Ejecutar una sentencia SQL
            ResultSet rs = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer codigo = rs.getInt(2);
                String nombre = rs.getString(3);
                String laboratorio = rs.getString(4);
                int cantidad = rs.getInt(5);
                double precio = rs.getDouble(6);

                medicamentoARetornar = new Medicamento(id, codigo, nombre, laboratorio, cantidad, precio);
            }
            LOGGER.info("El Medicamento encontrado es: " + medicamentoARetornar);

        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

        return medicamentoARetornar;
    }

    @Override
    public Medicamento buscarPorId(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Medicamento medicamentoARetornar = null;
        try {

            //1 Levantar el driver y Conectarnos
            connection = H2Connection.getConnection();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet rs = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (rs.next()) {
                Integer idMedicamento = rs.getInt(1);
                Integer codigo = rs.getInt(2);
                String nombre = rs.getString(3);
                String laboratorio = rs.getString(4);
                int cantidad = rs.getInt(5);
                double precio = rs.getDouble(6);

                medicamentoARetornar = new Medicamento(idMedicamento, codigo, nombre, laboratorio, cantidad, precio);
            }
            LOGGER.info("El Medicamento encontrado es: " + medicamentoARetornar);

        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

        return medicamentoARetornar;
    }

    @Override
    public List<Medicamento> buscarTodos() {
        Connection connection = null;
        Statement stmt = null;
        Medicamento medicamento = null;
        List<Medicamento> medicamentos = new ArrayList<>();
        try {

            //1 Levantar el driver y Conectarnos
            connection = H2Connection.getConnection();
            stmt = connection.createStatement();

            //2 Crear una sentencia
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);

            //3 Obtener resultados
            while (rs.next()) {
                Integer id = rs.getInt(1);
                Integer codigo = rs.getInt(2);
                String nombre = rs.getString(3);
                String laboratorio = rs.getString(4);
                int cantidad = rs.getInt(5);
                double precio = rs.getDouble(6);

                medicamento = new Medicamento(id, codigo, nombre, laboratorio, cantidad, precio);
                LOGGER.info("Medicamento devuelto: " + medicamento);

                medicamentos.add(medicamento);
            }

        }catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try{
                connection.close();
            }catch (Exception e) {
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            }
        }

        return medicamentos;
    }

}
