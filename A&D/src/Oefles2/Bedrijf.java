/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Oefles2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;



/**
 *
 * @author hannes
 */
public class Bedrijf implements Comparable<Bedrijf> {

    private String naam;
    private int postcode;

    public Bedrijf(String naam, int postcode){
        this.naam=naam;
        this.postcode=postcode;
    }

    @Override
    public String toString(){
        return naam + " " + postcode;

    }

    public int compareTo(Bedrijf o) {
        return this.naam.compareToIgnoreCase(o.naam);
    }

    public static void main(String[] args) throws IOException{

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String lijn="";
        ArrayList<Bedrijf> lijst= new ArrayList<Bedrijf>();
        Bedrijf[] lijst2=new Bedrijf[2];


        while(!(lijst.size()==2)){

            lijn=in.readLine();
            Bedrijf bed= new Bedrijf(lijn.substring(0,lijn.indexOf(" ")),(int)Integer.parseInt(lijn.substring(lijn.indexOf(" ")+1)));
            lijst.add(bed);
            
        }
        System.out.println(lijst);

        for(int i=0;i<2;i++){
            lijst2[i]=lijst.get(i);
        }

        java.util.Arrays.sort(lijst2);

        for(int i=0;i<lijst2.length;i++){
            System.out.println(lijst2[i] +" ");
            
        }

    }


}
