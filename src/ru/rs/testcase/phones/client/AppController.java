
package ru.rs.testcase.phones.client;

import ru.rs.testcase.phones.client.presenters.ContactsPresenter;
import ru.rs.testcase.phones.client.presenters.Presenter;
import ru.rs.testcase.phones.client.views.ContactsView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

    private HandlerManager eventBus;
    
    private HasWidgets container;

    public AppController(HandlerManager eventBus) {
    
        this.eventBus = eventBus;
        bind();
    }

    private void bind() {

        History.addValueChangeHandler(this);
        // TODO закончить бинд в котором разместить регистрацию обработчиков в
        // шине эвентов по типу
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {

        String token = event.getValue();
        if (token != null) {
            Presenter presenter = null;
            if (token.equals("list")) {
                presenter = new ContactsPresenter(eventBus, new ContactsView());
            }
            presenter.go(container);
        }

    }

    @Override
    public void go(HasWidgets container) {

        this.container = container;
        if ("".equals(History.getToken())) {
            History.newItem("list");
        } else {
            History.fireCurrentHistoryState();
        }
        
    }

}
