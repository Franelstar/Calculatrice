/**
 * 
 */
package com.franel.model;

import java.util.ArrayList;

import com.franel.observer.*;

/**
 * @author franel
 *
 */
public abstract class AbstractModel implements Observable{
	protected double result = 0;
	protected String operateur = "";
	protected String operande = "";
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();
	
	// Fonction pour effacer
	public abstract void reset();
	
	// Fonction pour afficher le résultat
	public abstract void getResultat();
	
	// Fonction pour définir l'opérateur de l'opération
	public abstract void setOperateur(String operateur);
	
	// Fonction pour définir le nombre à utiliser pour l'opération
	public abstract void setNombre(String nbre);
	
	// Patern observer
	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
	}
	
	public void notifyObserver(String str) {
		if(str.matches("^0[0-9]+"))
			str = str.substring(1, str.length());
		
		for(Observer obs : listObserver)
			obs.update(str);
	}

	public void removeObserver() {
		listObserver = new ArrayList<Observer>();
	}
}
