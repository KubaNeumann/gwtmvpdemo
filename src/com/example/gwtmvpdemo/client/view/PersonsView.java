package com.example.gwtmvpdemo.client.view;

import java.util.List;

import com.example.gwtmvpdemo.client.presenter.PersonsPresenter.Display;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PersonsView extends Composite implements Display {
	
	private final Button addPersonButton = new Button("Add person");
	
	public PersonsView() {

		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		mainPanel.add(addPersonButton);
		
	}

	@Override
	public HasClickHandlers getAddButton() {
		return addPersonButton;
	}

	@Override
	public void setData(List<String> data) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public Widget asWidget(){
		return this;
	}

}
