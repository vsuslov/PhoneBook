
package ru.rs.testcase.phones.server.data;

import java.util.List;
import ru.rs.testcase.phones.model.Contact;
import ru.rs.testcase.phones.server.ContactsException;

public interface ContactsDao {

    public Contact createContact(Contact contact);
    
    public List<Contact> findAllContacts() throws ContactsException;

    public List<Contact> findBySubstring(String subString)
            throws ContactsException;

    public void updateContact(Contact contact) throws ContactsException;
    
    public void removeContact(Contact contact) throws ContactsException;
    
    public void removeAll() throws ContactsException;
}
