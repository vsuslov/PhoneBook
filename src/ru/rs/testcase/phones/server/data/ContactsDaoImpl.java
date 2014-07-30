package ru.rs.testcase.phones.server.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.rs.testcase.phones.model.Contact;

public class ContactsDaoImpl implements ContactsDao {
	private JdbcHelper helper = new JdbcHelper();

	@Override
	public Contact createContact(Contact contact) {

		try (Connection connect = helper.getConnection()) {
			connect.setAutoCommit(false);
			PreparedStatement st = connect
					.prepareStatement("INSERT INTO PHONES(NAME,PHONE) VALUES(?,?)");
			st.setString(1, contact.getName());
			st.setString(2, contact.getPhone());
			int rs = st.executeUpdate();
			if (rs > 0) {
				System.out.println("Contact is created");
			}
			connect.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Contact> findAllContacts() {
		List<Contact> result = new ArrayList<>();
		try (Connection c = helper.getConnection()) {
			Statement st = c.createStatement();
			ResultSet rs = st.executeQuery("SELECT NAME,PHONE FROM PHONES");
			while (rs.next()) {
				Contact contact = new Contact();

				contact.setName(rs.getString("NAME"));
				contact.setPhone(rs.getString("PHONE"));
				result.add(contact);
			}
			c.commit();
			rs.close();
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Contact> findBySubstring(String subString) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Contact updateContact(Contact contact) {

		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeContact(Contact contact) {

		// TODO Auto-generated method stub

	}

}
