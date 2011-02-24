/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Oefles1.Kazerne;

/**
 *
 * @author hannes
 */
public class Kazerne {

    private String naam;
    private int x;
    private int y;

    public Kazerne(String naam, int x, int y){
        this.naam=naam;
        this.x=x;
        this.y=y;

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public String getNaam(){

        return naam;
    }

    public String toString(){
        return naam+": " + x +"," + y;
    }
}
