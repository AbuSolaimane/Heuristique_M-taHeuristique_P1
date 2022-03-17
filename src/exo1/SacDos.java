package exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SacDos {

	private ArrayList<objet> objets;
	private int capacite;

	public SacDos(ArrayList<objet> objets, int capacite) {
		super();
		this.objets = objets;
		this.capacite = capacite;
	}

	public Solution glouton1() {
		int size = objets.size();
		ArrayList<Boolean> instance = new ArrayList<Boolean>(Arrays.asList(new Boolean[size]));
		Collections.fill(instance, Boolean.FALSE);
		int valeur = 0;

		ArrayList<objet> copy_objets = (ArrayList<objet>) objets.clone();
		Collections.sort(copy_objets, Collections.reverseOrder());

		int i = 0;
		int capaciteCopy = this.capacite;
		while (i<size && capaciteCopy>0) {
			if(capaciteCopy >= copy_objets.get(i).getPoids()) {
				
				valeur += copy_objets.get(i).getValeur();
				int v = objets.indexOf(copy_objets.get(i));
				instance.set(v, true);
				capaciteCopy -= copy_objets.get(i).getPoids();
			}
			i++;
		}

		Solution solution = new Solution(instance, valeur);
		return solution;
	}
	public Solution glouton2() {
		int size = objets.size();
		ArrayList<Boolean> instance = new ArrayList<Boolean>(Arrays.asList(new Boolean[size]));
		Collections.fill(instance, Boolean.FALSE);
		int valeur = 0;

		ArrayList<objet> copy_objets_val = (ArrayList<objet>) objets.clone();
		Collections.sort(copy_objets_val, new ComparatorValeur());
		 Collections.reverse(copy_objets_val);
		 
		 ArrayList<objet> copy_objets_poid = (ArrayList<objet>) copy_objets_val.clone();
		Collections.sort(copy_objets_poid, new ComparatorPoids());
		int i = 0;

		int capaciteCopy = this.capacite;
		while ((!copy_objets_val.isEmpty() || !copy_objets_poid.isEmpty()) && capaciteCopy >0) {
			if(i == 0) {
				if(capaciteCopy >= copy_objets_val.get(0).getPoids()) {
					
					valeur += copy_objets_val.get(0).getValeur();
					int v = objets.indexOf(copy_objets_val.get(0));
					instance.set(v, true);
					capaciteCopy -= copy_objets_val.get(0).getPoids();
					copy_objets_poid.remove(copy_objets_val.get(0));
					copy_objets_val.remove(0);
				}
				else {
					copy_objets_poid.remove(copy_objets_val.get(0));
					copy_objets_val.remove(0);
				}
				i = 1;
			}
			else {
				
				if(capaciteCopy >= copy_objets_poid.get(0).getPoids()) {
					
					valeur += copy_objets_poid.get(0).getValeur();
					int v = objets.indexOf(copy_objets_poid.get(0));
					instance.set(v, true);
					capaciteCopy -= copy_objets_poid.get(0).getPoids();
					copy_objets_val.remove(copy_objets_poid.get(0));
					copy_objets_poid.remove(0);
				}
				else {
					copy_objets_val.remove(copy_objets_poid.get(0));
					copy_objets_poid.remove(0);
				}
				
				i = 0;
			}
			
		}

		Solution solution = new Solution(instance, valeur);
		return solution;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	

}
