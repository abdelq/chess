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
        if (super.deplacementValide(nouvelle_colonne, nouvelle_ligne)) {
            if (getLigne() == nouvelle_ligne) {
                int direction = nouvelle_colonne > getColonne() ? 1 : -1;
                int delta = Math.abs(nouvelle_colonne - getColonne());

                for (int i = 1; i < delta; i++) {
                    if (getEchiquier().examinePiece(getColonne() + (i * direction), getLigne()) != null) {
                        return false;
                    }
                }

                return true;
            } else if (getColonne() == nouvelle_colonne) {
                int direction = nouvelle_ligne > getLigne() ? 1 : -1;
                int delta = Math.abs(nouvelle_ligne - getLigne());

                for (int i = 1; i < delta; i++) {
                    if (getEchiquier().examinePiece(getColonne(), getLigne() + (i * direction)) != null) {
                        return false;
                    }
                }

                return true;
            }
        }

        return false;
    }

}
