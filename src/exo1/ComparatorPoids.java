package exo1;

import java.util.Comparator;

public class ComparatorPoids implements Comparator<objet> {

	@Override
	public int compare(objet o1, objet o2) {
		
		return o1.getPoids() - o2.getPoids();
	}

}
