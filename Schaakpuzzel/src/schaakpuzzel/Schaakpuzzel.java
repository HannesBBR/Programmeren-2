package schaakpuzzel;
import java.util.HashMap;

public class Schaakpuzzel {

    /**
     * CreÃ«er een nieuw stuk aan de hand van de opgegeven code. Geef null terug
     * als er een foutieve code werd ingegeven.
     */
    private static Stuk decodeerLijn (String lijn) {
        if (lijn.length () != 3)
            return null;
        char kar = lijn.charAt(0);

        HashMap<Character,Stukfabriek> hm = new HashMap<Character,Stukfabriek>() ;
        hm.put('P', new Paardfabriek());
        hm.put('L',new Loperfabriek());
        hm.put('D',new Koninginfabriek());
        hm.put('T',new Torenfabriek());

        Stuk stuk = hm.get(kar).createStuk();

        int rij = lijn.charAt (2) - '1';
        int kol = lijn.charAt (1) - 'a';
        if (rij < 0 || rij > 7 || kol < 0 || kol > 7)
            return null;
        
        stuk.setRij (rij);
        stuk.setKolom (kol);
        return stuk;
    }

    /**
     * Hoofdprogramma: begint met een nieuw bord en laat de gebruiker
     * achtereenvolgens type en coÃ¶rdinaten van de stukken intikken. Drukt
     * telkens het nieuwe bord af. Het programma stopt zodra een stuk op een
     * positie wordt geplaatst die door een ander stuk wordt bedreigd.
     */
    public static void main (String[] args) {
        Lijnenlezer lezer = new Lijnenlezer ();
        System.out.println (
              "Probeer zoveel mogelijk stukken op het bord te zetten");
        System.out.println ("zonder dat ze elkaar slaan");
        Bord bord = new Bord();
        System.out.println (bord);
        System.out.print ("Zet> ");
        int aantal = 0;
        Stuk stuk = decodeerLijn (lezer.volgendeLijn ());
        while (stuk != null && bord.geldigePlaatsVoor (stuk)) {
            aantal++;
            bord.zet (stuk);
            System.out.println (bord);
            System.out.print ("Zet> ");
            stuk = decodeerLijn (lezer.volgendeLijn ());
        }
        System.out.println ("Aantal geplaatste stukken = " + aantal);
    }
}
