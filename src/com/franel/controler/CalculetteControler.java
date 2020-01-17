/**
 * 
 */
package com.franel.controler;

import com.franel.model.AbstractModel;

/**
 * @author franel
 *
 */
public class CalculetteControler extends AbstractControler{

	public CalculetteControler(AbstractModel cal) {
		super(cal);
		// TODO Auto-generated constructor stub
	}

	@Override
	void control() {
		// TODO Auto-generated method stub
		//On notifie le modèle d'une action si le controle est bon
		
		//si l'opérateur est dans la liste
		if(this.listOperateur.contains(this.operateur)) {
			//si l'opérateur est le =
			if(this.operateur.equals("="))
				this.calc.getResultat(); // On affiche le résultat par le modèle
			//sinon on passe l'opérateur au modele
			else
				this.calc.setOperateur(this.operateur);
		}
		
		//si le nombre est conforme
		if(this.nbre.matches("^[0-9.]+$"))
			this.calc.setNombre(this.nbre);
		
		this.operateur = "";
		this.nbre = "";
	}
	
}
