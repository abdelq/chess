package chess;

import java.util.Scanner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class JeuEchec {
    private static Echiquier echiquier;
    private static Scanner scan;
    private static String mode_affichage;

    public static void afficheEchiquier() {
        switch (mode_affichage) {
        case "ascii":
            echiquier.afficheAscii();
            break;
        case "unicode":
            echiquier.afficheUnicode();
            break;
        default:
            throw new IllegalArgumentException("Paramètre invalide");
        }
    }

    public static void demandeTour(boolean blanc) {
        System.out.print("Joueur " + (blanc ? "Blanc" : "Noir") + " ? ");

        do {
        	String line = scan.nextLine();
			String[] deplacements = line.split(" ");
			if (line.length() == 0){ // ligne vide
				// todo: afficher l'echiquier
				System.out.println("Afficher l'echiquier");
			}
			else if (deplacements.length == 1){
				try {
					int[] coord = parseCoord(deplacements[0]);
					if (echiquier.caseValide(coord[0], coord[1])){
						Piece piece = echiquier.examinePiece(coord[0], coord[1]);
						if (piece != null){
							// todo: afficher les deplacements possible
							System.out.println("Voici les deplacements possibles: (Pas vraiment...)");
						}
						else {
							System.out.println("Il n'y a pas de piece a cet endroit");
						}
					}
					else {
						System.out.println("Cette case n'est pas valide [" + coord[0] + ", " + coord[1] + "]");
					}
				}
				catch (IllegalArgumentException e){
					System.out.println("La coordonnee n'a pas ete rentre dans le bon format. Il faut ecrire la lettre (a-h) suivit du chiffre (1-8) de la case desiree");
				}
			}
			else if (deplacements.length == 2){
				try {
					int[] depart = parseCoord(deplacements[0]);
					int[] arrive = parseCoord(deplacements[1]);
					if (echiquier.caseValide(depart[0], depart[1])){
						Piece piece = echiquier.examinePiece(depart[0], depart[1]);
						if (piece == null){
							System.out.println("Il n'y a pas de piece a la position de depart");
						}
						else if (piece.estBlanc() == blanc){
							System.out.println("Il n'est pas possible de deplacer une piece ennemi");
						}
						else if (piece.deplacementValide(arrive[0], arrive[1])){
							// todo: deplacement
							System.out.println("Deplacement de la piece");
							break;
						}
						else {
							System.out.println("La destination n'est pas valide");
						}
					}
					else {
						System.out.println("La case de depart n'est pas valide");
					}
				}
				catch (IllegalArgumentException e){
					System.out.println("Les coordonnes n'ont pas ete rentre dans le bon format. Les coordonnes doivent etre rentre dans la forme lettre (a-h) suivit du chiffre (1-8)");
				}
			}
			else {
				System.out.println("wtf");
			}
		} while(true);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Paramètre requis");
        }

        scan = new Scanner(System.in);
        echiquier = new Echiquier();
        mode_affichage = args[0];

        while (true) {
            afficheEchiquier();
            demandeTour(true);

            afficheEchiquier();
            demandeTour(false);
        }
    }

	/**
	 * retourne un int[2] representant une coordonnee sur l'echiquier
	 * @param in : La coordonnee sous forme de chaine
	 * @return la coordonnee sous forme de deux entiers [colone, ligne]
	 */
	public static int[] parseCoord(String in){
		if (in.length() != 2)
			throw new IllegalArgumentException("La coordonnee rentre n'est pas valide");
    	char lettre = in.charAt(0);
    	char chiffre = in.charAt(1);
    	return new int[]{7-'h'+lettre, 7-'8'+chiffre};
	}

}
