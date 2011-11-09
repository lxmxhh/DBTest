package com.the9.xuhong.service;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.the9.xuhong.db.DatabaseHelper;
import com.the9.xuhong.domain.Person;

public class PersonService {
	
	private DatabaseHelper databaseHelper;
	public PersonService(Context context) {
		databaseHelper = new DatabaseHelper(context);
	}
	
	public void save(Person person) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		db.execSQL("insert into person(name, age) values (?,?)",
				new Object[]{person.getName(), person.getAge()});
	}
	
	public void update(Person person) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		db.execSQL("update person set name=?,age=? where personid=?",
				new Object[]{person.getName(), person.getAge(), person.getId()});
	}
	
	public Person find(Integer id) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select personid, name, age from person where personid=?", 
				new String[]{String.valueOf(id)});
		if(cursor.moveToNext()) {
			Person person = new Person();
			
			person.setID(cursor.getInt(cursor.getColumnIndex("personid")));
			person.setName(cursor.getString(1));
			person.setAge(cursor.getInt(2));
			return person;
		}
		cursor.close();
		return null;
	}

	public void delete(Integer id) {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		db.execSQL("delete from person where personid=?",
				new Object[]{id});
	}
	
	public List<Person> getScrollData(int firstResult, int maxResult) {
		List<Person> persons = new ArrayList<Person>();
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select personid, name, age from person limit ?,?",
				new String[]{String.valueOf(firstResult), String.valueOf(maxResult)});
		
		while(cursor.moveToNext()) {
			Person person = new Person();
			person.setID(cursor.getInt(cursor.getColumnIndex("personid")));
			person.setName(cursor.getString(1));
			person.setAge(cursor.getInt(2));
			persons.add(person);
		}
		cursor.close();
		return persons;
	}
	
	public long getCount() {
		SQLiteDatabase db = databaseHelper.getWritableDatabase();
		Cursor cursor = db.rawQuery("select count(*) from person", null);
		cursor.moveToFirst();
		long count = cursor.getLong(0);
		cursor.close();
		return count;
	}
}
