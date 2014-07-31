
package ru.rs.testcase.phones.client.presenters;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Label;

public class SimplePresenter extends WidgetPresenter<SimplePresenter.Display> {
    
    private Display display;
    
    private DispatchAsync dispatcher;
    
    public interface Display extends WidgetDisplay {
        
        HasClickHandlers goButton();
        
        Label text();
        
    }
    
    public static final Place PLACE = new Place("Simple");
    
    public SimplePresenter(Display display, EventBus eventBus) {
    
        super(display, eventBus);
        // TODO Auto-generated constructor stub
    }
    
    public SimplePresenter(DispatchAsync dispatcher, Display display,
            EventBus eventBus)
    {
    
        super(display, eventBus);
        this.dispatcher = dispatcher;
        
        bind();
    }
    
    public void doGO() {
    
        History.newItem("contacts");
        // dispatcher.execute(new SimpleAction("QQ"),
        // new DisplayCallback<SimpleResult>(getDisplay()) {
        //
        // @Override
        // protected void handleFailure(Throwable e) {
        //
        // getDisplay().text().setText(e.getMessage());
        // }
        //
        // @Override
        // protected void handleSuccess(SimpleResult value) {
        //
        // getDisplay().text().setText(value.getMessage());
        // eventBus.fireEvent(new AlertEvent());
        //
        // }
        // });
    }
    
    @Override
    public void refreshDisplay() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public void revealDisplay() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    protected void onBind() {
    
        getDisplay().goButton().addClickHandler(new ClickHandler() {
            
            @Override
            public void onClick(ClickEvent event) {
            
                doGO();
            }
            
        });
    }
    
    @Override
    protected void onUnbind() {
    
        // TODO Auto-generated method stub
        
    }
    
    @Override
    public Place getPlace() {
    
        // TODO Auto-generated method stub
        return PLACE;
    }
    
    @Override
    protected void onPlaceRequest(PlaceRequest request) {
    
        String param = request.getParameter("name", null);
        if (param != null) {
            display.text().setText(param);
        }
    }
    
}
