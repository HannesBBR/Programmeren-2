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
        code = 1;
    }

        public final char letter='T';

    public boolean stukBedreigtPositie (int rij, int kolom){
    return getRij() == rij || getKolom() == kolom;}

    public char letterVoorStuk (){
      return 'T';
    }
}
