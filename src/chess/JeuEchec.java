package chess;

import java.util.Scanner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class JeuEchec {

    public static void afficheEchiquier(Echiquier echiquier, String mode) {
        switch (mode) {
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

    public static void demandeTour(Echiquier echiquier, boolean est_blanc) {
        // TODO Refactor
        Scanner scan = new Scanner(System.in);

        if (est_blanc) {
            System.out.print("Joueur Blanc ? ");
        } else {
            System.out.print("Joueur Noir ? ");
        }

        String[] deplacements = scan.nextLine().split(" ");

        if (deplacements.length != 2 || deplacements[0].length() != 2 || deplacements[1].length() != 2) {
            System.out.println("Ce n'est pas un déplacement valide.");
            demandeTour(echiquier, est_blanc);
            return;
        }

        // TODO Transform directly to int
        char[] ori = deplacements[0].toCharArray();
        char[] dest = deplacements[1].toCharArray();

        // TODO Use caseValide
        if (ori[0] < 'a' || ori[0] > 'h' || dest[0] < 'a' || dest[0] > 'h'
                || ori[1] < '0' || ori[1] > '7' || dest[1] < '0' || dest[1] > '7') {
            System.out.println("Ce n'est pas un déplacement valide.");
            demandeTour(echiquier, est_blanc);
            return;
        }
              
        Piece piece = echiquier.examinePiece(ori[0] - 97, Character.getNumericValue(ori[1]));
        
        if (piece == null || piece.estBlanc() != est_blanc || !piece.deplacementValide(dest[0] - 97, Character.getNumericValue(dest[1]))) {
            System.out.println("Ce n'est pas un déplacement valide.");
            demandeTour(echiquier, est_blanc);
            return;
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Paramètre requis");
        }

        Echiquier echiquier = new Echiquier();

        while (true) {
            afficheEchiquier(echiquier, args[0]);
            demandeTour(echiquier, true);

            afficheEchiquier(echiquier, args[0]);
            demandeTour(echiquier, false);
        }
    }

}
