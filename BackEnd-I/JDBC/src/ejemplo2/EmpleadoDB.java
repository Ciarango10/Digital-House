package ejemplo2;

import java.sql.*;

public class EmpleadoDB {

    public static void main(String[] args) throws Exception {

        Class.forName("org.h2.Driver").newInstance();

        //Crear conexión a la base de datos
        Connection connection = DriverManager.getConnection("jdbc:h2:"+ "tcp://localhost/~/test", "sa", "");
        Statement stmt = connection.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
        String createTable =
                "DROP TABLE IF EXISTS EMPLEADO; " +
                "CREATE TABLE EMPLEADO (ID INT PRIMARY KEY, NOMBRE VARCHAR(255), EDAD INT, EMPRESA VARCHAR(50), FECHATRABAJO DATE);";
        stmt.execute(createTable);

        //Código para insertar registros en la tabla EMPLEADO
        String insertRows =
                "INSERT INTO EMPLEADO (ID, NOMBRE, EDAD, EMPRESA, FECHATRABAJO) VALUES" +
                "(1, 'CARLOS ARANGO', 19, 'DIGITAL', '2024-05-09')," +
                "(2, 'SARA ECHEVERRI', 25, 'GOOGLE', '2020-01-31')," +
                "(3, 'CRISTINA HENAO', 40, 'FACEBOOK', '2022-09-18');";
        stmt.execute(insertRows);

        //Código para consultar todos los registros de la tabla EMPLEADO
        String sql = "SELECT * FROM EMPLEADO";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while(rd.next()) {
            System.out.println(rd.getInt(1) + " " + rd.getString(2) + " " + rd.getInt(3)
                    + " " + rd.getString(4) + " " + rd.getDate(5)
            );
        }

    }

}
