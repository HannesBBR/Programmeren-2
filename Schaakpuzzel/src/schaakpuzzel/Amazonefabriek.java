/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Amazonefabriek implements Stukfabriek {

    public Stuk createStuk() {
        return new Amazone();
    }

}
