/**
 * 
 */
package com.franel.model;

/**
 * @author franel
 *
 */
public class Calculator extends AbstractModel{

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		this.result = 0;
		this.operande = "0";
		this.operateur = "";
		
		//Mise à jour
		notifyObserver(String.valueOf(this.result));
	}

	@Override
	public void getResultat() {
		// TODO Auto-generated method stub
		calcul();
	}

	@Override
	public void setOperateur(String opt) {
		// TODO Auto-generated method stub
		// On lance le calcul
		calcul();
		
		//On stocke l'opérateur
		this.operateur = opt;
		
		//Si l'opérateur n'est pas le =
		if(!opt.equals("=")) {
			//On reinitialise l'opérande
			this.operande = "";
		}
	}

	@Override
	public void setNombre(String result) {
		// TODO Auto-generated method stub
		//On concatène le nombre
		this.operande += result;
		
		//On met à jour
		notifyObserver(this.operande);
	}
	
	//Fonction de calcul
	public void calcul() {
		//S'il n y a pas d'opérateur, le résultat est le nombre saisi
		if(this.operateur.equals("")) {
			this.result = Double.parseDouble(this.operande);
		}
		else {
			//Si l'opérande n'est pas vide, on calcule avec l'opérateur de calcul
			if(!this.operande.equals("")){
				if(this.operateur.equals("+"))
					this.result += Double.parseDouble(this.operande);
				
				if(this.operateur.equals("-"))
					this.result -= Double.parseDouble(this.operande);
				
				if(this.operateur.equals("*"))
					this.result *= Double.parseDouble(this.operande);
				
				if(this.operateur.equals("/")) {
					try {
						this.result /= Double.parseDouble(this.operande);
					}catch(ArithmeticException e) {
						this.result = 0;
					}
				}
			}
		}
		this.operande = "";
		
		//On lance la mise à jour
		notifyObserver(String.valueOf(this.result));
	}

}
