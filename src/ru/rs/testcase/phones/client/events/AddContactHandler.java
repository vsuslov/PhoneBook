
package ru.rs.testcase.phones.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface AddContactHandler extends EventHandler {
    
    public void onAddContact(AddContactEvent event);
    
}
