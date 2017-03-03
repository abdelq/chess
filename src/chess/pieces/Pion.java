package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Pion extends Piece {

    public Pion(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
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
        // TODO Refactor
        if (!estDeplace()) {
            if (estNoir()) {
                return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                       && nouvelle_ligne - getLigne() >= -2
                       && getColonne() == nouvelle_colonne;
            }

            return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                   && nouvelle_ligne - getLigne() <= 2
                   && getColonne() == nouvelle_colonne;
        }

        if (estNoir()) {
            return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                   && Math.abs(nouvelle_colonne - getColonne()) == 1
                   && nouvelle_ligne - getLigne() >= -1;
        }

        return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
               && Math.abs(nouvelle_colonne - getColonne()) == 1
               && nouvelle_ligne - getLigne() <= 1;
    }

}
