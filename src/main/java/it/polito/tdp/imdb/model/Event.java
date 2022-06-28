package it.polito.tdp.imdb.model;

public class Event {
	
	public enum EventType {
		
		INTERVISTA, PAUSA 
		
	}
	
	private Actor attore; 
	
	private int giorno;
	
	private EventType type; 
	
	private Actor attoreConsigliato; 
	
	

	public Actor getAttoreConsigliato() {
		return attoreConsigliato;
	}

	public void setAttoreConsigliato(Actor attoreConsigliato) {
		this.attoreConsigliato = attoreConsigliato;
	}

	public Event(Actor attore, int giorno, EventType type) {
		super();
		this.attore = attore;
		this.giorno = giorno;
		this.type = type;
	}

	public Actor getAttore() {
		return attore;
	}

	public void setAttore(Actor attore) {
		this.attore = attore;
	}

	public int getGiorno() {
		return giorno;
	}

	public void setGiorno(int giorno) {
		this.giorno = giorno;
	}

	public EventType getType() {
		return type;
	}

	public void setType(EventType type) {
		this.type = type;
	} 
	
	
	
	

}
