package ru.rs.testcase.phones.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class AlertEvent extends GwtEvent<AlertHandler> {
	public static final Type<AlertHandler> TYPE = new Type<AlertHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AlertHandler> getAssociatedType() {
		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(AlertHandler handler) {
		handler.onEvent();

	}

}
