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
        return super.deplacementValide(nouvelle_colonne, nouvelle_ligne)
                && (getColonne() == nouvelle_colonne || getLigne() == nouvelle_ligne);
    }

}
