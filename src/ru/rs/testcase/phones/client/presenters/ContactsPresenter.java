
package ru.rs.testcase.phones.client.presenters;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ru.rs.testcase.phones.client.events.AddContactEvent;
import ru.rs.testcase.phones.model.Contact;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ContactsPresenter implements Presenter {
    
    private List<Contact> contactList;
    
    public interface Display {
        
        HasClickHandlers getAddButton();
        
        HasClickHandlers getContactList();
        
        void setContacts(Map<String, String> contacts);
        
        Widget asWidget();
    }
    
    private final HandlerManager eventBus;
    
    private final Display display;
    
    public ContactsPresenter(HandlerManager eventBus, Display view) {
    
        super();
        this.eventBus = eventBus;
        display = view;
    }
    
    private void bind() {
    
        display.getAddButton().addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
            
                eventBus.fireEvent(new AddContactEvent());
                
            }
            
        });
    }
    
    @Override
    public void go(HasWidgets container) {
    
        bind();
        container.clear();
        container.add(display.asWidget());
        fetchContacts();
    }
    
    private void fetchContacts() {

        contactList =
                Arrays.asList(new Contact("Vasya", "123445"), new Contact(
                        "Petya", "333222555"));
        Map<String, String> data = new LinkedHashMap<>();

        for (Contact c : contactList) {
            data.put(c.getName(), c.getPhone());
        }
        display.setContacts(data);
    }
}
