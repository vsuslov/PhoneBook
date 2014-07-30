
package ru.rs.testcase.phones.server.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.ContactsException;

public class ContactsDaoImpl implements ContactsDao {

    private JdbcHelper helper = new JdbcHelper();

    @Override
    public Contact createContact(Contact contact) {

        try (Connection connect = helper.getConnection()) {
            connect.setAutoCommit(false);
            PreparedStatement st =
                    connect.prepareStatement("INSERT INTO PHONES(NAME,PHONE) VALUES(?,?)");
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
    public List<Contact> findAllContacts() throws ContactsException {

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
            throw new ContactsException("Unable to get all contacts");
        }
        return result;
    }

    @Override
    public List<Contact> findBySubstring(String subString)
            throws ContactsException
    {

        List<Contact> result = new ArrayList<>();
        try (Connection connection = helper.getConnection()) {
            PreparedStatement ps =
                    connection
                    .prepareStatement("SELECT NAME,PHONE FROM PHONES WHERE NAME LIKE ?");
            ps.setString(1, subString.concat("%"));
            ResultSet set = ps.executeQuery();
            while (set.next()) {
                Contact contact = new Contact();
                contact.setName(set.getString("NAME"));
                contact.setPhone(set.getString("PHONE"));
                result.add(contact);
            }
            connection.commit();
            set.close();
            ps.close();
        } catch (SQLException e) {
            throw new ContactsException("Unable to get filtered contacts");
        }
        return result;
    }

    @Override
    public void updateContact(Contact contact) throws ContactsException {

        try (Connection connection = helper.getConnection()) {
            PreparedStatement ps =
                    connection
                    .prepareStatement("UPDATE PHONES SET NAME=?,PHONE=? WHERE NAME=?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getPhone());
            ps.setString(3, contact.getName());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            throw new ContactsException("Unable to Edit contact");
        }
    }

    @Override
    public void removeContact(Contact contact) throws ContactsException {

        try (Connection connection = helper.getConnection()) {
            PreparedStatement ps =
                    connection
                    .prepareStatement("DELETE FROM PHONES WHERE NAME=? AND PHONE=?");
            ps.setString(1, contact.getName());
            ps.setString(2, contact.getPhone());
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            throw new ContactsException("Unable to delete contact" + contact);
        }
        
    }

    /**
     * Dangerous, only for tests
     *
     * @throws ContactsException
     *             rethrow exception
     */
    @Deprecated
    @Override
    public void removeAll() throws ContactsException {

        try (Connection connection = helper.getConnection()) {
            PreparedStatement ps =
                    connection.prepareStatement("DELETE FROM PHONES");
            ps.executeUpdate();
            connection.commit();
            ps.close();
        } catch (SQLException e) {
            throw new ContactsException("Unable to remove all contacts");
        }
    }

}
