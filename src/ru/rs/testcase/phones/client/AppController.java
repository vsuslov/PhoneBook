
package ru.rs.testcase.phones.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.PlaceManager;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import ru.rs.testcase.phones.client.presenters.ContactsPresenter;
import ru.rs.testcase.phones.client.presenters.SimplePresenter;
import ru.rs.testcase.phones.client.views.ContactsView;
import ru.rs.testcase.phones.client.views.SimpleView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements ValueChangeHandler<String> {

    private HasWidgets container;

    private EventBus eventBus;

    private final DispatchAsync dispatcher;

    private PlaceManager placer;

    // private ContactsServiceAsync rpc;

    public AppController(DispatchAsync disp, EventBus eventBus) {

        dispatcher = disp;
        this.eventBus = eventBus;
        placer = new PlaceManager(this.eventBus);
        // this.rpc = rpc;
        bind();
    }
    
    private void bind() {

        History.addValueChangeHandler(this);
    }

    public void go(HasWidgets container) {

        this.container = container;

        if ("".equals(History.getToken())) {
            History.newItem("simple");
        } else {
            History.fireCurrentHistoryState();
        }
        
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
    
        String token = event.getValue();
        
        if (token != null) {
            WidgetPresenter<? extends WidgetDisplay> presenter = null;

            if (token.equals("simple")) {
                presenter =
                        new SimplePresenter(dispatcher, new SimpleView(),
                                eventBus);
            } else if (token.equals("contacts")) {
                presenter =
                        new ContactsPresenter(dispatcher, new ContactsView(),
                                eventBus);
            }

            if (presenter != null) {
                container.clear();
                container.add(presenter.getDisplay().asWidget());
            }
        }
    }
}
