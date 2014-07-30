
package ru.rs.testcase.phones.server;

import java.util.ArrayList;
import java.util.List;
import ru.rs.testcase.phones.client.services.ContactsService;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.data.ContactsDao;
import ru.rs.testcase.phones.server.data.ContactsDaoImpl;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class ContactsServiceImpl extends RemoteServiceServlet implements
        ContactsService
{
    
    /**
     *
     */
    private static final long serialVersionUID = -7201271346760595296L;
    
    private ContactsDao dao = new ContactsDaoImpl();
    
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Contact> getContacts() {
    
        List<Contact> result = new ArrayList<>();
        try {
            result = dao.findAllContacts();
        } catch (ContactsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void createContact(Contact contact) {
    
        dao.createContact(contact);
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Contact> filterBySubstring(String subString) {

        List<Contact> result = new ArrayList<>();
        try {
            result = dao.findBySubstring(subString);
        } catch (ContactsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateContact(Contact contact) {
    
        try {
            dao.updateContact(contact);
        } catch (ContactsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeContact(Contact contact) {
    
        try {
            dao.removeContact(contact);
        } catch (ContactsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
