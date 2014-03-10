package com.example.gwtmvpdemo.client.presenter;

import com.example.gwtmvpdemo.client.StorageService;
import com.example.gwtmvpdemo.client.event.PersonDetailsEvent;
import com.example.gwtmvpdemo.client.event.ShowPersonsEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class AddPersonPresenter implements Presenter {

	final HandlerManager eventBus;
	final StorageService storage;
	private final Display display;

	public interface Display {
		HasClickHandlers getShowPersonsButton();

		Widget asWidget();
	}

	public AddPersonPresenter(StorageService storage, HandlerManager eventBus,
			Display view) {
		this.eventBus = eventBus;
		this.storage = storage;
		this.display = view;
		bind();
	}

	@Override
	public void go(HasWidgets container) {
		bind();
		container.clear();
		container.add(display.asWidget());
	}

	private void bind() {
		display.getShowPersonsButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new PersonDetailsEvent());
			}
		});
	}
}
