package com.the9.xuhong.service;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.the9.xuhong.db.DatabaseHelper;
import com.the9.xuhong.domain.Person;

public class OtherPersonService {
	
	private DatabaseHelper databaseHelper;
	public OtherPersonService(Context context) {
		databaseHelper = new DatabaseHelper(context);
	}
	
	public void save(Person person) {
		SQLiteDatabase database = databaseHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("name", person.getName());
		cv.put("age", person.getAge());
		database.insert("person", "name", cv);
	}
	
	public void update(Person person) {
		SQLiteDatabase database = databaseHelper.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put("name", person.getName());
		cv.put("age", person.getAge());
		database.update("person", cv, "personid=?", new String[]{String.valueOf(person.getId())});
	}
	
	public Person find(Integer id) {
		SQLiteDatabase database = databaseHelper.getWritableDatabase();
		Cursor cursor = database.query("person", new String[]{"personid", "name", "age"}, "personid=?", new String[]{
				String.valueOf(id)}, null, null, null);
		if(cursor.moveToNext()) {
			Person person = new Person();
			person.setID(cursor.getInt(0));
			person.setName(cursor.getString(1));
			person.setAge(cursor.getInt(2));
			return person;
		}
		return null;
	}

}
