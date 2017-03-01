package chess;

import java.util.Scanner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class JeuEchec {

    public static void demandeTour(String joueur) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Joueur " + joueur + " ? ");

        // if invalid, call demandeTour again
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Paramètre requis");
        }

        Echiquier echiquier = new Echiquier();

        while (true) {
            demandeTour("Blanc");
        }
        // TODO Demander tour à tour à chaque joueur (en commençant par les blancs) d'indiquer le déplacement qu'ils veulent jouer
        // TODO Reste du document
        // TODO
    }

}
