
package Mindgame;

import javax.swing.Timer;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JToggleButton;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hannes
 */
public class MindFrame extends JFrame {


    public static final ArrayList<Integer> lijst = new ArrayList();

    Timer timer;
    protected HashMap<String,JToggleButton> namenmap= new HashMap();
    protected HashMap<JToggleButton,String> knoppenmap= new HashMap();
    protected ArrayList<JToggleButton> knoppen= new ArrayList();
    protected ArrayList<String> geselecteerden= new ArrayList();

    public static Icon getIcon (String naam) {
        return new ImageIcon
            (MindFrame.class.getResource ("/figuren/" +naam));
    }

   

  public void methode(){

       if(geselecteerden.size()==1)geselecteerden.clear();

       for(int i=0;i<knoppen.size();i++){
           if(knoppen.get(i).isSelected())
           {geselecteerden.add(knoppenmap.get(knoppen.get(i)));System.out.println(geselecteerden);
            System.out.println(knoppen.size());}
           
           if(geselecteerden.size()==2){
               if(geselecteerden.get(0).equals(geselecteerden.get(1))){

                    /*for(int j=0;i<knoppen.size();j++){

                    if(knoppen.get(j).equals(namenmap.get(geselecteerden.get(0))))knoppen.get(j).setEnabled(false);
                    }
                    geselecteerden.clear();*/
               }
               else
                {for(JToggleButton t : knoppen){t.setSelected(false);}geselecteerden.clear();
               }
               
           }
       }
   }

    static private String[] prentjes= {"appel","aardbei","banaan","peer","broccoli","druiven","ajuin","meloen"};

    public MindFrame(){
       Container cp = this.getContentPane();
       cp.setLayout(new GridLayout(4,4));
       

       for(int i=0;i<8;i++){
       lijst.add(i);
       lijst.add(i);
       }
       
       for(int i=0;i<16;i++){
           Random randomgenerator=new Random();
           int random=randomgenerator.nextInt(lijst.size());
           JToggleButton but= new JToggleButton();
           but.setIcon(getIcon("unknown.jpg"));
           but.setDisabledIcon(getIcon("unknown.jpg"));
           but.setSelectedIcon(getIcon(prentjes[lijst.get(random)]+".jpg"));
           but.addActionListener(new Mylistener(this));
           knoppenmap.put(but,prentjes[lijst.get(random)]);
           namenmap.put(prentjes[lijst.get(random)], but);
           cp.add(but);
           knoppen.add(but);
           lijst.remove(random);
        }

       this.pack();
       this.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
       this.setVisible (true);

       /*ActionListener actionListener = new ActionListener(){
                public void actionPerformed(ActionEvent actionevent){
                   for(JToggleButton t : knoppen){t.setSelected(false);}}};

       timer = new Timer(3000,actionListener);*/

    }



    public static void main(String[] args){
       MindFrame frame= new MindFrame();
    }



}
