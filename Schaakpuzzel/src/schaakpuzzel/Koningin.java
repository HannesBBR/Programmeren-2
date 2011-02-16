package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Koningin extends Stuk {


    public Koningin () {
        code=0;
        
    }

    public boolean stukBedreigtPositie (int rij, int kolom){
    return
               getRij() == rij || getKolom() == kolom ||
               getRij() + getKolom() == rij + kolom ||
               getRij() + kolom == rij + getKolom();}

    public char letterVoorStuk (){
      return 'D';
    }

}

