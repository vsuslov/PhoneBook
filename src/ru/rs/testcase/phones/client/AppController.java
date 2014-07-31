package ru.rs.testcase.phones.client;

import net.customware.gwt.dispatch.client.DefaultExceptionHandler;
import net.customware.gwt.dispatch.client.DispatchAsync;
import net.customware.gwt.dispatch.client.standard.StandardDispatchAsync;
import net.customware.gwt.presenter.client.EventBus;

import com.google.gwt.user.client.ui.HasWidgets;

public class AppController {

	private HasWidgets container;

	private EventBus eventBus;

	private final DispatchAsync dispatcher = new StandardDispatchAsync(
			new DefaultExceptionHandler());

	// private ContactsServiceAsync rpc;

	public AppController(DispatchAsync disp) {
		this.dispatcher = disp;
		// this.eventBus = eventBus;
		// this.rpc = rpc;
		// bind();
	}

	private void show(HasWidgets container) {
		this.container = container;

	}

}
