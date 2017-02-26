package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Roi extends Piece {

    public Roi(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        super(est_blanc, colonne, ligne, echiquier);
    }

    @Override
    public String representationAscii() {
        return estBlanc() ? "R" : "r";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♔" : "♚";
    }

    @Override
    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                && (Math.abs(nouvelle_colonne - getColonne()) <= 1)
                && (Math.abs(nouvelle_ligne - getLigne()) <= 1);
    }

}
