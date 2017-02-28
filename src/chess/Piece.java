package chess;

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

    protected Piece(boolean est_blanc, int colonne, int ligne, Echiquier echiquier) {
        this.est_blanc = est_blanc;
        this.colonne = colonne;
        this.ligne = ligne;
        this.echiquier = echiquier;
        this.est_capture = false;
    }

    void meSuisFaitCapture() {
        est_capture = true;
    }

    public boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        return !est_capture
                && echiquier.caseValide(nouvelle_colonne, nouvelle_ligne)
                && echiquier.examinePiece(nouvelle_colonne, nouvelle_ligne).estBlanc() != est_blanc;
    }

    void deplace(int nouvelle_colonne, int nouvelle_ligne) {
        echiquier.prendsPiece(nouvelle_colonne, nouvelle_ligne);

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
        return est_blanc + " " + est_capture + " " + est_deplace + " " + colonne + " " + ligne;
    }

    public abstract String representationAscii();

    public abstract String representationUnicode();

}
