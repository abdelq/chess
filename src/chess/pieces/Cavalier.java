package chess.pieces;

import chess.Echiquier;
import chess.Piece;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Cavalier extends Piece {

    protected Cavalier(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
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

    @Override
    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        return (Math.abs(nouvelle_colonne - getColonne()) == 2 && Math.abs(nouvelle_ligne - getLigne()) == 1)
                || (Math.abs(nouvelle_colonne - getColonne()) == 1 && Math.abs(nouvelle_ligne - getLigne()) == 2);
    }

}
