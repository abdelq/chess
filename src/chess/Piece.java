package chess;

import java.util.StringJoiner;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public abstract class Piece {

    private final boolean est_blanc;
    private boolean est_capture, est_deplace;
    private int colonne, ligne;
    private final Echiquier echiquier;

    public boolean estBlanc() {
        return est_blanc;
    }

    public boolean estNoir() {
        return !est_blanc;
    }

    public boolean estCapture() {
        return est_capture;
    }

    public boolean estDeplace() {
        return est_deplace;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public Echiquier getEchiquier() {
        return echiquier;
    }

    protected Piece(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        this.est_blanc = est_blanc;
        this.est_capture = false;
        this.est_deplace = false;
        this.colonne = colonne;
        this.ligne = ligne;
        this.echiquier = echiquier;
    }

    public void meSuisFaitCapture() {
        est_capture = true;
    }

    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        if (echiquier.caseValide(nouvelle_colonne, nouvelle_ligne)) {
            Piece piece = echiquier.examinePiece(nouvelle_colonne, nouvelle_ligne);

            if (piece == null) {
                return !est_capture;
            }

            return !est_capture && piece.estBlanc() != est_blanc;
        }

        return false;
    }

    void deplace(int nouvelle_colonne, int nouvelle_ligne) {
        echiquier.prendsPiece(colonne, ligne);

        colonne = nouvelle_colonne;
        ligne = nouvelle_ligne;
        est_deplace = true;

        if (echiquier.examinePiece(colonne, ligne) != null) {
            echiquier.capturePiece(colonne, ligne);
        }

        echiquier.posePiece(this);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName()
               + new StringJoiner(",", "[", "]")
               .add("est_blanc=" + est_blanc)
               .add("est_capture=" + est_capture)
               .add("est_deplace=" + est_deplace)
               .add("colonne=" + colonne)
               .add("ligne=" + ligne)
               .toString();
    }

    public abstract String representationAscii();

    public abstract String representationUnicode();

}
