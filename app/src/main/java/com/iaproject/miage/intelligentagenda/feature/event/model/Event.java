package com.iaproject.miage.intelligentagenda.feature.event.model;

import com.iaproject.miage.intelligentagenda.exception.AddEventException;

import java.util.GregorianCalendar;

/**
 * Created by OOussema on 25/02/2017.
 */

public class Event implements Comparable<Event>{
	public String title;
	public String description;
	public GregorianCalendar dateStart;
	public GregorianCalendar dateEnd;


	public Event(String title, GregorianCalendar dateStart, GregorianCalendar dateEnd, String description)
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
	}
}
