package ru.rs.testcase.phones.client.views;

import java.util.Map;
import java.util.Map.Entry;

import ru.rs.testcase.phones.client.presenters.ContactsPresenter.Display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class ContactsView extends Composite implements Display {

	private FlexTable contacts;

	private Button addButton;

	private VerticalPanel mainPanel;

	private HorizontalPanel menuPanel;

	public ContactsView() {

		contacts = new FlexTable();
		contacts.setText(0, 0, "Имя");
		contacts.setText(0, 1, "Телефон");
		contacts.setText(0, 2, "Действия");
		contacts.setBorderWidth(2);
		contacts.setCellPadding(5);

		addButton = new Button("Добавить контакт");
		menuPanel = new HorizontalPanel();
		menuPanel.add(addButton);

		mainPanel = new VerticalPanel();
		mainPanel.add(menuPanel);
		mainPanel.add(contacts);

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
	public HasClickHandlers getButton() {
		// TODO Auto-generated method stub
		return null;
	}
}
