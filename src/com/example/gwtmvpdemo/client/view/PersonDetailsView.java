package com.example.gwtmvpdemo.client.view;

import com.example.gwtmvpdemo.client.presenter.PersonDetailsPresenter.Display;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PersonDetailsView extends Composite implements Display {
	
	private final Button personDetailsButton;
	
	public PersonDetailsView() {

		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		personDetailsButton = new Button("Person details");
		mainPanel.add(personDetailsButton);
	}

	@Override
	public HasClickHandlers getPersonDetailsButton() {
		return personDetailsButton;
	}
	
	@Override
	public Widget asWidget(){
		return this;
	}
}
