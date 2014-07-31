
package ru.rs.testcase.phones.client.presenters;

import java.util.List;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.presenter.client.DisplayCallback;
import net.customware.gwt.presenter.client.EventBus;
import net.customware.gwt.presenter.client.place.Place;
import net.customware.gwt.presenter.client.place.PlaceRequest;
import net.customware.gwt.presenter.client.widget.WidgetDisplay;
import net.customware.gwt.presenter.client.widget.WidgetPresenter;
import ru.rs.testcase.phones.client.command.GetContactsAction;
import ru.rs.testcase.phones.client.command.GetContactsResult;
import ru.rs.testcase.phones.model.Contact;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Label;

public class ContactsPresenter extends
WidgetPresenter<ContactsPresenter.Display>
{

    private Display display;

    private DispatchAsync dispatcher;
    
    private final Place PLACE = new Place("contacts");
    
    public ContactsPresenter(DispatchAsync disp, Display display, EventBus bus)
    {

        super(display, bus);
        dispatcher = disp;
        bind();

    }

    public interface Display extends WidgetDisplay {

        HasClickHandlers addButton();
        
        HasClickHandlers filterButton();
        
        List<HasClickHandlers> removeButton();

        FlexTable table();
        
        HasValue<String> searchField();
        
        Label errors();
        
        // Widget asWidget();
    }

    private void setData() {
    
        dispatcher.execute(new GetContactsAction(),
                new DisplayCallback<GetContactsResult>(getDisplay()) {
                    
                    @Override
                    protected void handleFailure(Throwable arg0) {
                    
                        // TODO Auto-generated method stub
                        
                    }
                    
                    @Override
                    protected void handleSuccess(GetContactsResult result) {
                    
                        if (result == null) {
                            getDisplay().errors().setText("Bad Response");
                            return;
                        }
                        String msg = result.getMessage();
                if (msg == null || msg.equals("")) {
                    List<Contact> contacts = result.getContacts();
                    FlexTable table = getDisplay().table();
                    for (int i = 0; i < contacts.size(); i++) {
                        table.setText(i, 0, contacts.get(i).getName());
                        table.setText(i, 1, contacts.get(i).getName());
                        Button removeButton = new Button("Удалить");
                        table.setWidget(i, 2, removeButton);
                        getDisplay().removeButton().add(removeButton);
                    }
                } else {
                    getDisplay().errors().setText(msg);
                }
                    }
                });
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
    public Place getPlace() {

        // TODO Auto-generated method stub
        return PLACE;
    }
    
    @Override
    protected void onBind() {
    
        setData();
        // TODO: добавить обработчик списка кнопок удаления и кнопки добавить а
        // так же редактировать
    }
    
    @Override
    protected void onPlaceRequest(PlaceRequest arg0) {

        // TODO Auto-generated method stub

    }
    
    @Override
    protected void onUnbind() {

        // TODO Auto-generated method stub

    }

}
