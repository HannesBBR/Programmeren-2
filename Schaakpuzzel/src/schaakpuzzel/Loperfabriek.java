/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Loperfabriek implements Stukfabriek {

    public Stuk createStuk() {
        return new Loper();
    }

}
