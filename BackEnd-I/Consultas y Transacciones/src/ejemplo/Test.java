package ejemplo;

import java.sql.*;

public class Test {

    public static final String SQL_CREATE = "DROP TABLE IF EXISTS USUARIO;" + "CREATE TABLE USUARIO" +
            "(" +
            "ID INT PRIMARY KEY," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "EMAIL VARCHAR(100) NOT NULL," +
            "SUELDO NUMERIC(15,2) NOT NULL" +
            ");";
    public static final String SQL_INSERT = "INSERT INTO USUARIO (ID, NOMBRE, EMAIL, SUELDO) VALUES (?,?,?,?);";
    public static final String SQL_UPDATE = "UPDATE USUARIO SET SUELDO = ? WHERE EMAIL = ?;";

    public static void main(String[] args) throws Exception {
        Usuario usuario = new Usuario("Pedro", "pedro@gmail.com", 10d);

        Connection connection = null;

        try {
            connection = getConnection();
            Statement statement = connection.createStatement();
            //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
            statement.execute(SQL_CREATE);

            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
            //Empiezo a insertar en la base de datos
            psInsert.setInt(1, 1);
            psInsert.setString(2, usuario.getNombre());
            psInsert.setString(3, usuario.getEmail());
            psInsert.setDouble(4, usuario.getSueldo());

            psInsert.executeUpdate();

            //Empieza la transacción
            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE);
            //Empiezo a actualizar en la base de datos
            psUpdate.setDouble(1, usuario.subirSueldo(10));
            psUpdate.setString(2, usuario.getEmail());

            psUpdate.executeUpdate();

            int a = 4/0;

            connection.commit();

            //Al finalizar la transacción es una buena practica poner de vuelta el setAutoCommit = true
            connection.setAutoCommit(true);

            //Código para consultar todos los usuarios de la tabla
            String sql = "SELECT * FROM USUARIO;";
            ResultSet rd = statement.executeQuery(sql);

            //Código para recorrer el resultado de la consulta
            while (rd.next()) {
                System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3)
                        + rd.getDouble(4));
            }

        } catch (Exception e) {
            e.printStackTrace();
            //Deshace todos los cambios hechos desde el ultimo commit
            connection.rollback();
        } finally {
            connection.close();
        }

        Connection connection1 = getConnection();
        Statement stmt = connection1.createStatement();
        String sql = "SELECT * FROM USUARIO;";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while (rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2) + rd.getString(3)
                    + rd.getDouble(4));
        }

    }

    private static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/clase", "sa", "sa");
    }

}
