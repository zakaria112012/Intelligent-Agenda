package com.iaproject.miage.intelligentagenda.feature.event.model;



import com.iaproject.miage.intelligentagenda.exception.AddEventException;
import java.util.GregorianCalendar;


public class Event implements Comparable<Event>{

	public String title;
	public String description;
	public GregorianCalendar dateStart;
	public GregorianCalendar dateEnd;
	public String place;
	public boolean isDateStartStrongness;
	public boolean isDateEndStrongness;

	public Event(String title, String place, GregorianCalendar dateStart, GregorianCalendar dateEnd, String description,Boolean isDateStartStrongness,Boolean isDateEndStrongness )

			throws AddEventException {
		this.title = title;
		this.place = place;
		this.description = description;
		if(dateStart.before(dateEnd)){
			this.dateStart = dateStart;
			this.dateEnd = dateEnd;
			this.isDateEndStrongness = true;
			this.isDateStartStrongness = true;
		}
		else
			throw new AddEventException();
	}
	@Override
	public int compareTo(Event event) {
		return this.dateStart.compareTo(event.dateStart);
	}

	@Override
	public boolean equals(Object obj) {
		Event event = (Event) obj;
		if(event == this) return true;
		if(this.dateStart.compareTo(event.dateStart)==0 &&
				this.dateEnd.compareTo(event.dateEnd)==0) return true;
		else
			return false;

	}

}

/*public class Event{
	public String title;
	public String description;
	public String dateStart;
	public String dateEnd;

	public Event(String title, String dateStart, String dateEnd, String description) {
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.description = description;
		this.title = title;
	}*/


	/*public Event(String title, GregorianCalendar dateStart, GregorianCalendar dateEnd, String description)
			throws AddEventException {
		this.title = title;
		this.description = description;
		if(dateStart.before(dateEnd)){
			this.dateStart = dateStart;
			this.dateEnd = dateEnd;
		}
		else

			throw new AddEventException();
	}

	@Override
	public int compareTo(Event compareEvent) {
		return this.dateEnd.compareTo(compareEvent.dateStart);
	}*/

