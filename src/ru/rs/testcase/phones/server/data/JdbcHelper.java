
package ru.rs.testcase.phones.server.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import ru.rs.testcase.phones.server.ContactsException;

public class JdbcHelper {
    
    private Connection connection;
    
    {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            init();
        } catch (ContactsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public Connection getConnection() {

        try {

            connection =
                    DriverManager
                    .getConnection("jdbc:derby:phonebook;create=true");
            connection.setAutoCommit(false);
            connection
            .setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            if (connection == null) {
                System.out.println("OLOLO CONNECTION IS NULL");
            } else {
                System.out.println("Connection is not NULL");
            }
        } catch (SQLException e) {
            //
        }
        return connection;
        
    }
    
    public void init() throws ContactsException {

        try (Connection c = getConnection()) {
            if (c != null) {
                DatabaseMetaData meta = c.getMetaData();
                ResultSet rs =
                        meta.getTables(null, null, "phones".toUpperCase(), null);
                
                if (!rs.next()) {
                    Statement st = c.createStatement();
                    st.executeUpdate("CREATE TABLE PHONES (ID INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME VARCHAR(20) NOT NULL, PHONE VARCHAR(11) NOT NULL, PRIMARY KEY (NAME,PHONE))");
                    st.close();
                }
                c.commit();
                rs.close();
            } else {
                throw new ContactsException(
                        "Не удалось подключиться к Базе Данных");
            }
        } catch (SQLException e) {

            System.err.println("Table was not created");
            e.printStackTrace();
        }
    }
}
