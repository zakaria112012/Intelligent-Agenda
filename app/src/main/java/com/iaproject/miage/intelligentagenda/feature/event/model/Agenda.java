package com.iaproject.miage.intelligentagenda.feature.event.model;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by OOussema on 25/02/2017.
 */

public class Agenda {
	public String titleAgenda;
	public List<Event> listEvent;

	public Agenda(String titleAgenda){
		this.titleAgenda = titleAgenda;
		this.listEvent = new ArrayList<>();
	}

	/***
	 * Permet d'ajouter un évenement dans la liste
	 * @param e : c'est l'évenement qui sera ajouté
	 * @return
	 */
	public boolean addEvent(Event e){
		boolean result = false;
		try {
			if(this.listEvent.size() == 0) return this.listEvent.add(e);
			/*else if (!checkOverlapEvent(e)) {
				result = this.listEvent.add(e);
				Collections.sort(listEvent);
			}*/
		}
		catch (Exception exp){

		}
		return result;
	}

	/***
	 * Permet de supprimer un évenement de la liste
	 * @param e : c'est l'évenement selectionné
	 * @return
	 */
	/*public boolean deleteEvent(Event e){
		boolean result = false;
		try{
			result = this.listEvent.remove(e);
		}catch (Exception exp){

		}
		return result;
	}

	/***
	 * Vérifie si deux évenements ne sont pas parallèles
	 */
	/*public boolean checkOverlapEvent(Event eventAdded){
		boolean result = true;
		Event eventBefore = listEvent.get(0);
		if(eventAdded.dateStart.after(eventBefore.dateEnd)) return false;

		for(Event event : listEvent.subList(1,listEvent.size())){
			if(eventAdded.dateStart.after(eventBefore.dateEnd)){
				if(eventAdded.dateStart.before(event.dateEnd) && eventAdded.dateEnd.before(event.dateEnd))
					result = false;
				eventBefore = event;
			}
		}

		return result;
	}

*/
}
