package chess;

import chess.pieces.*;

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
        // TODO
        throw new UnsupportedOperationException("Afficher l'échiquier en utilisant des caractères ASCII.");
    }

    public void afficheUnicode() {
        // TODO
        throw new UnsupportedOperationException("Afficher l'échiquier en utilisant des caractères Unicode.");
    }

    public Echiquier() {
        // TODO add stuff to tableau
        tableau_de_jeu = new Piece[8][8];

        blancs_captures = new Piece[16];
        noirs_captures = new Piece[16];

        // Joueurs blancs
        new Roi(true, 4, 7, this);
        new Dame(true, 3, 7, this);
        new Tour(true, 0, 7, this);
        new Tour(true, 7, 7, this);
        new Fou(true, 2, 7, this);
        new Fou(true, 5, 7, this);
        new Cavalier(true, 1, 7, this);
        new Cavalier(true, 6, 7, this);

        for (int i = 0; i < 8; i++) {
            new Pion(true, i, 6, this);
        }

        // Joueurs noirs
        new Roi(false, 4, 0, this);
        new Dame(false, 3, 0, this);
        new Tour(false, 0, 0, this);
        new Tour(false, 7, 0, this);
        new Fou(false, 2, 0, this);
        new Fou(false, 5, 0, this);
        new Cavalier(false, 1, 0, this);
        new Cavalier(false, 6, 0, this);

        for (int i = 0; i < 8; i++) {
            new Pion(false, i, 1, this);
        }
    }

}
