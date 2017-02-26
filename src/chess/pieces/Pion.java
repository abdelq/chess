package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Pion extends Piece {

    public Pion (boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        super(est_blanc, colonne, ligne, echiquier);
    }

    @Override
    public String representationAscii() {
        return estBlanc() ? "P" : "p";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♙" : "♟";
    }

    @Override
    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        // TODO Mouvement pour capturer une pièce + mouvement de 2 cases de départ
        return Math.abs(nouvelle_colonne - getColonne()) == 1;
    }

}
