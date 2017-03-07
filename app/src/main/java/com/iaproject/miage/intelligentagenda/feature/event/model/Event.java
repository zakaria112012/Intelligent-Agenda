package com.iaproject.miage.intelligentagenda.feature.event.model;

/**
 * Created by OOussema on 25/02/2017.
 */

public class Event{
	public String title;
	public String description;
	public String dateStart;
	public String dateEnd;

	public Event(String title, String dateStart, String dateEnd, String description) {
		this.dateEnd = dateEnd;
		this.dateStart = dateStart;
		this.description = description;
		this.title = title;
	}


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
}
