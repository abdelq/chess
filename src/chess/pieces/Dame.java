package chess.pieces;

import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Dame extends Piece {

    @Override
    public String representationAscii() {
        return estBlanc() ? "D" : "d";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♕" : "♛";
    }

    boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
