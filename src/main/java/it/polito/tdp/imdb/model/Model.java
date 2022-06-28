package it.polito.tdp.imdb.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.alg.connectivity.ConnectivityInspector;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.imdb.db.ImdbDAO;

public class Model {
	
	private ImdbDAO dao; 
	
	private Graph <Actor, DefaultWeightedEdge> grafo;
	
	private List<String> geners; 
	
	private List <Actor> attoriGenere; 
	
	private Map<Integer, Actor> attoriGenereID; 

	public Model() {
		super();
		
		this.dao = new ImdbDAO(); 
		
		this.geners = new ArrayList(dao.listGenres()); 
		
		this.attoriGenere = new ArrayList<Actor>();
		
		this.attoriGenereID = new HashMap <Integer, Actor>(); 
		
	}
	
	public void creaGrafo (String genre)
	{
		
		this.grafo = new SimpleWeightedGraph<Actor, DefaultWeightedEdge> (DefaultWeightedEdge.class); 
		
		this.attoriGenere = dao.listActorsVertex(genre); 
		
		for (Actor a : this.attoriGenere)
		{
			
			this.attoriGenereID.put(a.getId(), a); 
			
		}
		
		Graphs.addAllVertices(this.grafo, this.attoriGenere); 
		
		List <Adiacenza> edges = new ArrayList<Adiacenza> (dao.getAdiacenze(genre));
		
		for (Adiacenza a : edges)
		{
			
			if (!this.grafo.containsEdge(this.attoriGenereID.get(a.getId1()), this.attoriGenereID.get(a.getId2())))
			{
				
				Graphs.addEdge(this.grafo, this.attoriGenereID.get(a.getId1()), this.attoriGenereID.get(a.getId2()), a.getPeso()); 
				
			}
			
			
		}
		
		
		
	}
	
	public List<Actor> trovaAttori (Graph <Actor, DefaultWeightedEdge> grafo, Actor partenza)
	{
		List<Actor> attori  = new ArrayList<Actor>(); 
		  ConnectivityInspector<Actor, DefaultWeightedEdge> ci = new ConnectivityInspector <> (this.grafo); 
		  attori.addAll(ci.connectedSetOf(partenza)); 
		
		  
		  Map attoriCognome = new TreeMap <String, Actor>(); 
		  
		  for (Actor a : attori)
		  {
			  attoriCognome.put(a.getLastName(), a); 
			  
			  
			  
		  }
		  
		  List <Actor> attoriOrdinati = new ArrayList <Actor> (attoriCognome.values()); 
		  
		  return attoriOrdinati; 
		
	}

	public Graph<Actor, DefaultWeightedEdge> getGrafo() {
		return grafo;
	}

	

	public List<String> getGeners() {
		return geners;
	}

	public void setGeners(List<String> geners) {
		this.geners = geners;
	} 
	
	
	
	
	

}
