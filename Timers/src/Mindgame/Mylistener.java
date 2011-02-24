/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Mindgame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;

/**
 *
 * @author hannes
 */

public class Mylistener implements ActionListener{

    MindFrame frame;

    public Mylistener(MindFrame frame){
        super();
        this.frame=frame;
    }

    public void actionPerformed(ActionEvent e){
        JToggleButton button = (JToggleButton)e.getSource();
        frame.methode();
    }


}
