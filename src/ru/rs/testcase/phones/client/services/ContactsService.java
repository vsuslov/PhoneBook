
package ru.rs.testcase.phones.client.services;

import java.util.List;
import ru.rs.testcase.phones.model.Contact;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * interface for RPC Contacts Service
 *
 * @author vsuslov
 */
@RemoteServiceRelativePath("contactsService")
public interface ContactsService extends RemoteService {

    /**
     * Method for getting contact list
     *
     * @return contact list
     */
    public List<Contact> getContacts();
    
    /**
     * Creates a contact
     *
     * @param contact
     *            contact is being saved
     */
    public void createContact(Contact contact);
    
    /**
     * Filters contact list by string
     *
     * @param subString
     *            key string
     * @return contact list
     */
    public List<Contact> filterBySubstring(String subString);

    /**
     * Updates contact in the storage
     *
     * @param contact
     *            contact to update
     */
    public void updateContact(Contact contact);
    
    /**
     * Removes Contact from storage
     *
     * @param contact
     *            contact for remove
     */
    public void removeContact(Contact contact);
    
}
