package com.example.gwtmvpdemo.client;

import com.example.gwtmvpdemo.client.event.AddPersonEvent;
import com.example.gwtmvpdemo.client.event.AddPersonEventHandler;
import com.example.gwtmvpdemo.client.event.PersonDetailsEvent;
import com.example.gwtmvpdemo.client.event.PersonDetailsEventHandler;
import com.example.gwtmvpdemo.client.event.ShowPersonsEvent;
import com.example.gwtmvpdemo.client.event.ShowPersonsEventHandler;
import com.example.gwtmvpdemo.client.presenter.AddPersonPresenter;
import com.example.gwtmvpdemo.client.presenter.PersonDetailsPresenter;
import com.example.gwtmvpdemo.client.presenter.PersonsPresenter;
import com.example.gwtmvpdemo.client.presenter.Presenter;
import com.example.gwtmvpdemo.client.view.AddPersonView;
import com.example.gwtmvpdemo.client.view.PersonDetailsView;
import com.example.gwtmvpdemo.client.view.PersonsView;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppControler implements Presenter, ValueChangeHandler<String> {

	private final HandlerManager eventBus;
	private final StorageService storage;
	private HasWidgets container;

	private final static String SHOW_PERSONS = "showPersons";
	private final static String ADD_PERSON = "addPerson";
	private final static String PERSON_DETAILS = "personDetails";

	public AppControler(StorageService storage, HandlerManager eventBus) {
		this.eventBus = eventBus;
		this.storage = storage;
		bind();
	}

	@Override
	public void go(HasWidgets container) {
		this.container = container;

		if ("".equals(History.getToken())) {
			History.newItem(ADD_PERSON);
		} else {
			History.fireCurrentHistoryState();
		}
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {

		String token = event.getValue();

		if (token != null) {
			Presenter presenter = null;

			if (token.equals(SHOW_PERSONS)) {
				presenter = new PersonsPresenter(storage, eventBus,
						new PersonsView());
			} else if (token.equals(ADD_PERSON)) {
				presenter = new AddPersonPresenter(storage, eventBus,
						new AddPersonView());
			} else if (token.equals(PERSON_DETAILS)) {
				presenter = new PersonDetailsPresenter(storage, eventBus,
						new PersonDetailsView());
			}

			if (presenter != null) {
				presenter.go(container);
			}
		}
	}

	private void bind() {
		History.addValueChangeHandler(this);

		eventBus.addHandler(AddPersonEvent.TYPE, new AddPersonEventHandler() {
			@Override
			public void onAddPerson(AddPersonEvent event) {
				doAddPerson();
			}
		});

		eventBus.addHandler(PersonDetailsEvent.TYPE,
				new PersonDetailsEventHandler() {

					@Override
					public void onPersonDetails(PersonDetailsEvent event) {
						doPersonDetails();

					}
				});

		eventBus.addHandler(ShowPersonsEvent.TYPE,
				new ShowPersonsEventHandler() {
					@Override
					public void onShowPersons(ShowPersonsEvent event) {
						doShowPersons();
					}
				});
	}

	private void doAddPerson() {
		History.newItem(ADD_PERSON);
	}

	private void doShowPersons() {
		History.newItem(SHOW_PERSONS);
	}

	private void doPersonDetails() {
		History.newItem(PERSON_DETAILS);
	}

}
