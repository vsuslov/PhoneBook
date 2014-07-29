
package ru.rs.testcase.phones.server;

import java.util.List;
import ru.rs.testcase.phones.client.services.ContactsService;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.data.ContactsDao;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ContactsServiceImpl extends RemoteServiceServlet implements
ContactsService
{
    
    private ContactsDao dao = new ContactsDaoImpl();
    
    @Override
    public List<Contact> getContacts() {

        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void createContact(Contact contact) {

        // TODO Auto-generated method stub

    }
    
    @Override
    public List<Contact> filterBySubstring(String subString) {

        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public void updateContact(Contact contact) {

        // TODO Auto-generated method stub

    }
    
    @Override
    public void removeContact(Contact contact) {

        // TODO Auto-generated method stub

    }

}
