/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Oefles1.beroemd;


import java.util.ArrayList;
/**
 *
 * @author hannes
 */
public class Persoon {

    public ArrayList<Integer> gekendepersonen=new ArrayList();
    public int nummer;

    public Persoon(int nummer,Integer[] kent){
        this.nummer=nummer;
        for(int i=0;i<kent.length;i++){ this.gekendepersonen.add(kent[i]);}
    }

    public Persoon(int nummer){
        this.nummer=nummer;
        this.gekendepersonen=null;

    }

    public boolean kent(Persoon b){
        if (this.gekendepersonen.contains(b.nummer)) return true; else return false;
    }

    public String toString(){
        return "Persoon " + nummer + " ";

    }

    public static void main(String[] args){



        Persoon pers1 = new Persoon(1,new Integer[] {1});
        Persoon pers2 = new Persoon(2, new Integer[] {1,2,3});
        Persoon pers3 = new Persoon(3,new Integer[] {1,3});
        Persoon pers4 = new Persoon(4, new Integer[] {4});
        ArrayList<Persoon> lijst= new ArrayList<Persoon>();
        lijst.add(pers1);
        lijst.add(pers2);
        lijst.add(pers3);

        ArrayList<Persoon> kopielijst= new ArrayList<Persoon>();
        kopielijst.add(pers1);
        kopielijst.add(pers2);
        kopielijst.add(pers3);

        
        while(lijst.size()!=1){
            if(lijst.get(0).kent(lijst.get(1)))lijst.remove(0);else lijst.remove(1);
        }

        int teller1=0;
        int teller2=0;

        for(int i=1;i<kopielijst.size();i++){
            if (lijst.get(0).kent(kopielijst.get(i))) teller1++;
        }

        for(int i=1;i<kopielijst.size();i++){
            if (kopielijst.get(i).kent(lijst.get(0))) teller2++;
        }

        if(teller1==1 && teller2==kopielijst.size()-1) System.out.println(lijst.get(0)+ " is een beroemd persoon!");
        else System.out.println("Er is geen bekend persoon!\n"); System.out.println(teller1);

        System.out.println(lijst);

    }

}
