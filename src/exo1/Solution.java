package exo1;

import java.util.ArrayList;

public class Solution {
	
	ArrayList<Boolean> instance;
	private int valeur;
	
	public Solution(ArrayList<Boolean> instance, int valeur) {
		super();
		this.instance = instance;
		this.valeur = valeur;
	}

	public Solution() {
		super();
	}

	public ArrayList<Boolean> getInstance() {
		
		return instance;
	}

	public void setInstances(ArrayList<Boolean> instance) {
		this.instance = instance;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

}