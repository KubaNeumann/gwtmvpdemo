package com.example.gwtmvpdemo.client.event;

import com.google.gwt.event.shared.GwtEvent;

public class ShowPersonsEvent extends GwtEvent<ShowPersonsEventHandler> {

	public static Type<ShowPersonsEventHandler> TYPE = new Type<ShowPersonsEventHandler>();

	@Override
	public Type<ShowPersonsEventHandler> getAssociatedType() {
		return TYPE;
	}

	@Override
	protected void dispatch(ShowPersonsEventHandler handler) {
		handler.onShowPersons(this);
	}

}
