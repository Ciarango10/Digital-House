package dh.backend.clinicamvc.dao.impl;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.db.H2Connection;
import dh.backend.clinicamvc.model.Domicilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component
public class DomicilioDaoH2 implements IDao<Domicilio> {

    private static Logger LOGGER = LoggerFactory.getLogger(DomicilioDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO DOMICILIOS VALUES (DEFAULT,?,?,?,?);";
    private static String SQL_SELECT_ID = "SELECT * FROM DOMICILIOS WHERE ID = ?;";
    private static String SQL_UPDATE = "UPDATE DOMICILIOS SET CALLE = ?, NUMERO = ?, LOCALIDAD = ?, PROVINCIA = ? WHERE ID = ?; ";
    private static String SQL_DELETE = "DELETE FROM DOMICILIOS WHERE ID = ?;";

    @Override
    public Domicilio registrar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio domicilioARetornar = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while (rs.next()) {
                Integer id = rs.getInt(1);
                domicilioARetornar = new Domicilio(id, domicilio.getCalle(), domicilio.getNumero(),
                        domicilio.getLocalidad(), domicilio.getLocalidad());
            }
            LOGGER.info("Domicilio persistido: " + domicilioARetornar);

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

        return domicilioARetornar;
    }

    @Override
    public Domicilio buscarPorId(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Domicilio domicilioEncontrado = null;
        try {

            connection = H2Connection.getConnection();

            preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Integer idEncontrado = rs.getInt(1);
                String calle = rs.getString(2);
                int numero = rs.getInt(3);
                String localidad = rs.getString(4);
                String provincia = rs.getString(5);
                domicilioEncontrado = new Domicilio(idEncontrado, calle, numero, localidad, provincia);
            }
            LOGGER.info("Domicilio encontrado: " + domicilioEncontrado);

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

        return domicilioEncontrado;
    }

    @Override
    public List<Domicilio> buscarTodos() {
        return null;
    }

    @Override
    public void actualizar(Domicilio domicilio) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.setInt(5, domicilio.getId());

            preparedStatement.executeUpdate();

            LOGGER.info("Domicilio Actualizado");

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

            LOGGER.info("Domicilio Eliminado");

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
