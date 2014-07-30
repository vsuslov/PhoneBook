
package ru.rs.testcase.phones.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import ru.rs.testcase.phones.client.events.AlertEvent;
import ru.rs.testcase.phones.client.events.AlertHandler;
import ru.rs.testcase.phones.client.presenters.ContactsPresenter;
import ru.rs.testcase.phones.client.presenters.Presenter;
import ru.rs.testcase.phones.client.services.ContactsServiceAsync;
import ru.rs.testcase.phones.client.views.ContactsView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

    private HasWidgets container;

    private HandlerManager eventBus;

    private final DispatchAsync dispatcher = new StandardDispatchAsync(
            new DefaultExceptionHandler());
    
    private ContactsServiceAsync rpc;
    
    public AppController(HandlerManager eventBus, ContactsServiceAsync rpc) {
    
        super();
        this.eventBus = eventBus;
        this.rpc = rpc;
        bind();
    }
    
    private void bind() {
    
        History.addValueChangeHandler(this);
        eventBus.addHandler(AlertEvent.TYPE, new AlertHandler() {
            
            @Override
            public void onEvent() {
            
                System.out.println("TROLOLO!");
                // rpc.doDoDo(new AsyncCallback<String>() {
                //
                // @Override
                // public void onSuccess(String result) {
                // System.out.println("Result from server:" + result);
                //
                // }
                //
                // @Override
                // public void onFailure(Throwable caught) {
                // System.err.println("Error on getting response");
                //
                // }
                // });
            }
        });
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {

        String v = event.getValue();
        if (v != null) {
            Presenter p = null;
            if (v.equals("contacts")) {
                p = new ContactsPresenter(eventBus, new ContactsView());
            }
            // if (v.equals("simple")) {
            // p = new SimplePresenter(dispatcher, new SimpleView());
            // }
            if (p != null) {
                p.go(container);
            }
        }

    }

    @Override
    public void go(HasWidgets container) {
    
        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("simple");
        } else {
            History.fireCurrentHistoryState();
        }

    }
}
