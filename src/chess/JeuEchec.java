package chess;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class JeuEchec {
    private static Scanner scan;
    private static Echiquier echiquier;
    private static String mode_affichage;
    public static final String ASCII = "ascii", UNICODE = "unicode";

    public static void afficheEchiquier() throws UnsupportedEncodingException {
        switch (mode_affichage) {
        case ASCII:
            echiquier.afficheAscii(null);
            break;
        case UNICODE:
            echiquier.afficheUnicode(null);
            break;
        default:
            throw new IllegalArgumentException("Parametre (" + mode_affichage + ") invalide");
        }
    }
    public static void afficherDepsPossibles(Piece piece) throws UnsupportedEncodingException {
        System.out.println("Deplacements possibles : ");

        switch (mode_affichage) {
        case ASCII:
            echiquier.afficheAscii(piece);
            break;
        case UNICODE:
            echiquier.afficheUnicode(piece);
            break;
        }
    }

    public static int[] parseCoord(String input) {
        if (input.length() != 2) {
            throw new IllegalArgumentException();
        }

        return new int[] {input.charAt(0) - 97, input.charAt(1) - 49};
    }

    public static void demandeTour(boolean blanc) throws UnsupportedEncodingException {
        do {
            System.out.print("Joueur " + (blanc ? "Blanc" : "Noir") + " ? ");

            String line = scan.nextLine();
            String[] deplacements = line.split(" ");

            if (line.length() == 0) { // Ligne vide
                afficheEchiquier();
            } else if (deplacements.length == 1) {
                try {
                    int[] coord = parseCoord(deplacements[0]);

                    if (echiquier.caseValide(coord[0], coord[1])) {
                        Piece piece = echiquier.examinePiece(coord[0], coord[1]);

                        if (piece != null) {
                            afficherDepsPossibles(piece);
                        } else {
                            System.out.println("Pas de piece a cet endroit");
                        }
                    } else {
                        System.out.println("Case invalide");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Mauvais format de coordonnees. Bon format : lettre (a-h) suivie du chiffre (1-8)");
                }
            } else if (deplacements.length == 2) {
                try {
                    int[] orig = parseCoord(deplacements[0]);
                    int[] dest = parseCoord(deplacements[1]);

                    if (echiquier.caseValide(orig[0], orig[1])) {
                        Piece piece = echiquier.examinePiece(orig[0], orig[1]);

                        if (piece == null) {
                            System.out.println("Pas de piece a la case de depart");
                        } else if (piece.estBlanc() != blanc) {
                            System.out.println("Impossible de deplacer une piece ennemie");
                        } else if (piece.deplacementValide(dest[0], dest[1])) {
                            piece.deplace(dest[0], dest[1]);
                            break;
                        } else {
                            System.out.println("Case de destination invalide");
                        }
                    } else {
                        System.out.println("Case d'origine invalide");
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Mauvais format de coordonnees. Bon format : lettre (a-h) suivie du chiffre (1-8)");
                }
            } else {
                System.out.println("Ce n'est pas un deplacement valide");
            }
        } while(true);
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Parametre (ascii ou unicode) requis");
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

}
