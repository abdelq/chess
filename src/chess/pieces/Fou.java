package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Fou extends Piece {

    public Fou (boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
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
        return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                && (nouvelle_colonne - getColonne() == nouvelle_ligne - getLigne());
    }

}
