package chess;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public abstract class Piece {

    private boolean est_blanc, est_capture;
    private int colonne, ligne;
    private Echiquier echiquier;

    public boolean estBlanc() {
        return est_blanc;
    }

    public boolean estNoir() {
        return !est_blanc;
    }

    public boolean estCapture() {
        return est_capture;
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

    boolean deplacementValide(int nouvelle_colonne, int nouvelle_ligne) {
        return !est_capture
                && echiquier.caseValide(nouvelle_colonne, nouvelle_ligne);
        // && echiquier.examinePiece(nouvelle_colonne, nouvelle_ligne);
    }

    void deplace(int nouvelle_colonne, int nouvelle_ligne) {
        echiquier.prendsPiece(nouvelle_colonne, nouvelle_ligne);

        colonne = nouvelle_colonne;
        ligne = nouvelle_ligne;
        
        // echiquier.capturePiece();
        
        echiquier.posePiece(this);
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("Not supported yet.");
        // retournera une représentation sous fore de chaine de l'état de la piece (tous ses attributs à l'exception de l'echiquier)
    }
    
    abstract public String representationAscii();
    
    abstract public String representationUnicode();

}
