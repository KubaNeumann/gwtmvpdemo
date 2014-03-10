package com.example.gwtmvpdemo.client.presenter;

import java.util.List;

import com.example.gwtmvpdemo.client.StorageService;
import com.example.gwtmvpdemo.client.event.AddPersonEvent;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class PersonsPresenter implements Presenter {

	final HandlerManager eventBus;
	final StorageService storage;
	private final Display display;

	public interface Display {
		HasClickHandlers getAddButton();
		HasClickHandlers getSayHelloButton();
		HasText getHelloLabel();
		void setData(List<String> data);
		Widget asWidget();
	}

	public PersonsPresenter(StorageService storage, HandlerManager eventBus,
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
		display.getAddButton().addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				eventBus.fireEvent(new AddPersonEvent());
			}
		});
		
		display.getSayHelloButton().addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				display.getHelloLabel().setText(" Hello World ");
				
			}
		});
		
	}
}
