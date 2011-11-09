package com.the9.xuhong.db;

import android.test.AndroidTestCase;

public class DBTest extends AndroidTestCase {

	public void testCreadDB() throws Throwable {
		DatabaseHelper databaseHelper = new DatabaseHelper(this.getContext());
		databaseHelper.getWritableDatabase();
	}
}
