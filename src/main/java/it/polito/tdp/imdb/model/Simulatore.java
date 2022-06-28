package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;


import it.polito.tdp.imdb.model.Event.EventType;

public class Simulatore {
	
	//parametri output 
	private List<Actor> attoriIntervstati; 
	private int num_pause; 
	
	
	//parametri della simulazone 
	
	private List<Actor> attori_genere; 
	
	private Graph<Actor, DefaultWeightedEdge> grafo; 
	
	private LinkedList <Event> queue;
	
	private int n; //giorni

	public Simulatore(List<Actor> attori_genere, Graph<Actor, DefaultWeightedEdge> grafo, int n) {
		super();
		this.attori_genere = attori_genere;
		this.grafo = grafo;
		
		this.n = n; 
	} 
	
	public void  init ()
	{
		
		this.attoriIntervstati = new ArrayList <Actor> (); 
		
		this.num_pause = 0; 
		
		this.queue = new LinkedList <Event> (); 
		
	}
	
	public void creaEventi ()
	{
		
		
		for (int i=0; i<this.n; i++)
		{
			if (i==0)
			{
				
				int pos = (int) (Math.random() * this.attori_genere.size()); 
				
				this.queue.add(new Event (this.attori_genere.get(pos), i, EventType.INTERVISTA));
				
				
				
				
				
			}
			
			double caso = Math.random(); 
			
			this.queue.add(new Event (null, i, EventType.INTERVISTA)); 
			
		}
		
		
		
		
	}
	
		
		
		public void processEvent(Event e)
		{
			
			
				
				switch (e.getType())
				{
				
				
				
				case INTERVISTA:
					
					
					
				break; 
				
				
				case PAUSA:
					
					
					
				
				break; 
				
				}
		
		
		
	}
	
	public Actor trovaDaConsigliare ()
	{
		return null;
		
		
	
	}
	
	
	
	
	

}
