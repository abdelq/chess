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

    public static void demandeTour(Echiquier echiquier, boolean est_blanc, String mode) {
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Joueur " + (est_blanc ? "Blanc" : "Noir") + " ? ");

        String[] deplacements = scan.nextLine().split(" ");

        switch (deplacements.length) {
            case 0:
                afficheEchiquier(echiquier, mode);
                // System.out.println("Grille");
                demandeTour(echiquier, est_blanc, mode);
                return;
            case 1:
                // System.out.println("deplacementsPossibles");
                demandeTour(echiquier, est_blanc, mode);
                return;
            case 2:
                break;
            default:
                System.out.println("Ce n'est pas un déplacement valide.");
                demandeTour(echiquier, est_blanc, mode);
                return;
        }

        // TODO Transform directly to int
        char[] ori = deplacements[0].toCharArray();
        char[] dest = deplacements[1].toCharArray();

        // TODO Use caseValide. deplacementValide already uses it
        if (ori[0] < 'a' || ori[0] > 'h' || dest[0] < 'a' || dest[0] > 'h'
                || ori[1] < '0' || ori[1] > '7' || dest[1] < '0' || dest[1] > '7') {
            System.out.println("Ce n'est pas un déplacement valide.");
            demandeTour(echiquier, est_blanc, mode);
            return;
        }
              
        Piece piece = echiquier.examinePiece(ori[0] - 97, Character.getNumericValue(ori[1]));
        
        if (piece == null || piece.estBlanc() != est_blanc || !piece.deplacementValide(dest[0] - 97, Character.getNumericValue(dest[1]))) {
            System.out.println("Ce n'est pas un déplacement valide.");
            demandeTour(echiquier, est_blanc, mode);
            return;
        }
        
        // Call piece.deplace when all is good.
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Paramètre requis");
        }

        Echiquier echiquier = new Echiquier();

        while (true) {
            afficheEchiquier(echiquier, args[0]);
            demandeTour(echiquier, true, args[0]);

            afficheEchiquier(echiquier, args[0]);
            demandeTour(echiquier, false, args[0]);
        }
    }

}
