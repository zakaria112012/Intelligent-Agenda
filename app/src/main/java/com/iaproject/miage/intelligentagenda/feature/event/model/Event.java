package com.iaproject.miage.intelligentagenda.feature.event.model;

/**
 * Created by OOussema on 25/02/2017.
 */

public class Event {
	public String title;
	public String start;
	public String end;
	public String description;


	public Event(String description, String end, String start, String title) {
		this.description = description;
		this.end = end;
		this.start = start;
		this.title = title;
	}



	/*public Event(String title, Date start, Date end, String description) {
		this.title = title;
		this.description = description;
		if(start.before(end)){
			this.start = start;
			this.end = end;
		}
	}

*/


}
