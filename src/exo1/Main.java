package exo1;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		objet o1 = new objet(87, 15);
		objet o2 = new objet(58, 16);
		objet o3 = new objet(46, 11);
		objet o4 = new objet(70, 12);
		objet o5 = new objet(63, 21);
		objet o6 = new objet(17, 8);
		objet o7 = new objet(70, 19);
		objet o8 = new objet(19, 24);
		objet o9 = new objet(15, 38);
		objet o10 = new objet(11, 32);
		objet o11 = new objet(109, 14);
		objet o12 = new objet(77, 18);
		objet o13 = new objet(24, 26);
		objet o14 = new objet(99, 8);
		objet o15 = new objet(45, 35);
		objet o16 = new objet(39, 29);
		objet o17 = new objet(78, 40);
		objet o18 = new objet(47, 11);
		objet o19 = new objet(96, 28);
		objet o20 = new objet(120, 64);
		objet o21 = new objet(1, 19);
		
		ArrayList<objet> objets = new ArrayList<>();
		ArrayList<objet> objets2 = generateobjets(21);
		objets.add(o1);
		objets.add(o2);
		objets.add(o3);
		objets.add(o4);
		objets.add(o5);
		objets.add(o6);
		objets.add(o7);
		objets.add(o8);
		objets.add(o9);
		objets.add(o10);
		objets.add(o11);
		objets.add(o12);
		objets.add(o13);
		objets.add(o14);
		objets.add(o15);
		objets.add(o16);
		objets.add(o17);
		objets.add(o18);
		objets.add(o19);
		objets.add(o20);
		objets.add(o21);
		
		Date uDate1 = new Date (System.currentTimeMillis ()); //Le temps avant le debut du progamme (en milliseconde)
		
		SacDos sacdos = new SacDos(objets, 200);
		
		Solution  solution = sacdos.glouton1();
		
		Date duree1 = new Date (System.currentTimeMillis()); //Pour calculer la différence
		Date dateFin1 = new Date (System.currentTimeMillis());
		duree1.setTime (dateFin1.getTime () - uDate1.getTime ()); //Calcul de la différence
		long secondes1 = duree1.getTime () / 1000;
		long min1 = secondes1 / 60;
		long heures1 = min1 / 60;
		long mili1 = duree1.getTime () % 1000;
		secondes1 %= 60;
		System.out.println ("Temps passé durant le traitement : \nHeures : " + heures1 + " Minutes : " + min1 + " Secondes : " + secondes1 + " Milisecondes : " + mili1 + "");
		
		
		
		System.out.println(solution.getValeur());
		System.out.println(solution.getInstance());
		
		System.out.println("--------------------------------------------------------------------------------------------");
		
		Date uDate2 = new Date (System.currentTimeMillis ()); //Le temps avant le debut du progamme (en milliseconde)
		
		
		Solution  solution2 = sacdos.glouton2();
		
		Date duree2 = new Date (System.currentTimeMillis()); //Pour calculer la différence
		Date dateFin2 = new Date (System.currentTimeMillis());
		duree2.setTime (dateFin2.getTime () - uDate2.getTime ()); //Calcul de la différence
		long secondes2 = duree2.getTime () / 1000;
		long min2 = secondes2 / 60;
		long heures2 = min2 / 60;
		long mili2 = duree2.getTime () % 1000;
		secondes2 %= 60;
		System.out.println ("Temps passé durant le traitement : \nHeures : " + heures2 + " Minutes : " + min2 + " Secondes : " + secondes2 + " Milisecondes : " + mili2 + "");
		
		
		System.out.println(solution2.getValeur());
		System.out.println(solution2.getInstance());
	}

private static ArrayList<objet> generateobjets(int n) {
		
		ArrayList<objet> objets = new ArrayList<>();
		Random rand = new Random();
		for (int i = 0; i < n; i++) {
			int valeur =  rand.nextInt(200) + 1;
			int poid = rand.nextInt(150) + 1;
			objets.add(new objet(valeur, poid));
		}
		
		return objets;
	}
	
}
