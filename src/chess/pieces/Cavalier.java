package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Cavalier extends Piece {

    protected Cavalier (boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        super(est_blanc, colonne, ligne, echiquier);
    }

    @Override
    public String representationAscii() {
        return estBlanc() ? "C" : "c";
    }

    @Override
    public String representationUnicode() {
        return estBlanc() ? "♘" : "♞";
    }

    boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        // TODO
        throw new UnsupportedOperationException("Redéfinir la méthodes deplacementValide");
    }

}
