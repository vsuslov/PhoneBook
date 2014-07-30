package ru.rs.testcase.phones.server;

import java.util.List;

import ru.rs.testcase.phones.client.services.ContactsService;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.data.ContactsDao;
import ru.rs.testcase.phones.server.data.ContactsDaoImpl;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ContactsServiceImpl extends RemoteServiceServlet implements
		ContactsService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7201271346760595296L;
	private ContactsDao dao = new ContactsDaoImpl();

	@Override
	public List<Contact> getContacts() {

		return dao.findAllContacts();
	}

	@Override
	public void createContact(Contact contact) {

		dao.createContact(contact);

	}

	@Override
	public List<Contact> filterBySubstring(String subString) {

		return dao.findBySubstring(subString);
	}

	@Override
	public void updateContact(Contact contact) {

		dao.updateContact(contact);

	}

	@Override
	public void removeContact(Contact contact) {

		dao.removeContact(contact);
	}

}
