package com.example.gwtmvpdemo.client.view;

import com.example.gwtmvpdemo.client.presenter.AddPersonPresenter.Display;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class AddPersonView extends Composite implements Display {
	
	private final Button showPersonsButton;
	
	public AddPersonView() {

		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		showPersonsButton = new Button("Show persons");
		mainPanel.add(showPersonsButton);
	}

	@Override
	public HasClickHandlers getShowPersonsButton() {
		return showPersonsButton;
	}
	
	@Override
	public Widget asWidget(){
		return this;
	}
}
