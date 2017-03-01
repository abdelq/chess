package chess;

import chess.pieces.*;
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

    public void afficheAscii() {
        StringJoiner board = new StringJoiner(System.lineSeparator());
        
        board.add("   a b c d e f g h");
        board.add("   ― ― ― ― ― ― ― ―");
        
        for (int i = 0; i < 8; i++) {
            StringJoiner row = new StringJoiner(" ", i + "| ", " |" + i);

            for (int j = 0; j < 8; j++) {
                Piece piece = examinePiece(j, i);
                
                if (piece != null) {
                    row.add(piece.representationAscii());
                } else {
                    row.add(".");
                }
            }

            board.add(row.toString());
        }
        
        board.add("   ― ― ― ― ― ― ― ―");
        board.add("   a b c d e f g h");
        
        System.out.println(board);
    }

    public void afficheUnicode() {
        StringJoiner board = new StringJoiner(System.lineSeparator());
        
        board.add("   a   b   c   d   e   f   g   h");
        board.add(" ┌───┬───┬───┬───┬───┬───┬───┬───┐");
        
        for (int i = 0; i < 8; i++) {
            StringJoiner row = new StringJoiner(" │ ", i + "│ ", " │" + i);

            for (int j = 0; j < 8; j++) {
                Piece piece = examinePiece(j, i);
                
                if (piece != null) {
                    row.add(piece.representationUnicode());
                } else {
                    row.add(" ");
                }
            }

            board.add(row.toString());

            if (i < 7) {
                board.add(" ├───┼───┼───┼───┼───┼───┼───┼───┤");
            }
        }
        
        board.add(" └───┴───┴───┴───┴───┴───┴───┴───┘");
        board.add("   a   b   c   d   e   f   g   h");
        
        System.out.println(board);
    }

    public Echiquier() {
        tableau_de_jeu = new Piece[8][8];

        blancs_captures = new Piece[16];
        noirs_captures = new Piece[16];

        // Placement de pièces blanches
        tableau_de_jeu[4][7] = new Roi(true, 4, 7, this);
        tableau_de_jeu[3][7] = new Dame(true, 3, 7, this);
        tableau_de_jeu[0][7] = new Tour(true, 0, 7, this);
        tableau_de_jeu[7][7] = new Tour(true, 7, 7, this);
        tableau_de_jeu[2][7] = new Fou(true, 2, 7, this);
        tableau_de_jeu[5][7] = new Fou(true, 5, 7, this);
        tableau_de_jeu[1][7] = new Cavalier(true, 1, 7, this);
        tableau_de_jeu[6][7] = new Cavalier(true, 6, 7, this);

        // Placement de pièces noires
        tableau_de_jeu[4][0] = new Roi(false, 4, 0, this);
        tableau_de_jeu[3][0] = new Dame(false, 3, 0, this);
        tableau_de_jeu[0][0] = new Tour(false, 0, 0, this);
        tableau_de_jeu[7][0] = new Tour(false, 7, 0, this);
        tableau_de_jeu[2][0] = new Fou(false, 2, 0, this);
        tableau_de_jeu[5][0] = new Fou(false, 5, 0, this);
        tableau_de_jeu[1][0] = new Cavalier(false, 1, 0, this);
        tableau_de_jeu[6][0] = new Cavalier(false, 6, 0, this);

        // Placement de pions
        for (int i = 0; i < 8; i++) {
            tableau_de_jeu[i][6] = new Pion(true, i, 6, this);
            tableau_de_jeu[i][1] = new Pion(false, i, 1, this);
        }
    }

}
