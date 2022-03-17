package exo1;

import java.util.Comparator;

public class ComparatorValeur implements Comparator<objet> {

	@Override
	public int compare(objet o1, objet o2) {
		
		return o1.getValeur() - o2.getValeur();
	}

}
