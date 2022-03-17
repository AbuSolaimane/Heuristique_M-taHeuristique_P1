package exo2;

import java.util.Random;

public class TSP {

	private int nbrVilles;
	private int[][] distances;
	
	public TSP(int nbrVilles, int[][] distances) {
		super();
		this.nbrVilles = nbrVilles;
		this.distances = distances;
	}
	
	public Solution TSPNearestNeighbour() {
		
		 Random rand = new Random();
		Solution solution = new Solution();
		int n = nbrVilles + 1;
		int[] chemin = new int[n] ;
		initialiser(chemin, n);
		int premierVille = rand.nextInt(n-1);
		chemin[0] =   premierVille;
		chemin[n - 1] = premierVille;
		
		double fonctionObjectif = 0;
		
		for(int k=1; k<n-1;k++) {
			int[] dis = distances[chemin[k-1] ];
			chemin[k] = min(dis, chemin);
			fonctionObjectif += distances[chemin[k-1] ][chemin[k]];
		}
		fonctionObjectif += distances[chemin[n - 1] ][chemin[n - 2]];
		solution.setChemin(chemin);
		solution.setFonctionObjectif(fonctionObjectif);
		return solution;
	}
	
	private void initialiser(int[] chemin, int n) {
		for(int i=0;i<n;i++) {
			chemin[i] = n;
		}
	}

	private int min(int[] dis, int[] chemin) {
		int min = Integer.MAX_VALUE;
		int min_dis = Integer.MAX_VALUE;
		int k = 0;
		for(int i : dis) {
			if(i<min_dis && !Exist(k, chemin)) {
				min_dis = i;
				min = k;
			}
			k++;
		}
		return min;
	}
	
	private boolean Exist(int k, int[] chemin) {
		for(int i : chemin) {
			if(i == k)
				return true;
		}
		return false;
	}
	
}