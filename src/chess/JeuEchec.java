package chess;

import java.util.Scanner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class JeuEchec {

    private static Echiquier echiquier;
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

    public static void demandeTour(boolean est_blanc) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Joueur " + (est_blanc ? "Blanc" : "Noir") + " ? ");

        String[] deplacements = scan.nextLine().split(" ");

        if (deplacements.length == 0) {
            afficheEchiquier();
            demandeTour(est_blanc);
            return;
        } else if (deplacements.length == 1) {
            // TODO deplacementsPossibles
            demandeTour(est_blanc);
            return;
        } else if (deplacements.length == 2) {
            int[] ori = {deplacements[0].charAt(0) - 97, Character.getNumericValue(deplacements[0].charAt(1))};
            int[] dest = {deplacements[1].charAt(0) - 97, Character.getNumericValue(deplacements[1].charAt(1))};

            if (echiquier.caseValide(ori[0], ori[1])) {
                Piece piece = echiquier.examinePiece(ori[0], ori[1]);

                if (piece != null && piece.estBlanc() == est_blanc && piece.deplacementValide(dest[0], dest[1])) {
                    // TODO Afficher capture
                    piece.deplace(dest[0], dest[1]);
                    return;
                }
            }
        }

        System.out.println("Ce n'est pas un déplacement valide.");
        demandeTour(est_blanc);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Paramètre requis");
        }

        echiquier = new Echiquier();
        mode_affichage = args[0];

        while (true) {
            afficheEchiquier();
            demandeTour(true);

            afficheEchiquier();
            demandeTour(false);
        }
    }

}
