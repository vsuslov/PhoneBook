
package ru.rs.testcase.phones.client.presenters;

import java.util.List;
import ru.rs.testcase.phones.client.events.AlertEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ContactsPresenter implements Presenter {
    
    private Display display;
    
    private HandlerManager bus;
    
    public ContactsPresenter(HandlerManager evBus, Display display) {
    
        super();
        this.display = display;
        bus = evBus;
        bind();
    }
    
    public interface Display {
        
        HasClickHandlers addButton();

        HasClickHandlers filterButton();

        List<HasClickHandlers> removeButton();
        
        FlexTable table();

        HasValue<String> searchField();

        Widget asWidget();
    }
    
    private void bind() {
    
        display.addButton().addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
            
                bus.fireEvent(new AlertEvent());
                
            }
        });
    }
    
    @Override
    public void go(HasWidgets container) {
    
        container.clear();
        container.add(display.asWidget());
        
    }
    
}
