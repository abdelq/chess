package chess;

/**
 * @author Léo Jetzer
 * @author Abdelhakim Qbaich
 */
public class Echiquier {

    private final Piece[][] tableau_de_jeu;
    private final Piece[] blancs_captures, noirs_captures;

    public boolean caseValide(int colonne, int ligne) {
        return colonne >= 0 && colonne <= 7 && ligne >= 0 && ligne <= 7;
    }

    public Piece examinePiece(int colonne, int ligne) {
        return tableau_de_jeu[colonne][ligne];
    }

    public Piece prendsPiece(int colonne, int ligne) {
        // TODO
        throw new UnsupportedOperationException("Semblable à la méthode examinePiece mais qui en plus 'enlève' la pièce du tableau_de_jeu en mettant sa case à null.");
    }

    public void posePiece(Piece p) {
        tableau_de_jeu[p.getColonne()][p.getLigne()] = p;
    }

    public void capturePiece(int colonne, int ligne) {
        // TODO
        throw new UnsupportedOperationException("Semblable à la méthode prendsPiece mais qui en plus l'ajoute dans le bon tableau de pièces capturées.");
    }

    public void afficheAscii() {
        // TODO
        throw new UnsupportedOperationException("Afficher l'échiquier en utilisant des caractères ASCII.");
    }

    public void afficheUnicode() {
        // TODO
        throw new UnsupportedOperationException("Afficher l'échiquier en utilisant des caractères Unicode.");
    }
    
    public Echiquier() {
        tableau_de_jeu = new Piece[8][8];

        // TODO À optimiser
        blancs_captures = new Piece[16];
        noirs_captures = new Piece[16];

        // TODO Créer et ajouter les pièces à leur position de départ
    }

}
