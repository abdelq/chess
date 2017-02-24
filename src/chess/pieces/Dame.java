package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Dame extends Piece {

    protected Dame (boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        super(est_blanc, colonne, ligne, echiquier);
    }

    @Override
    public String representationAscii() {
        return estBlanc() ? "D" : "d";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♕" : "♛";
    }

    boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        // TODO
        throw new UnsupportedOperationException("Redéfinir la méthodes deplacementValide");
    }

}
