package com.iaproject.miage.intelligentagenda.test;

import com.iaproject.miage.intelligentagenda.feature.event.model.Agenda;
import com.iaproject.miage.intelligentagenda.feature.event.model.Event;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by OOussema on 25/02/2017.
 */

public class AgendaTest {
	Agenda agenda;
	GregorianCalendar e1Start;
	GregorianCalendar e1End;
	GregorianCalendar e2Start;
	GregorianCalendar e2End;
	GregorianCalendar e3Start;
	GregorianCalendar e3End;
	GregorianCalendar e4Start;
	GregorianCalendar e4End;
	Event e1;
	Event e2;
	Event e3;
	List<Event> eventList;


	@Before
	public void setUp() throws Exception {
		agenda = new Agenda("My agenda");

		e1Start = new GregorianCalendar(2017, 2, 13, 14, 20);
		e1End = new GregorianCalendar(2017, 2, 13, 15, 00);

		e2Start = new GregorianCalendar(2017, 2, 14, 9, 00);
		e2End = new GregorianCalendar(2017, 2, 14, 12, 00);

		e3Start = new GregorianCalendar(2017, 2, 14, 9, 00);
		e3End = new GregorianCalendar(2017, 2, 14, 18, 00);

		e1 = new Event("Rendez vous pro",e1Start,e1End, "Rendez vous pour un entretien");
		e2 = new Event("Rendez vous RH",e2Start,e2End, "Rendez vous pour un candidat");
		e3 = new Event("Evenement",e3Start,e3End, "Rendez vous pour un candidat 2");

		eventList = new ArrayList<>();
		eventList.add(e1);
		eventList.add(e2);
		eventList.add(e3);
	}

	@After
	public void tearDown() throws Exception {
		agenda = null;
		e1 = null;
		e2 = null;
		e3 = null;
		e1Start = null;
		e1End = null;
		e2Start = null;
		e2End = null;
		e3Start = null;
		e3End = null;
		eventList = null;
	}

	@Test
	public void addEvent() throws Exception {
		Assert.assertSame(true,agenda.addEvent(e1));
		Assert.assertSame(true,agenda.addEvent(e2));
//		Assert.assertSame(false,agenda.addEvent(e3));
	}


//	@Test
//	public void deleteEvent() throws Exception {
//		agenda.deleteEvent(e1);
//		boolean testDel = agenda.listEvent.contains(e1);
//		Assert.assertEquals(false, testDel);
//	}

	@Test
	public void checkOverlapEvent() throws Exception {


	}

}