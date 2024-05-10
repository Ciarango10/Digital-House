package ejemplo;
import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestDB {

    public static void main(String[] args) throws Exception{

        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:"+ "tcp://localhost/~/test", "sa", "");
        Statement stmt = connection.createStatement();

        //Código para crear una tabla. Elimina la tabla si esta ya existe y la vuelve a crear
        String createTable = "DROP TABLE IF EXISTS TEST; CREATE TABLE TEST(ID INT PRIMARY KEY, NOMBRE VARCHAR(255))";
        stmt.execute(createTable);

        //Código para insertar registros en la tabla TEST
        String insertRow = "INSERT INTO TEST VALUES(1, 'Hola'); " +
                            "INSERT INTO TEST VALUES(2, 'Mundo');" +
                            "INSERT INTO TEST VALUES(3, 'Codigo');";
        stmt.execute(insertRow);

        //Código para consultar todos los registros de la tabla TEST
        String sql = "SELECT * FROM TEST";
        ResultSet rd = stmt.executeQuery(sql);

        //Código para recorrer el resultado de la consulta
        while(rd.next()) {
            System.out.println(rd.getInt(1) + rd.getString(2));
        }

    }

}
