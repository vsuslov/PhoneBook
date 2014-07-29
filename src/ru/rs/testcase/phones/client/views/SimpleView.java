package ru.rs.testcase.phones.client.views;

import ru.rs.testcase.phones.client.presenters.ContactsPresenter.Display;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class SimpleView extends Composite implements Display {
	private Button simpleButton;
	private VerticalPanel p;

	public SimpleView() {
		p = new VerticalPanel();
		initWidget(p);
		simpleButton = new Button("trololo");
		p.add(new Label("Click ME!"));
		p.add(simpleButton);

	}

	@Override
	public HasClickHandlers getButton() {

		return simpleButton;
	}

	@Override
	public Widget asWidget() {
		// TODO Auto-generated method stub
		return this;
	}

}
