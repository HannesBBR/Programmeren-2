/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Oefles1.Zadelpunt;

/**
 *
 * @author hannes
 */
public class Matrix {
    
    
    public static void main(String[] args){
        
        
        int[][] matrix= {{9,11,10,12,17},{5,1,9,8,7},{4,2,1,5,3},{3,5,4,7,2},{2,7,8,1,11}};
        int n=5;
        int kolomgrootste=0;
        
        for(int i=0;i<n-1;i++){

            for (int j=1;j<n-1;j++){
                if (matrix[i][j] > matrix[i][kolomgrootste]) kolomgrootste=j;            
            }   
      
        
        int rij=0;
        
            while (matrix[rij][kolomgrootste-1] >= matrix[i][kolomgrootste]) {
                if(rij==n) System.out.println("Zadelpunt gevonden!");
                rij++;break;
            }
         
        }
    }



}
