package com.example.gwtmvpdemo.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class PersonDetailsEvent extends GwtEvent<PersonDetailsEventHandler> {

	public static Type<PersonDetailsEventHandler> TYPE = new Type<PersonDetailsEventHandler>();

	@Override
	public Type<PersonDetailsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(PersonDetailsEventHandler handler) {
		handler.onPersonDetails(this);
	}

}
