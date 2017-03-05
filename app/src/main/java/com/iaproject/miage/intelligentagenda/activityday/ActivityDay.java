package com.iaproject.miage.intelligentagenda.activityday;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.iaproject.miage.intelligentagenda.R;
import com.iaproject.miage.intelligentagenda.feature.event.model.Agenda;
import com.iaproject.miage.intelligentagenda.feature.event.model.Event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.iaproject.miage.intelligentagenda.R.layout.dialog;

public class ActivityDay extends AppCompatActivity {
	ImageButton buttonAdd;
	Agenda agenda;
	Event event;
	SimpleAdapter sa = null;
	List<HashMap<String, Object>> list = null;
	HashMap<String, Object> map_personn = null;
	ListView lv = null;
	static int i = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_day);


		list = new ArrayList<>();
		String[] from = new String[]{"titre", "description"};
		int[] to = new int[]{R.id.activity_title_event, R.id.activity_title_descip};
		HashMap<String, Object> map1 = new HashMap<>();
		map1.put("nom", "medjir");
		map1.put("prenom", "zakaria");


		sa = new SimpleAdapter(this, list, R.layout.list_event, from, to);
		lv = (ListView) findViewById(R.id.listView);
		lv.setAdapter(sa);


		final EditText titre = (EditText) findViewById(R.id.editTextTitle);
		final EditText debut = (EditText) findViewById(R.id.editTextStart);
		final EditText fin = (EditText) findViewById(R.id.editTextEnd);
		final EditText description = (EditText) findViewById(R.id.editTextDescription);
		final TextView titreEven = (TextView) findViewById(R.id.activity_title_event);
		final TextView debutEven = (TextView) findViewById(R.id.activity_date_start_event);
		final TextView finEven = (TextView) findViewById(R.id.activity_date_end_event);
		final TextView descriEven = (TextView) findViewById(R.id.activity_desc_event);



		buttonAdd = (ImageButton) findViewById(R.id.activity_day_button_add);
		buttonAdd.setOnClickListener(new View.OnClickListener() {


			@Override
			public void onClick(View v) {



				final View view = LayoutInflater.from(ActivityDay.this).inflate(dialog, null);
				AlertDialog.Builder Builder = new AlertDialog.Builder(ActivityDay.this);





				Builder.setMessage("Creer votre evenement")
						.setView(view)
						.setPositiveButton("Valider", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialogInterface, int wich) {
								// operation à effectuées



								 EditText description = (EditText)view.findViewById(R.id.editTextDescription);
								 EditText titre = (EditText)view.findViewById(R.id.editTextTitle);
								EditText start = (EditText)view.findViewById(R.id.editTextStart);
								EditText  end = (EditText)view.findViewById(R.id.editTextEnd);



								//Log.i("", titre.getText().toString() + " " + description.getText().toString());


								Toast.makeText(getApplicationContext(),titre.getText().toString(), Toast.LENGTH_SHORT).show();

								map_personn = new HashMap<String, Object>();
								map_personn.put("titre", titre.getText().toString());
								map_personn.put("description", description.getText().toString());
								i++;
								list.add(map_personn);
								sa.notifyDataSetChanged();
								lv.setAdapter(sa);




								/*Event event = new Event(titre.getText().toString(), debut.getText().toString(), fin.getText().toString(), description.getText().toString());
								Agenda agenda = new Agenda("test");
								agenda.addEvent(event);*/




							}
						})
						.setNegativeButton("quitter", null)
						.setCancelable(false);
				AlertDialog dialog = Builder.create();
				dialog.show();





			}
		});

		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
				list.remove(position);
				sa.notifyDataSetChanged();
				return true;
			}


		});


		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


/*
				EditText description = (EditText)view.findViewById(R.id.editTextDescription);
				EditText titre = (EditText)view.findViewById(R.id.editTextTitle);
				EditText start = (EditText)view.findViewById(R.id.editTextStart);
				EditText  end = (EditText)view.findViewById(R.id.editTextEnd);

				titreEven.setText(titre.getText().toString());
				descriEven.setText(description.getText().toString());
				debutEven.setText(start.getText().toString());
				finEven.setText(end.getText().toString());
*/
			}
		});


	}
		}






