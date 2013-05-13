package net.itechnicians.GoodBadList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: maged
 * Date: 05/05/13
 * Time: 01:44 ص
 * To change this template use File | Settings | File Templates.
 */
public class AddPerson extends Activity {
	
	Button savePer;
	EditText et_per_name;
    Person p =new Person();
    DatabaseHandler db;
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_person);
        et_per_name=(EditText)findViewById(R.id.etPersonName);
        savePer=(Button)findViewById(R.id.btnSavePerson);
        db = new DatabaseHandler(this);
        
        savePer.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				 p._person_name = et_per_name.getText().toString();
	                db.addPerson(p);
	                Toast.makeText(getApplicationContext(), "Person Added", Toast.LENGTH_SHORT).show();
	                  finish();
				
			}
		});
    }
}