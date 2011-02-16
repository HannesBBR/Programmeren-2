/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Loper extends Stuk {

    public Loper () {
        this.code = 2;
    }

    public boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom){
    return
               stuk.getRij() + stuk.getKolom() == rij + kolom ||
               stuk.getRij() + kolom == rij + stuk.getKolom();}
}
