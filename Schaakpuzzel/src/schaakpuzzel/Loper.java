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
        code = 2;
    }


    public boolean stukBedreigtPositie (int rij, int kolom){
    return
               getRij() + getKolom() == kolom ||
               getRij() + kolom == rij + getKolom();

    }

    public char letterVoorStuk (){
      return 'L';
    }
}
