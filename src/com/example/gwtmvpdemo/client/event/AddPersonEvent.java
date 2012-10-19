package com.example.gwtmvpdemo.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class AddPersonEvent extends GwtEvent<AddPersonEventHandler> {

	public static Type<AddPersonEventHandler> TYPE = new Type<AddPersonEventHandler>();

	@Override
	public Type<AddPersonEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(AddPersonEventHandler handler) {
		handler.onAddPerson(this);
	}

}
