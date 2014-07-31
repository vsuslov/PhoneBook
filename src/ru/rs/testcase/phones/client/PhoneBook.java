package ru.rs.testcase.phones.client;

import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.DefaultEventBus;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.RootPanel;

public class PhoneBook implements EntryPoint {

	@Override
	public void onModuleLoad() {
		EventBus eventBus = new DefaultEventBus();
		PlaceController placeController = new PlaceController(eventBus);
		// ContactsServiceAsync service = GWT.create(ContactsService.class);
		final DispatchAsync dispatcher = new StandardDispatchAsync(
				new net.customware.gwt.dispatch.client.DefaultExceptionHandler());

		AppController controller = new AppController(dispatcher);

		controller.go(RootPanel.get());
	}
}
