
package ru.rs.testcase.phones.server.data;

import java.util.List;
import ru.rs.testcase.phones.model.Contact;

public interface ContactsDao {

    public Contact createContact(Contact contact);
    
    public List<Contact> findAllContacts();

    public List<Contact> findBySubstring(String subString);

    public Contact updateContact(Contact contact);
    
    public void removeContact(Contact contact);
}
