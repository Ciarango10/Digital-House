package dh.backend.clinicamvc.dao.impl;

import dh.backend.clinicamvc.dao.IDao;
import dh.backend.clinicamvc.db.H2Connection;
import dh.backend.clinicamvc.model.Domicilio;
import dh.backend.clinicamvc.model.Paciente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class PacienteDaoH2 implements IDao<Paciente> {

    private static Logger LOGGER = LoggerFactory.getLogger(PacienteDaoH2.class);
    private static String SQL_INSERT = "INSERT INTO PACIENTES VALUES (DEFAULT,?,?,?,?,?);";
    private static String SQL_SELECT_ID = "SELECT * FROM PACIENTES WHERE ID = ?;";
    private static String SQL_SELECT_ALL = "SELECT * FROM PACIENTES;";
    private static String SQL_DELETE = "DELETE FROM PACIENTES WHERE ID = ?;";
    private static String SQL_UPDATE = "UPDATE PACIENTES SET APELLIDO = ?, NOMBRE = ?, DNI = ?, FECHA_INGRESO = ?, ID_DOMICILIO = ? WHERE ID = ?;";

    @Override
    public Paciente registrar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        Paciente pacienteARetornar = null;
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            Domicilio domicilioGuardado = domicilioDaoH2.registrar(paciente.getDomicilio());

            preparedStatement = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDNI());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, domicilioGuardado.getId());

            preparedStatement.executeUpdate();

            ResultSet rs = preparedStatement.getGeneratedKeys();
            while(rs.next()) {
                Integer id = rs.getInt(1);
                pacienteARetornar = new Paciente(id, paciente.getNombre(), paciente.getApellido(), paciente.getDNI(),
                        paciente.getFechaIngreso(), domicilioGuardado);
            }
            LOGGER.info("Paciente guardado: " + pacienteARetornar);

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

        return pacienteARetornar;
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente pacienteEncontrado = null;
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        try {

            connection = H2Connection.getConnection();

            preparedStatement = connection.prepareStatement(SQL_SELECT_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()) {
                Integer idEncontrado = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String DNI = rs.getString(4);
                LocalDate fecha = rs.getDate(5).toLocalDate();
                Integer idDomicilio = rs.getInt(6);
                Domicilio domicilioEncontrado = domicilioDaoH2.buscarPorId(idDomicilio);

                pacienteEncontrado = new Paciente(idEncontrado, nombre, apellido, DNI, fecha, domicilioEncontrado);
            }
            LOGGER.info("Paciente encontrado: " + pacienteEncontrado);

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

        return pacienteEncontrado;
    }

    @Override
    public List<Paciente> buscarTodos() {
        List<Paciente> pacientes = new ArrayList<>();
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        Connection connection = null;
        Statement stmt = null;
        try {

            connection = H2Connection.getConnection();
            stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Integer idEncontrado = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String DNI = rs.getString(4);
                LocalDate fecha = rs.getDate(5).toLocalDate();
                Integer idDomicilio = rs.getInt(6);
                Domicilio domicilioEncontrado = domicilioDaoH2.buscarPorId(idDomicilio);

                Paciente paciente = new Paciente(idEncontrado, nombre, apellido, DNI, fecha, domicilioEncontrado);
                LOGGER.info("Paciente listado: " + paciente);
                pacientes.add(paciente);
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

        return pacientes;
    }

    @Override
    public void actualizar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            domicilioDaoH2.actualizar(paciente.getDomicilio());

            preparedStatement = connection.prepareStatement(SQL_UPDATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setString(3, paciente.getDNI());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, paciente.getDomicilio().getId());
            preparedStatement.setInt(6, paciente.getId());

            preparedStatement.executeUpdate();

            LOGGER.info("Paciente actualizado");

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
        DomicilioDaoH2 domicilioDaoH2 = new DomicilioDaoH2();
        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_DELETE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            LOGGER.info("Paciente eliminado");

            connection.commit();
            connection.setAutoCommit(true);

        }catch (Exception e) {
            if(connection!=null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    LOGGER.info(ex.getMessage());
                    ex.printStackTrace();
                }
            }
            LOGGER.info(e.getMessage());
            e.printStackTrace();
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
