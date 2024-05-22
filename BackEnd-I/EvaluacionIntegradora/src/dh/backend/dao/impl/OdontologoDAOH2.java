package dh.backend.dao.impl;

import dh.backend.dao.IDao;
import dh.backend.db.H2Connection;
import dh.backend.model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOH2 implements IDao<Odontologo> {

    private static Logger LOGGER = Logger.getLogger(OdontologoDAOH2.class);
    private static String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT,?,?,?)";
    private static String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS;";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologoARetornar = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                odontologoARetornar = new Odontologo(id, odontologo.getNroMatricula(), odontologo.getNombre(), odontologo.getApellido());
            }
            LOGGER.info("Odontólogo guardado: " + odontologoARetornar);
            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception ex) {
            if(connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException e) {
                    LOGGER.info(e.getMessage());
                    e.printStackTrace();
                }
            }
            LOGGER.info(ex.getMessage());
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }

        return odontologoARetornar;
    }

    @Override
    public List<Odontologo> listarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        Odontologo odontologoEncontrado = null;
        try {

            connection = H2Connection.getConnection();
            statement = connection.createStatement();

            ResultSet resultSet =  statement.executeQuery(SQL_SELECT_ALL);
            while(resultSet.next()) {
                Integer idEncontrado = resultSet.getInt(1);
                int nroMatricula = resultSet.getInt(2);
                String nombre = resultSet.getString(3);
                String apellido = resultSet.getString(4);
                odontologoEncontrado = new Odontologo(idEncontrado, nroMatricula, nombre, apellido);
                LOGGER.info("Odontólogo listado: " + odontologoEncontrado);
                odontologos.add(odontologoEncontrado);
            }

        }catch (Exception ex) {
            LOGGER.info(ex.getMessage());
            ex.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.info(e.getMessage());
                e.printStackTrace();
            }
        }

        return odontologos;
    }

}
