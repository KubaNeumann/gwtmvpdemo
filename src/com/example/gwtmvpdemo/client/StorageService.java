package com.example.gwtmvpdemo.client;

import java.util.ArrayList;
import java.util.List;

import com.example.gwtmvpdemo.shared.model.Person;

public class StorageService {
  private List<Person> db = new ArrayList<Person>();
  
  public void addPerson(Person person){
	  Person p = new Person();
	  p.setId(person.getId());
	  p.setNick(person.getNick());
	  p.setFirstName(person.getFirstName());
	  p.setLastName(person.getLastName());
	  p.setEmail(person.getEmail());
	  db.add(p);
  }
  
  public List<Person> getAllPersons(){
	  return db;
  }
}
