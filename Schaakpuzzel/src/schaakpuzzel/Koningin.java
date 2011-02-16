/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Koningin extends Stuk {

    public Koningin () {
        code=0;
    }

    public boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom){
    return
               stuk.getRij() == rij || stuk.getKolom() == kolom ||
               stuk.getRij() + stuk.getKolom() == rij + kolom ||
               stuk.getRij() + kolom == rij + stuk.getKolom();}
}

