
package ru.rs.testcase.phones.client.services;

import java.util.List;
import ru.rs.testcase.phones.model.Contact;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * Asyncronous service for ajax requests
 * 
 * @author vsuslov
 */
public interface ContactsServiceAsync {

    public void getContacts(AsyncCallback<List<Contact>> callback);
    
    public void createContact(Contact contact, AsyncCallback<Void> callback);
    
    public void filterBySubstring(String subString,
            AsyncCallback<List<Contact>> callback);

    public void updateContact(Contact contact, AsyncCallback<Void> callback);
    
    public void removeContact(Contact contact, AsyncCallback<Void> callback);
    
}
