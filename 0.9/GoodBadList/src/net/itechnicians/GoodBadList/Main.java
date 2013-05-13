package net.itechnicians.GoodBadList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created with IntelliJ IDEA. User: maged Date: 03/05/13 Time: 03:23 م To
 * change this template use File | Settings | File Templates.
 */
public class Main extends Activity {

	ImageButton add, all, addper;
	Intent iAdd, iAll, addPer;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		addper = (ImageButton) findViewById(R.id.btnAdPer);
		add = (ImageButton) findViewById(R.id.btnNew);
		all = (ImageButton) findViewById(R.id.btnAll);
		iAdd = new Intent(getApplicationContext(), AddDeed.class);

		add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// To change body of implemented methods use File | Settings |
				// File Templates.
				startActivity(iAdd);
			}
		});

		iAll = new Intent(getApplicationContext(), AllDeeds.class);

		all.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// To change body of implemented methods use File | Settings |
				// File Templates.

				startActivity(iAll);
			}
		});

		addPer = new Intent(getApplicationContext(), AddPerson.class);
		addper.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(addPer);
			}
		});

	}
}