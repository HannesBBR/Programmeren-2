package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Amazone extends Stuk {


    public Amazone () {
        code=0;

    }

    public boolean stukBedreigtPositie (int rij, int kolom){
            int dr = getRij() - rij;
            int dk = getKolom() - kolom;
    return
               (getRij() == rij || getKolom() == kolom ||
               getRij() + getKolom() == rij + kolom ||
               getRij() + kolom == rij + getKolom()
               ||
               dr * dr + dk * dk == 5);  // [!] wiskundig truukje})
               }


    public char letterVoorStuk (){
      return 'A';
    }
}

