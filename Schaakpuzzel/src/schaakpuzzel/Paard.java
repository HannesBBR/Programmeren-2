package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Paard extends Stuk {

    public Paard () {
        code=3;
    }


    public boolean stukBedreigtPositie (int rij, int kolom){
    int dr = getRij() - rij;
            int dk = getKolom() - kolom;
            return dr * dr + dk * dk == 5;  // [!] wiskundig truukje}
    }

    public char letterVoorStuk (){
      return 'P';
    }
}
