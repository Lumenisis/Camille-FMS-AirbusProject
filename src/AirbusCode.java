import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class AirbusCode {

	public static void main(String[] args) {

		HashMap<Integer, ArrayList<String>> map = new HashMap<>();
		map.put(1, new ArrayList<String>(Arrays.asList("A320","PLM_AIRBUS_IN_SERVICE","Passenger")));
		map.put(2, new ArrayList<String>(Arrays.asList("A400M","PLM_AIRBUS_DEFINITION","Cargo")));
		map.put(3, new ArrayList<String>(Arrays.asList("A350","PLM_AIRBUS_FEASIBILITY","Passenger")));
		map.put(4, new ArrayList<String>(Arrays.asList("A380","PLM_AIRBUS_STOPPED","Passenger")));
		map.put(5, new ArrayList<String>(Arrays.asList("A220","PLM_AIRBUS_DEFINITION","Bomber")));
		map.put(6, new ArrayList<String>(Arrays.asList("A340","PLM_AIRBUS_IN_SERVICE","Passenger")));

		Scanner scan = new Scanner(System.in);

		int menuChoice;

		System.out.println("Bienvenue dans l'application de gestion du cycle de vie d'avions AIRBUS");
		System.out.println("Faites votre choix dans le menu et saisissez le chiffre correspondant");
		System.out.println();
		System.out.println("1 - Afficher tous les avions");
		System.out.println("2 - Afficher tous les avions contenant un mot clé dans le programme");
		System.out.println("3 - Ajouter ou supprimer une pièce pour un avion donné");
		System.out.println("4 - Afficher un avion avec les infos détaillées de chaque pièce");
		System.out.println("5 - Quitter l'application");
		System.out.println();

		menuChoice = scan.nextInt();

		while (menuChoice < 1 || menuChoice > 5) {
			System.out.println();
			System.out.println("Erreur de saisie");
			System.out.println("Faites votre choix dans le menu et saisissez le chiffre correspondant");
			System.out.println();
			menuChoice = scan.nextInt();
		}
		if (menuChoice == 1) {
			System.out.println();
			for (HashMap.Entry<Integer, ArrayList<String>> set : map.entrySet()) {
				System.out.println(set.getKey() + " = " + set.getValue());
			}
		} else if (menuChoice == 2) {
			System.out.println();
			System.out.println("Saisissez une lettre ou un chiffre");
			String userSearch = scan.next();
			for (HashMap.Entry<Integer, ArrayList<String>> set : map.entrySet()) {
				if (set.getValue().get(0).toLowerCase().contains(userSearch.toLowerCase())) {
					System.out.println(set.getKey() + " = " + set.getValue());
				}
			}
		} else if (menuChoice == 3) {
			System.out.println();
			System.out.println("Souhaitez-vous ajouter ou supprimer une pièce ?");
			System.out.println("Saisissez le mot add ou le mot del");
			String actionChoice = scan.next();
			System.out.println();
			switch (actionChoice) {
				case "add":
					System.out.println();
					System.out.println("Pour quel avion souhaitez-vous ajouter des pièces ?");
					System.out.println("Saisissez son numéro dans la liste");
					int keyAddList = scan.nextInt();
					System.out.println();
					System.out.println("Saisissez les éléments que vous souhaitez ajouter pour cet avion (nom, catégorie, prix)");
					String itemsAddList = scan.next();
					System.out.println();
					addItems(map, keyAddList, itemsAddList);
					// Here is the code
					// Here is the code
					// Here is the code
					System.out.println("Les éléments saisis sont ajoutés à la liste");
					break;
				case "remove":
					System.out.println();
					System.out.println("Pour quel avion souhaitez-vous supprimer des pièces ?");
					System.out.println("Saisissez son numéro dans la liste");
					int keyRemoveList = scan.nextInt();
					System.out.println();
					System.out.println("Saisissez les éléments que vous souhaitez supprimer pour cet avion");
					String itemsRemoveList = scan.next();
					System.out.println();
					removeItems(map, keyRemoveList, itemsRemoveList);
					// Here is the code
					// Here is the code
					// Here is the code
					System.out.println("Les éléments saisis sont supprimés de la liste");
					break;
			}	
		} else if (menuChoice == 4) {
			System.out.println();
			System.out.println("Voici la liste des avions avec les modifications qui ont été apportées");
			System.out.println();
			// Here is the code
			// Here is the code
			// Here is the code
		} else if (menuChoice == 5) {
			System.out.println();
			System.out.println("Fermeture de l'application");
			scan.close();
			System.exit(0);
		}
	}

	public static void addItems(HashMap<Integer, ArrayList<String>> map, int keyList, String value) {

		map.computeIfAbsent(keyList, k -> new ArrayList<>()).add(value);
	}

	public static void removeItems(HashMap<Integer, ArrayList<String>> map, int keyList, String value) {

		map.computeIfAbsent(keyList, k -> new ArrayList<>()).remove(value);
	}
}