package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Tour extends Piece {

    public Tour(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        super(est_blanc, colonne, ligne, echiquier);
    }

    @Override
    public String representationAscii() {
        return estBlanc() ? "T" : "t";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♖" : "♜";
    }

    @Override
    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        boolean ln = getLigne() == nouvelle_ligne;
        if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                && (getColonne() == nouvelle_colonne || ln)) {
            int step = ln ? (nouvelle_colonne > getColonne() ? 1 : -1) : (nouvelle_ligne > getLigne() ? 1 : -1);
            int delta = Math.abs(ln ? nouvelle_colonne - getColonne() : nouvelle_ligne - getLigne());
            for (int c = 1; c < delta; c++) {
                if ((ln && getEchiquier().examinePiece(getColonne() + c * step, getLigne()) != null)
                        || (!ln && getEchiquier().examinePiece(getColonne(), getLigne() + c * step) != null)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
