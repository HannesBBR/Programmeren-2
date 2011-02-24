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
public class Sorteer {   
    
    
    public static void main(String[] args) throws IOException{
        
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String woord="";
        ArrayList<String> woorden= new ArrayList();
        
        while(!woord.equals("STOP")){
            woord=in.readLine();
            woorden.add(woord);
              
        }
        woorden.remove("STOP");
        String[] woorden2= new String[woorden.size()];

        
        for(int i=0;i<woorden.size();i++){
            woorden2[i]=woorden.get(i);
        }
        java.util.Arrays.sort(woorden2);
        
        System.out.println("Voor sortering\n" + woorden + "\n");
        System.out.println("Na sortering");
        for(int i=0;i<woorden2.length;i++){
            System.out.println(woorden2[i]+" ");
            
        }
        
        
        
    }


}
