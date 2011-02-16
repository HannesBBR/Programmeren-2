/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package schaakpuzzel;

/**
 *
 * @author hannes
 */
public class Torenfabriek implements Stukfabriek {

    public Stuk createStuk() {
        return new Toren();
    }

}
