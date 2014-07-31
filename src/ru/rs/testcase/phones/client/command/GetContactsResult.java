
package ru.rs.testcase.phones.client.command;

import java.util.ArrayList;
import java.util.List;
import net.customware.gwt.dispatch.shared.Result;
import ru.rs.testcase.phones.model.Contact;

public class GetContactsResult implements Result {
    
    private List<Contact> contacts;
    
    private String message;

    public GetContactsResult(List<Contact> contacts, String message) {

        super();
        this.contacts =
                (contacts != null) ? new ArrayList<>(contacts)
                        : new ArrayList<Contact>();
        this.message = message;
    }
    
    public GetContactsResult() {
    
    }

    public List<Contact> getContacts() {
    
        return contacts;
    }
    
    public String getMessage() {
    
        return message;
    }

}
