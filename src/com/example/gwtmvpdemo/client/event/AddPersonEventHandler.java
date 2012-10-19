package com.example.gwtmvpdemo.client.event;

import com.google.gwt.event.shared.EventHandler;

public interface AddPersonEventHandler extends EventHandler {
	void onAddPerson(AddPersonEvent event);
}
