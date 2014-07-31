
package ru.rs.testcase.phones;

import org.junit.Test;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.ContactsException;
import ru.rs.testcase.phones.server.data.ContactsDao;
import ru.rs.testcase.phones.server.data.ContactsDaoImpl;

public class DaoTest {
    
    ContactsDao dao = new ContactsDaoImpl();

    private void init() {

        Contact contact1 = new Contact("Boris Grizlov", "34511223334");
        Contact contact2 = new Contact("Alik Bolduen", "12345678901");
        Contact contact3 = new Contact("Petya", "10987654321");
        Contact contact4 = new Contact("Ivan I.V.", "09844422211");

        dao.createContact(contact1);
        dao.createContact(contact2);
        dao.createContact(contact3);
        dao.createContact(contact4);
    }

    @Test
    public void createTest() throws ContactsException {
    
        init();
        System.out.println(dao.findAllContacts());
    }

}
