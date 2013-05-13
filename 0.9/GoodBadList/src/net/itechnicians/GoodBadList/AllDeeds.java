package net.itechnicians.GoodBadList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.List;



public class AllDeeds extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_all_deeds);

        DatabaseHandler db;

        List<Deed> deedList;

        db = new DatabaseHandler(this);

		deedList = db.getAllDeeds();

		ListView lv = (ListView) findViewById(R.id.lvDeeds);

		final ArrayAdapter<Deed> adapter = new ArrayAdapter<Deed>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				deedList);

		lv.setAdapter(adapter);

	}

}