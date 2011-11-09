package com.the9.xuhong.db;

import java.util.List;

import com.the9.xuhong.domain.Person;
import com.the9.xuhong.service.PersonService;

import android.test.AndroidTestCase;
import android.util.Log;

public class PersonServiceTest extends AndroidTestCase {
	
	public void testSave() throws Throwable {
		PersonService personService = new PersonService(this.getContext());
		//Person person = new Person("Tom", 31);
		//personService.save(person);
		
		for (int i=0; i< 10; i++) {
			Person person1 = new Person("Tom" + i, 21);
			personService.save(person1);
		}
	}
	
	private static final String TAG = "PersonServiceTest";
	public void testFind() throws Throwable {
		PersonService personService = new PersonService(this.getContext());
		Person person =  personService.find(1);
		Log.i(TAG, person.toString());
	}
	
	public void testUpdate() throws Throwable {
		PersonService personService = new PersonService(this.getContext());
		Person person = personService.find(1);
		person.setName("Jim");
		personService.update(person);
	}

	public void testGetScrollData() throws Throwable {
		PersonService personService = new PersonService(this.getContext());
		List<Person> persons = personService.getScrollData(0, 3);
		for(Person person : persons) {
			Log.i(TAG, person.toString());
		}
	}
	
	public void testDelete() throws Throwable {
		PersonService personService = new PersonService(this.getContext());
		personService.delete(1);
	}
}
