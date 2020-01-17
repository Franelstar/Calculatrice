/**
 * 
 */
package com.franel.controler;

import java.util.ArrayList;

import com.franel.model.AbstractModel;

/**
 * @author franel
 *
 */
public abstract class AbstractControler {
	protected AbstractModel calc;
	protected String operateur = "";
	protected String nbre = "";
	protected ArrayList<String> listOperateur = new ArrayList<String>();
	
	public AbstractControler(AbstractModel cal) {
		this.calc = cal;
		
		this.listOperateur.add("+");
		this.listOperateur.add("-");
		this.listOperateur.add("*");
		this.listOperateur.add("/");
		this.listOperateur.add("=");
	}
	
	//Fonction pour définir l'opérateur
	public void setOperateur(String ope) {
		this.operateur = ope;
		control();
	}
	
	//Fonction pour définir le nombre
	public void setNombre(String nombre) {
		this.nbre = nombre;
		control();
	}
	
	//Fonction pour effacer
	public void reset() {
		this.calc.reset();
	}
	
	//Méthode de controle
	abstract void control();
}
