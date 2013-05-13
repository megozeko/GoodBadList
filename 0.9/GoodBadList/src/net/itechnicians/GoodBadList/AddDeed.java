package net.itechnicians.GoodBadList;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class AddDeed extends Activity {
	/**
	 * Called when the activity is first created.
	 */

	EditText tv_desc;
	Button btn_save;
	DatabaseHandler db;
	Spinner spChild;
	RadioButton Rbtn_Good, Rbtn_Bad;
	RadioGroup Rg;
	Deed d = new Deed();
	Person p = new Person();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_deed);
		tv_desc = (EditText) findViewById(R.id.tvDesc);
		btn_save = (Button) findViewById(R.id.btnSave);
		Rg = (RadioGroup) findViewById(R.id.Rg);
		Rbtn_Bad = (RadioButton) findViewById(R.id.rbtnBad);
		Rbtn_Good = (RadioButton) findViewById(R.id.rbtnGood);
		spChild = (Spinner) findViewById(R.id.spChild);
		db = new DatabaseHandler(this);

		// Spinner Drop down elements
		List<Person> lables = db.getAllPersons();

		// Creating adapter for spinner
		ArrayAdapter<Person> dataAdapter = new ArrayAdapter<Person>(this,
				android.R.layout.simple_spinner_item, lables);

		// Drop down layout style - list view with radio button
		dataAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		// attaching data adapter to spinner
		spChild.setAdapter(dataAdapter);

		Rbtn_Good.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				d._type = "Good";

			}
		});

		Rbtn_Bad.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				d._type = "Bad";

			}
		});

		btn_save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// To change body of implemented methods use File | Settings |
				// File Templates.

				d._desc = tv_desc.getText().toString();

				d._person_name = spChild.getSelectedItem().toString();

				db.addDeed(d);
				Toast.makeText(getApplicationContext(), "Deed Added",
						Toast.LENGTH_SHORT).show();
				finish();
			}
		});

	}

}
