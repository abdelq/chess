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
        int delta_colonne = nouvelle_colonne - getColonne();
        int delta_ligne = nouvelle_ligne - getLigne();

        if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                && Math.abs(delta_colonne) == Math.abs(delta_ligne)) {
            int delta = Math.abs(delta_colonne);
            int dc = delta_colonne > 0 ? 1 : -1, dl = delta_ligne > 0 ? 1 : -1; // Direction (colonne, ligne)

            for (int i = 1; i < delta; i++) {
                if (getEchiquier().examinePiece(getColonne() + (i * dc), getLigne() + (i * dl)) != null) {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

}
