/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
/**
 * Schaakbord met stukken.
 */
public class Bord {

    /** De 64 stukken. */
    private Stuk[][] stukken;

    /**
     * Default constructor.
     */
    public Bord () {
        stukken = new Stuk[8][8];
    }


    /**
     * String-representatie van een bord.
     */
    public String toString () {
        String str = "   a b c d e f g h\n\n";
        for (int rij = 0; rij < 8; rij++) {
            str += rij + 1 + " ";
            for (int kol = 0; kol < 8; kol++) {
                str += " ";
                if (stukken[rij][kol] != null)
                    str += stukken[rij][kol].letterVoorStuk();
                else if ((rij + kol) % 2 == 0)
                    str += " ";
                else
                    str += ".";
            }
            str += "\n";
        }
        return str;
    }

    /**
     * Plaats het gegeven stuk op de gegeven plaats op het bord.
     */
    public void zet (Stuk stuk) {
        stukken[stuk.getRij ()][stuk.getKolom ()] = stuk;
    }
    

    /**
     * Is dit een geldige plaats voor het gegeven stuk? M.a.w., wordt het
     * niet door een ander stuk op het bord bedreigd of bedreigt het niet
     * zelf een ander stuk?
     */
    public boolean geldigePlaatsVoor (Stuk stuk) {
        int rij = stuk.getRij ();
        int kol = stuk.getKolom ();
        if (stukken[rij][kol] != null)
            return false;  // plaats reeds bezet
        for (int r = 0; r < 8; r++)
            for (int k = 0; k < 8; k++)
                if (stukken[r][k] != null)
                    if (stuk.stukBedreigtPositie(stukken[r][k], rij, kol) ||
                          stuk.stukBedreigtPositie(stuk, r, k))
                        return false;
        return true;
    }
}
