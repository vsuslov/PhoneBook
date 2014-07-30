package ru.rs.testcase.phones;

import java.util.List;

import org.junit.Test;

import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.data.ContactsDao;
import ru.rs.testcase.phones.server.data.ContactsDaoImpl;

public class DaoTest {
	ContactsDao dao = new ContactsDaoImpl();

	@Test
	public void test() {
		List<Contact> contacts = dao.findAllContacts();

		System.out.println(contacts);

		Contact c = new Contact("Alek Bolduen", "4567733");
		dao.createContact(c);

		System.out.println(dao.findAllContacts());

	}
}
