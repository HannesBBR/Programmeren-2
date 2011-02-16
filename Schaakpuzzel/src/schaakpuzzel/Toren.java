/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Toren extends Stuk {

    public Toren () {
        this.code = 1;
    }

    public boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom){
    return stuk.getRij() == rij || stuk.getKolom() == kolom;}
}
