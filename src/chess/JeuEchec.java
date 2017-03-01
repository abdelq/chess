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

    public static void demandeTour(String joueur) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Joueur " + joueur + " ? ");

        String[] deplacements = scan.nextLine().split(" ");
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Paramètre requis");
        }

        Echiquier echiquier = new Echiquier();

        while (true) {
            afficheEchiquier(echiquier, args[0]);
            demandeTour("Blanc");

            afficheEchiquier(echiquier, args[0]);
            demandeTour("Noir");
        }
    }

}
