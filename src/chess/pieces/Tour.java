package chess.pieces;

import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Tour extends Piece {

    @Override
    public String representationAscii() {
        return estBlanc() ? "T" : "t";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♖" : "♜";
    }

    boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
