import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.StringJoiner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Echiquier {

    private final Piece[][] tableau_de_jeu;
    private final Piece[] blancs_captures, noirs_captures;

    public boolean caseValide(int colonne, int ligne) {
        return colonne > -1 && colonne < 8 && ligne > -1 && ligne < 8;
    }

    public Piece examinePiece(int colonne, int ligne) {
        return tableau_de_jeu[colonne][ligne];
    }

    public Piece prendsPiece(int colonne, int ligne) {
        Piece piece = tableau_de_jeu[colonne][ligne];

        tableau_de_jeu[colonne][ligne] = null;

        return piece;
    }

    public void posePiece(Piece p) {
        tableau_de_jeu[p.getColonne()][p.getLigne()] = p;
    }

    public void capturePiece(int colonne, int ligne) {
        Piece piece = tableau_de_jeu[colonne][ligne];

        tableau_de_jeu[colonne][ligne] = null;
        piece.meSuisFaitCapture();

        // Ajout dans le tableau de pièces capturées
        if (piece.estBlanc()) {
            for (int i = 0; i < blancs_captures.length; i++) {
                if (blancs_captures[i] == null) {
                    blancs_captures[i] = piece;
                    break;
                }
            }
        } else {
            for (int i = 0; i < noirs_captures.length; i++) {
                if (noirs_captures[i] == null) {
                    noirs_captures[i] = piece;
                    break;
                }
            }
        }
    }

    private static String afficheCaptures(Piece[] pieces, boolean ascii) {
        StringJoiner captures = new StringJoiner(" ");

        for (Piece p : pieces) {
            if (p != null) {
                captures.add(ascii ? p.representationAscii() : p.representationUnicode());
            }
        }

        return captures.toString();
    }

    public void afficheAscii(Piece piece) {
        StringJoiner tableau = new StringJoiner(System.lineSeparator());

        tableau.add("Les noirs ont capture : " + afficheCaptures(blancs_captures, true));
        tableau.add("");
        tableau.add("   a b c d e f g h");
        tableau.add("   ― ― ― ― ― ― ― ―");

        for (int i = 7; i > -1; i--) {
            StringJoiner ligne = new StringJoiner(" ", (i + 1) + "| ", " |" + (i + 1));

            for (int j = 0; j < 8; j++) {
                Piece p = examinePiece(j, i);

                if (piece != null && piece.deplacementValide(j, i)) {
                    ligne.add("X");
                } else if (p != null) {
                    ligne.add(p.representationAscii());
                } else {
                    ligne.add(".");
                }
            }

            tableau.add(ligne.toString());
        }

        tableau.add("   ― ― ― ― ― ― ― ―");
        tableau.add("   a b c d e f g h");
        tableau.add("");
        tableau.add("Les blancs ont capture : " + afficheCaptures(noirs_captures, true));

        System.out.println(tableau);
    }

    public void afficheUnicode(Piece piece) throws UnsupportedEncodingException {
        PrintStream ps = new PrintStream(System.out, true, "UTF-8");
        StringJoiner tableau = new StringJoiner(System.lineSeparator());

        tableau.add("Les noirs ont capturé : " + afficheCaptures(blancs_captures, false));
        tableau.add("");
        tableau.add("   a   b   c   d   e   f   g   h");
        tableau.add(" ┌───┬───┬───┬───┬───┬───┬───┬───┐");

        for (int i = 7; i > -1; i--) {
            StringJoiner ligne = new StringJoiner(" │ ", (i + 1) + "│ ", " │" + (i + 1));

            for (int j = 0; j < 8; j++) {
                Piece p = examinePiece(j, i);

                if (piece != null && piece.deplacementValide(j, i)) {
                    ligne.add("X");
                } else if (p != null) {
                    ligne.add(p.representationUnicode());
                } else {
                    ligne.add(" ");
                }
            }

            tableau.add(ligne.toString());

            if (i > 0) {
                tableau.add(" ├───┼───┼───┼───┼───┼───┼───┼───┤");
            }
        }

        tableau.add(" └───┴───┴───┴───┴───┴───┴───┴───┘");
        tableau.add("   a   b   c   d   e   f   g   h");
        tableau.add("");
        tableau.add("Les blancs ont capturé : " + afficheCaptures(noirs_captures, false));

        ps.println(tableau);
    }

    public Echiquier() {
        tableau_de_jeu = new Piece[8][8];

        blancs_captures = new Piece[16];
        noirs_captures = new Piece[16];

        // Placement de pièces blanches
        tableau_de_jeu[4][0] = new Roi(true, 4, 0, this);
        tableau_de_jeu[3][0] = new Dame(true, 3, 0, this);
        tableau_de_jeu[0][0] = new Tour(true, 0, 0, this);
        tableau_de_jeu[7][0] = new Tour(true, 7, 0, this);
        tableau_de_jeu[2][0] = new Fou(true, 2, 0, this);
        tableau_de_jeu[5][0] = new Fou(true, 5, 0, this);
        tableau_de_jeu[1][0] = new Cavalier(true, 1, 0, this);
        tableau_de_jeu[6][0] = new Cavalier(true, 6, 0, this);

        // Placement de pièces noires
        tableau_de_jeu[4][7] = new Roi(false, 4, 7, this);
        tableau_de_jeu[3][7] = new Dame(false, 3, 7, this);
        tableau_de_jeu[0][7] = new Tour(false, 0, 7, this);
        tableau_de_jeu[7][7] = new Tour(false, 7, 7, this);
        tableau_de_jeu[2][7] = new Fou(false, 2, 7, this);
        tableau_de_jeu[5][7] = new Fou(false, 5, 7, this);
        tableau_de_jeu[1][7] = new Cavalier(false, 1, 7, this);
        tableau_de_jeu[6][7] = new Cavalier(false, 6, 7, this);

        // Placement de pions
        for (int i = 0; i < 8; i++) {
            tableau_de_jeu[i][1] = new Pion(true, i, 1, this);
            tableau_de_jeu[i][6] = new Pion(false, i, 6, this);
        }
    }

}
