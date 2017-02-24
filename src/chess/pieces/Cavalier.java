package chess.pieces;

import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Cavalier extends Piece {

    @Override
    public String representationAscii() {
        return estBlanc() ? "C" : "c";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♘" : "♞";
    }

    boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
