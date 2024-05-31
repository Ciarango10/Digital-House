package dh.backend.clinicamvc.dao.impl;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.db.H2Connection;
import dh.backend.clinicamvc.model.Odontologo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class OdontologoDaoH2 implements IDao<Odontologo> {

    private static Logger LOGGER = LoggerFactory.getLogger(OdontologoDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES (DEFAULT,?,?,?)";
    private static String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS;";
    private static String SQL_SELECT_ID = "SELECT * FROM ODONTOLOGOS WHERE ID = ?;";
    private static String SQL_UPDATE = "UPDATE ODONTOLOGOS SET NROMATRICULA = ?, NOMBRE = ?, APELLIDO = ? WHERE ID = ?;";
    private static String SQL_DELETE = "DELETE FROM ODONTOLOGOS WHERE ID = ?;";

    @Override
    public Odontologo registrar(Odontologo odontologo) {
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
    public Odontologo buscarPorId(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologoEncontrado = null;
        try {

            connection = H2Connection.getConnection();

            preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Integer idEncontrado = rs.getInt(1);
                int nroMatricula = rs.getInt(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);

                odontologoEncontrado = new Odontologo(idEncontrado, nroMatricula, nombre, apellido);
            }
            LOGGER.info("Odontologo encontrado: " + odontologoEncontrado);

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

        return odontologoEncontrado;
    }

    @Override
    public List<Odontologo> buscarTodos() {
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

    @Override
    public void actualizar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, odontologo.getNroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setInt(4, odontologo.getId());

            preparedStatement.executeUpdate();

            LOGGER.info("Odontólogo actualizado");

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

    }

    @Override
    public void eliminar(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            LOGGER.info("Odontologo eliminado");

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
    }

}
