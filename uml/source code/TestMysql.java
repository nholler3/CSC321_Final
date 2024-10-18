import java.sql.DriverManager;

public class TestMysql {
    public static void main(String args[]) {
        try {
            /* Test loading driver */

            String driver = "com.mysql.cj.jdbc.Driver";

            System.out.println("\n=> loading driver:");
            Class.forName(driver);
            System.out.println("OK");

            /* Test the connection */

            String url = "jdbc:mysql://localhost:3306/test";

            System.out.println("\n=> connecting:");
            DriverManager.getConnection(url, "root", "");
            System.out.println("OK");
        } catch (Exception x) {
            System.err.println(x);
        }
    }
}
