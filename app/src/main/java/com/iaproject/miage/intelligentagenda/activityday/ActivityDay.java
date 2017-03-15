package com.iaproject.miage.intelligentagenda.activityday;


import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.iaproject.miage.intelligentagenda.R;
import com.iaproject.miage.intelligentagenda.database.daoDatabase;
import com.iaproject.miage.intelligentagenda.exception.AddEventException;
import com.iaproject.miage.intelligentagenda.feature.event.model.Agenda;
import com.iaproject.miage.intelligentagenda.feature.event.model.Event;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.iaproject.miage.intelligentagenda.R.layout.dialog;
import static com.iaproject.miage.intelligentagenda.R.layout.event_information;


public class ActivityDay extends AppCompatActivity {
	daoDatabase daoDatabase;
	DatabaseReference dref;
	Event event = null;

	private Agenda agenda = new Agenda("programme");
	//Event	event = new Event("","","","","test",isDateStartStrongness,isDateEndStrongness);
	ImageButton buttonAdd;
	SimpleAdapter sa = null;
	List<HashMap<String, Object>> list = null;
	HashMap<String, Object> map = null;
	ListView lv = null;
	static int i = 0;

	public ActivityDay() throws AddEventException {
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_day);

		list = new ArrayList<>();
		String[] from = new String[]{"titre", "place"};
		int[] to = new int[]{R.id.activity_title_event, R.id.activity_place};
		sa = new SimpleAdapter(this, list, R.layout.list_event, from, to);
		lv = (ListView) findViewById(R.id.listView);
		lv.setAdapter(sa);


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

								EditText descrip = (EditText) view.findViewById(R.id.editTextDescription);
								EditText tit = (EditText) view.findViewById(R.id.editTextTitle);
								EditText pla = (EditText) view.findViewById(R.id.editTextPlace);
								EditText start = (EditText) view.findViewById(R.id.editTextStart);
								EditText end = (EditText) view.findViewById(R.id.editTextEnd);
								CheckBox dForte = (CheckBox) view.findViewById(R.id.checkBoxStart);
								CheckBox fForte = (CheckBox) view.findViewById(R.id.checkBoxeEnd);
								boolean isDateStartStrongness = true;
								boolean isDateEndStrongness = true;


								if (dForte.isChecked()) {
									isDateStartStrongness = false;
								}
								if (fForte.isChecked()) {
									isDateEndStrongness = false;
								}

								/*SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy hh:mm");
								Date date1 ;
								Date date2 ;
								Calendar cal = new GregorianCalendar();
								Calendar cal2 = new GregorianCalendar();
								date1 = sdf.parse(start.getText().toString(),new ParsePosition(0));
								date2 = sdf.parse(end.getText().toString(),new ParsePosition(0));
								cal.setTime(date1);
								cal2.setTime(date2);*/


								try {
									event = new Event(tit.getText().toString(), pla.getText().toString(), start.getText().toString(), end.getText().toString(), descrip.getText().toString(), isDateStartStrongness, isDateEndStrongness);
									daoDatabase = new daoDatabase();
									daoDatabase.addEvent(event, agenda);
								} catch (AddEventException e) {
									e.printStackTrace();
									Toast.makeText(getApplicationContext(), "catch 1", Toast.LENGTH_SHORT).show();

								} catch (ParseException e) {
									e.printStackTrace();
									Toast.makeText(getApplicationContext(), "catch 2", Toast.LENGTH_SHORT).show();
								}


								Toast.makeText(getApplicationContext(), tit.getText().toString(), Toast.LENGTH_SHORT).show();


								//	Toast.makeText(getApplicationContext(),tit.getText().toString(), Toast.LENGTH_SHORT).show();

								map = new HashMap<String, Object>();
								map.put("titre", tit.getText().toString());
								map.put("place", pla.getText().toString());
								i++;
								list.add(map);
								sa.notifyDataSetChanged();
								lv.setAdapter(sa);
							}

						})
						.setNegativeButton("quitter", null)
						.setCancelable(false);
				AlertDialog dialog = Builder.create();
				dialog.show();

			}

		});

		final ImageButton sms = (ImageButton) findViewById(R.id.sms);
		sms.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent smsIntent = new Intent(Intent.ACTION_VIEW);
				smsIntent.setData(Uri.parse("smsto:"));
				smsIntent.setType("vnd.android-dir/mms-sms");
				smsIntent.putExtra("address", new String("01234"));
				smsIntent.putExtra("sms_body", "Test ");
				try {
					startActivity(smsIntent);
					finish();
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(ActivityDay.this, "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
				}

			}

		});

		final ImageButton phone = (ImageButton) findViewById(R.id.phone);
		phone.setOnClickListener(new View.OnClickListener() {

			public void onClick(View view) {
				Intent callIntent = new Intent(Intent.ACTION_VIEW);
				String tel = "0101010101";// Votre numéro de téléphone
				callIntent.setData(Uri.parse("tel:" + tel));
				startActivity(callIntent);

				try {
					startActivity(callIntent);
					finish();
				} catch (android.content.ActivityNotFoundException ex) {
					Toast.makeText(ActivityDay.this, "call faild, please try again later.", Toast.LENGTH_SHORT).show();
				}

			}

		});


		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long l) {
				list.remove(position);
				sa.notifyDataSetChanged();
			//	agenda.deleteEvent(event);
				return true;
			}

		});
		lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override

			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

				final View view2 = LayoutInflater.from(ActivityDay.this).inflate(event_information, null);
				AlertDialog.Builder Builder1 = new AlertDialog.Builder(ActivityDay.this);
				TextView des=(TextView)view2.findViewById(R.id.TextViewDescription);
				TextView ti=(TextView)view2.findViewById(R.id.TextViewTitre);
				TextView dd=(TextView)view2.findViewById(R.id.TextViewDateDebut);
				TextView df=(TextView)view2.findViewById(R.id.TextViewDateFin);
				TextView pl=(TextView)view2.findViewById(R.id.TextViewPlace);
				des.setText(event.description);
				ti.setText(event.title);
				pl.setText(event.place);
				dd.setText(event.startDate);
				df.setText(event.endDate);

				Builder1.setMessage("Creer votre evenement")
						.setView(view2)
						.setNegativeButton("quitter", null)
						.setCancelable(false);
				AlertDialog dialog = Builder1.create();
				dialog.show();
			}

		});

	}

}