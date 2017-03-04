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
        boolean ligne_valide;
        boolean colonne_valide = getColonne() == nouvelle_colonne;

        if (estBlanc()) {
            ligne_valide = nouvelle_ligne - getLigne() == 1;

            if (!estDeplace()) {
                ligne_valide = ligne_valide || nouvelle_ligne - getLigne() == 2;
            }
        } else {
            ligne_valide = nouvelle_ligne - getLigne() == -1;

            if (!estDeplace()) {
                ligne_valide = ligne_valide || nouvelle_ligne - getLigne() == -2;
            }
        }

        // Capture
        if (getEchiquier().examinePiece(nouvelle_colonne, nouvelle_ligne) != null) {
            colonne_valide = Math.abs(nouvelle_colonne - getColonne()) <= 1;
        }

        return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
               && ligne_valide && colonne_valide;
    }

}
