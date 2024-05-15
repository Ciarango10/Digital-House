package ejemplo2.dao.impl;

import ejemplo2.dao.IDao;
import ejemplo2.model.Avion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AvionDAOH2 implements IDao<Avion> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/db_test";
    private final static String DB_USER ="sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Avion guardar(Avion avion){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("INSERT INTO AVION VALUES(?,?,?,?,?);");
            preparedStatement.setLong(1, avion.getId());
            preparedStatement.setString(2, avion.getMarca());
            preparedStatement.setString(3, avion.getModelo());
            preparedStatement.setString(4, avion.getMatricula());
            preparedStatement.setString(5, avion.getFechaEntrada());

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }

        return avion;
    }

    @Override
    public void eliminar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("DELETE FROM AVION WHERE ID = ?");
            preparedStatement.setLong(1, id);

            //3 Ejecutar una sentencia SQL
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Avion buscar(Long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM AVION WHERE ID = ?");
            preparedStatement.setLong(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet rs = preparedStatement.executeQuery();

            //4 Obtener resultados
            while(rs.next()) {
                Long idAvion = rs.getLong(1);
                String marca = rs.getString(2);
                String modelo = rs.getString(3);
                String matricula = rs.getString(4);
                String fechaEntrada = rs.getString(5);

                avion = new Avion(idAvion, marca, modelo, matricula, fechaEntrada);
            }
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }

        return avion;
    }

    @Override
    public List<Avion> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Avion> aviones = new ArrayList<>();
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName(DB_JDBC_DRIVER).newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM AVION;");

            //3 Ejecutar una sentencia SQL
            ResultSet rs = preparedStatement.executeQuery();

            //4 Obtener resultados
            while(rs.next()) {
                Long idAvion = rs.getLong(1);
                String marca = rs.getString(2);
                String modelo = rs.getString(3);
                String matricula = rs.getString(4);
                String fechaEntrada = rs.getString(5);

                aviones.add(new Avion(idAvion, marca, modelo, matricula, fechaEntrada));
            }
            preparedStatement.close();
        }catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException throwables) {
            throwables.printStackTrace();
        }

        return aviones;
    }

}
