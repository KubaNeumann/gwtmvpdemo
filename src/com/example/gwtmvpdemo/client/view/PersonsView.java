package com.example.gwtmvpdemo.client.view;

import java.util.List;

import com.example.gwtmvpdemo.client.presenter.PersonsPresenter.Display;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class PersonsView extends Composite implements Display {
	
	private final Button addPersonButton = new Button("Add person");
	private final Button sayHelloButton = new Button("Say Hello");
	private final Label  messageLabel = new Label(" waiting to say Hello");
	
	public PersonsView() {

		VerticalPanel mainPanel = new VerticalPanel();
		initWidget(mainPanel);
		
		HorizontalPanel hp = new HorizontalPanel();
		hp.add(sayHelloButton);
		hp.add(messageLabel);
		mainPanel.add(hp);
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

	@Override
	public HasClickHandlers getSayHelloButton() {
		return sayHelloButton;
	}

	@Override
	public HasText getHelloLabel() {
		
		return messageLabel;
	}

}
