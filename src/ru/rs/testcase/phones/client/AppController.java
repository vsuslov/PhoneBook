package ru.rs.testcase.phones.client;

import ru.rs.testcase.phones.client.presenters.Presenter;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppController implements Presenter, ValueChangeHandler<String> {

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		System.out.println("Stub for calue change");

	}

	@Override
	public void go(HasWidgets container) {
		// TODO Auto-generated method stub

	}

}
