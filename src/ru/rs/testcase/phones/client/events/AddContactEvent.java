package ru.rs.testcase.phones.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class AddContactEvent extends GwtEvent<AddContactHandler> {

	public static Type<AddContactHandler> TYPE = new Type<AddContactHandler>();

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<AddContactHandler> getAssociatedType() {

		// TODO Auto-generated method stub
		return TYPE;
	}

	@Override
	protected void dispatch(AddContactHandler handler) {

		handler.onAddContact(this);
	}

}
