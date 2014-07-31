
package ru.rs.testcase.phones.client.views;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import ru.rs.testcase.phones.client.presenters.ContactsPresenter.Display;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContactsView extends Composite implements Display {

    private FlexTable contacts;

    private Button addButton;

    private Button filterButton;
    
    private TextBox searchField;

    private VerticalPanel mainPanel;

    private HorizontalPanel searchPanel;

    private List<HasClickHandlers> removeButtons;
    
    private Label errors;

    public ContactsView() {

        mainPanel = new VerticalPanel();
        initWidget(mainPanel);

        contacts = new FlexTable();
        contacts.setText(0, 0, "Имя");
        contacts.setText(0, 1, "Телефон");
        contacts.setText(0, 2, "Действия");
        contacts.setBorderWidth(2);
        contacts.setCellPadding(5);
        
        filterButton = new Button("Отфильтровать");
        searchField = new TextBox();
        addButton = new Button("Добавить контакт");
        
        searchPanel = new HorizontalPanel();
        searchPanel.add(searchField);
        searchPanel.add(filterButton);

        errors = new Label();
        
        mainPanel.add(searchPanel);
        mainPanel.add(contacts);
        mainPanel.add(addButton);
        mainPanel.add(errors);

    }

    public HasClickHandlers getAddButton() {

        // TODO Auto-generated method stub
        return addButton;
    }

    public HasClickHandlers getContactList() {

        // TODO Auto-generated method stub
        return contacts;
    }

    public void setContacts(Map<String, String> contacts) {

        this.contacts.removeAllRows();
        int i = 0;
        for (Entry<String, String> e : contacts.entrySet()) {
            this.contacts.setText(++i, 0, e.getKey());
            this.contacts.setText(i, 1, e.getValue());
        }
    }

    @Override
    public HasClickHandlers addButton() {

        // TODO Auto-generated method stub
        return addButton;
    }

    @Override
    public HasClickHandlers filterButton() {

        // TODO Auto-generated method stub
        return filterButton;
    }

    @Override
    public List<HasClickHandlers> removeButton() {

        // TODO Auto-generated method stub
        return removeButtons;
    }

    @Override
    public FlexTable table() {

        // TODO Auto-generated method stub
        return contacts;
    }

    @Override
    public HasValue<String> searchField() {

        // TODO Auto-generated method stub
        return searchField;
    }

    @Override
    public void startProcessing() {
    
        errors.setText("");
    }

    @Override
    public void stopProcessing() {
    
        // TODO Auto-generated method stub
        
    }

    @Override
    public Label errors() {
    
        // TODO Auto-generated method stub
        return errors;
    }
}
