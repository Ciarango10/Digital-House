package ejemplo2;

import java.sql.*;

public class Test {

    public static final String SQL_CREATE = "DROP TABLE IF EXISTS PACIENTE; CREATE TABLE PACIENTE" +
            "(" +
            "ID INT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL," +
            "DOMICILIO VARCHAR(100) NOT NULL," +
            "DNI VARCHAR(20) NOT NULL," +
            "FECHA_ALTA DATE NOT NULL," +
            "USUARIO VARCHAR(100) NOT NULL," +
            "PASSWORD VARCHAR(100) NOT NULL" +
            ");";
    public static final String SQL_INSERT = "INSERT INTO PACIENTE " +
            "(ID, NOMBRE, APELLIDO, DOMICILIO, DNI, FECHA_ALTA, USUARIO, PASSWORD)" +
            "VALUES (?,?,?,?,?,?,?,?);";
    public static final String SQL_UPDATE = "UPDATE PACIENTE SET PASSWORD = ? WHERE DNI = ?;";
    public static void main(String[] args) throws Exception {

        Paciente paciente = new Paciente("Carlos", "Arango", "CLL 45 NRO 24-05",
                "1025643641", "2024-05-11", "Ciarango", "1235*");

        Connection connection = null;
        try {
            connection = getConnection();
            Statement stmt = connection.createStatement();
            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            stmt.execute(SQL_CREATE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            //Empiezo a insertar en la base de datos
            psInsert.setInt(1, 1);
            psInsert.setString(2, paciente.getNombre());
            psInsert.setString(3, paciente.getApellido());
            psInsert.setString(4, paciente.getDomicilio());
            psInsert.setString(5, paciente.getDNI());
            psInsert.setString(6, paciente.getFechaDeAlta());
            psInsert.setString(7, paciente.getUsuario());
            psInsert.setString(8, paciente.getPassword());

            psInsert.executeUpdate();

            //Empieza la transacción
            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            //Empiezo a actualizar en la base de datos
            psUpdate.setString(1, paciente.cambiarContrasenia("colorverde"));
            psUpdate.setString(2, paciente.getDNI());

            psUpdate.executeUpdate();

            int a = 4/0;

            connection.commit();

            //Al finalizar la transacción es una buena practica poner de vuelta el setAutoCommit = true
            connection.setAutoCommit(true);

            //Código para consultar todos los pacientes de la tabla
            String sql = "SELECT * FROM PACIENTE;";
            ResultSet rd = stmt.executeQuery(sql);

            //Código para recorrer el resultado de la consulta
            while (rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3)
                        + rd.getString(4) + rd.getString(5) + rd.getString(6)
                        + rd.getString(7) + rd.getString(8));
            }

        }catch (Exception e) {
            e.printStackTrace();
            //Deshace todos los cambios hechos desde el ultimo commit
            connection.rollback();
        }finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        Statement statement = connection1.createStatement();
        String sql = "SELECT * FROM PACIENTE;";
        ResultSet rd = statement.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3)
                    + rd.getString(4) + rd.getString(5) + rd.getString(6)
                    + rd.getString(7) + rd.getString(8));
        }

    }

    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase", "sa", "sa");
    }

}
