/**
 * 
 */
package com.franel.observer;

/**
 * @author franel
 *
 */
public interface Observable {
	public void addObserver(Observer obs);
	
	public void removeObserver();
	
	public void notifyObserver(String str);

}
