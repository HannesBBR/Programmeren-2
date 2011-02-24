/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Oefles1.Kazerne;

/**
 *
 * @author hannes
 */
public class Main {


    public static void main(String[] args){

        Kazerne[] kazernelijst={new Kazerne("Antwerpen",5,5), new Kazerne("Brugge", 10,-10),new Kazerne("Brussel",5,-5)};
        Kazerne huidige= kazernelijst[0];
        int Xp = 7;
        int Yp = 100;
        double afstand = Math.pow(huidige.getX()- Xp,2) - Math.pow(huidige.getY() - Yp, 2);

        for(int i=0;i<kazernelijst.length;i++){
           double tempafstand = Math.pow(kazernelijst[i].getX()-Xp,2) - Math.pow(kazernelijst[i].getY()-Yp,2);
           if (tempafstand < afstand) {afstand=tempafstand;huidige=kazernelijst[i];}

        }

        System.out.println(huidige);
    }

}
