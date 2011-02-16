/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Paard extends Stuk {

    public Paard () {
        this.code=3;
    }

    public boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom){
    int dr = stuk.getRij() - rij;
            int dk = stuk.getKolom() - kolom;
            return dr * dr + dk * dk == 5;  // [!] wiskundig truukje}
    }
}
