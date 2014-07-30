
package ru.rs.testcase.phones.client;

import ru.rs.testcase.phones.client.services.ContactsService;
import ru.rs.testcase.phones.client.services.ContactsServiceAsync;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootPanel;

public class PhoneBook implements EntryPoint {
    
    @Override
    public void onModuleLoad() {

        ContactsServiceAsync service = GWT.create(ContactsService.class);
        // final DispatchAsync dispatcher =
        // new StandardDispatchAsync(
        // new net.customware.gwt.dispatch.client.DefaultExceptionHandler());
        HandlerManager bus = new HandlerManager(null);
        AppController controller = new AppController(bus, service);

        controller.go(RootPanel.get());
    }

}
