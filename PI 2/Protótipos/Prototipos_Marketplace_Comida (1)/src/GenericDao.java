
import java.sql.*;

public class GenericDao {

    private Connection c;

    public GenericDao() {
        super();
    }

    public Connection getConnection()
            throws ClassNotFoundException, SQLException {

        String host = "DESKTOP-0DT2STD";
        String dbName = "Delivery";
        String user = "Eduardo";
        String senha = "senhabd123";

        Class.forName("net.sourceforge.jtds.jdbc.Driver");

        String url = "jdbc:jtds:sqlserver://" + host
                   + ":1433/" + dbName;

        c = DriverManager.getConnection(url, user, senha);

        return c;
    }
}