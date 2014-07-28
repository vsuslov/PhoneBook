package ru.rs.testcase.phones.client.presenters;

import java.util.List;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class ContactsPresenter implements Presenter {
	public interface Display {
		HasClickHandlers addButton();

		HasClickHandlers getContactList();

		void setContacts(List<String> contacts);

		Widget asWidget();
	}

	private HandlerManager eventBus;
	private Display display;

	public ContactsPresenter(HandlerManager eventBus, Display display) {
		super();
		this.eventBus = eventBus;
		this.display = display;
	}

	private void bind() {

	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());

	}

}
