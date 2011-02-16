package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Paard extends Stuk {

    public Paard () {
        code=3;
    }


    public boolean stukBedreigtPositie (Stuk stuk, int rij, int kolom){
    int dr = stuk.getRij() - rij;
            int dk = stuk.getKolom() - kolom;
            return dr * dr + dk * dk == 5;  // [!] wiskundig truukje}
    }

    public char letterVoorStuk (){
      return 'P';
    }
}
