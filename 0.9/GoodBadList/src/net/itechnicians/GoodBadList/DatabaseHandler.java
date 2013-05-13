package net.itechnicians.GoodBadList;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "goodbadlist";

	// Deeds table name
	private static final String TABLE_DEEDS = "deeds";

	// Persons table name
	private static final String TABLE_PERSONS = "persons";

	// Deeds Table Columns names
	private static final String DEED_ID = "deed_id";
	private static final String DEED_DESC = "deed_desc";
	private static final String DEED_TYPE = "deed_type";
	private static final String DEED_PERSON_NAME = "person_name";
	// Persons Table Columns

	//private static final String PERSON_ID = "person_id";
	private static final String PERSON_NAME = "person_name";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_DEEDS_TABLE = "CREATE TABLE " + TABLE_DEEDS + "("
				+ DEED_ID + " INTEGER PRIMARY KEY," + DEED_DESC + " TEXT,"
				+ DEED_PERSON_NAME + " TEXT NOT NULL CONSTRAINT [fk_persons] REFERENCES [persons]([person_name]),"
				+ DEED_TYPE + " TEXT" + ")";
		//

		String CREATE_PERSONS_TABLE = "CREATE TABLE " + TABLE_PERSONS + "("
				 + PERSON_NAME + " TEXT)";
		db.execSQL(CREATE_PERSONS_TABLE);
		db.execSQL(CREATE_DEEDS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_DEEDS);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	// Adding new deed
	void addDeed(Deed deed) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues deedValues = new ContentValues();

		deedValues.put(DEED_DESC, deed.getDesc()); // Deed Name
		deedValues.put(DEED_TYPE, deed.getType()); // Deed type
		deedValues.put(DEED_PERSON_NAME, deed.get_person_name()); // Deed person

		// Inserting Row
		db.insert(TABLE_DEEDS, null, deedValues);

		db.close(); // Closing database connection
	}

	// Getting single deed
	Deed getDeed(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_DEEDS, new String[] { DEED_ID,
				DEED_DESC, DEED_TYPE }, DEED_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Deed deed = new Deed(Integer.parseInt(cursor.getString(0)),
				cursor.getString(1), cursor.getString(2));
		// return deed
		return deed;
	}

	// Getting All Deeds
	public List<Deed> getAllDeeds() {
		List<Deed> deedList = new ArrayList<Deed>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_DEEDS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Deed deed = new Deed();
				deed.setID(Integer.parseInt(cursor.getString(0)));
				deed.setDesc(cursor.getString(1));
				deed.setType(cursor.getString(2));
				// Adding deed to list
				deedList.add(deed);
			} while (cursor.moveToNext());
		}

		// return deed list
		return deedList;
	}

	// Updating single deed
	public int updateDeed(Deed deed) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(DEED_DESC, deed.getDesc());
		values.put(DEED_TYPE, deed.getType());

		// updating row
		return db.update(TABLE_DEEDS, values, DEED_ID + " = ?",
				new String[] { String.valueOf(deed.getID()) });
	}

	// Deleting single deed
	public void deleteDeed(Deed deed) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_DEEDS, DEED_ID + " = ?",
				new String[] { String.valueOf(deed.getID()) });
		db.close();
	}

	// Getting deeds Count
	public int getDeedsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_DEEDS;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}

	// persons CRUD

	// Adding new deed
	void addPerson(Person person) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(PERSON_NAME, person.get_person_name()); // Person Name

		// Inserting Row
		db.insert(TABLE_PERSONS, null, values);
		db.close(); // Closing database connection
	}

	public List<Person> getAllPersons() {
		List<Person> personList = new ArrayList<Person>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_PERSONS;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Person person = new Person();
				//person.set_person_id(Integer.parseInt(cursor.getString(0)));
				person.set_person_name(cursor.getString(0));

				// Adding deed to list
				personList.add(person);
			} while (cursor.moveToNext());
		}

		// return deed list
		return personList;
	}

}
