package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Fou extends Piece {

    public Fou(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        super(est_blanc, colonne, ligne, echiquier);
    }

    @Override
    public String representationAscii() {
        return estBlanc() ? "F" : "f";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♗" : "♝";
    }

    @Override
    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        int dc = nouvelle_colonne - getColonne(), dl = nouvelle_ligne - getLigne();
        if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                && Math.abs(dc) == Math.abs(dl)) {
            int delta = Math.abs(dc);
            int sc = dc < 0 ? -1 : 1, sl = dl < 0 ? -1 : 1;
            for (int i = 1; i < delta; i++)
                if (getEchiquier().examinePiece(getColonne() + i*sc, getLigne() + i*sl) != null)
                    return false;
            return true;
        }
        return false;
    }

}
