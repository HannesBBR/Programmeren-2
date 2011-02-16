/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;


/**
 * Schaakstuk
 */
public abstract class Stuk {

    /** Code die aangeeft over welk type schaakstuk het gaat:
     *  0: dame, 1: toren, 2: loper, 3: paard
     */
    static int code;

    /**
     * De overeenkomstige code van dit stuk
     *  0: dame, 1: toren, 2: loper, 3: paard
     */
    public int getCode () {
        return code;
    }

    /**
     * Maak een stuk met een gegeven code.
     */

    /** Rijpositie. */
    private int rij;

    /**
     * Rijpositie van dit stuk.
     */
    public int getRij () {
        return rij;
    }

    /**
     * Stel de rijpositie van dit stuk in.
     */
    public void setRij (int rij) {
        this.rij = rij;
    }

    /** Kolompositie. */
    protected int kolom;

    /**
     * Kolompositie van dit stuk.
     */
    public int getKolom () {
        return kolom;
    }

    /**
     * Stel de kolompositie van dit stuk in.
     */
    public void setKolom (int kolom) {
        this.kolom = kolom;
    }

    abstract boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom);
}