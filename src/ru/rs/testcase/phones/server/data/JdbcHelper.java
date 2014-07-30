package ru.rs.testcase.phones.server.data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcHelper {
	private Connection connection;

	{
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		init();
	}

	public Connection getConnection() {
		try {
			connection = DriverManager
					.getConnection("jdbc:derby:phonebook;create=true");
		} catch (SQLException e) {
			//
		}
		return connection;

	}

	public void init() {
		try (Connection c = getConnection()) {
			c.setAutoCommit(false);
			c.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			DatabaseMetaData meta = c.getMetaData();
			ResultSet rs = meta.getTables(null, null, "phones".toUpperCase(),
					null);

			if (!rs.next()) {
				System.out.println("Starting to create table");
				Statement st = c.createStatement();
				System.out.println("Starting to create table 2");
				st.executeUpdate("CREATE TABLE PHONES (ID INT NOT NULL, NAME VARCHAR(20) NOT NULL, PHONE VARCHAR(11) NOT NULL, PRIMARY KEY (NAME,PHONE))");
				System.out.println("Table created");
				st.close();

			}
			c.commit();
			rs.close();
		} catch (SQLException e) {

			System.err.println("Table was not created");
			e.printStackTrace();
		}
	}
}
