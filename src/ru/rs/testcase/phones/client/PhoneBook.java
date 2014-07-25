package ru.rs.testcase.phones.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class PhoneBook implements EntryPoint {
	private FlexTable phoneBook;
	private Button addRecord;
	private VerticalPanel mainPanel;

	{
		phoneBook = new FlexTable();
		addRecord = new Button("Добавить запись");
		mainPanel = new VerticalPanel();

		phoneBook.setText(0, 0, "Имя");
		phoneBook.setText(0, 1, "Телефон");
		phoneBook.setText(0, 2, "Действия");
		phoneBook.setBorderWidth(2);
	}

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {

		mainPanel.add(phoneBook);
		mainPanel.add(addRecord);

		RootPanel.get("phoneList").add(mainPanel);
	}
}
