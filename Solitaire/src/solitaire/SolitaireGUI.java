package solitaire;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * GUI waarop een spelletje solitaire kan worden gespeeld.
 */
public class SolitaireGUI
        extends JPanel
        implements MouseListener {

    /**
     * Coordinaten van de geselecteerde knikker of negatief als er
     * niets is geselecteerd.
     */
    protected int row;

    protected int column;

    /**
     * Model van dit paneel.
     */
    SolitaireLogic model = null;

    /**
     * Creëer een nieuw paneel met het gegeven model.
     */
    public SolitaireGUI(SolitaireLogic model) {
        super(null);
        setPreferredSize(new Dimension(8 * 36, 8 * 36));
        this.model = model;
        model.setSolitaireGUI(this);
        addMouseListener(this);
        reset();
    }

    /**
     * Teken alles opnieuw aangezien het model is veranderd.
     */
    public void changed() {
        repaint();
    }

    /**
     * Breng het paneel terug naar zijn beginconfiguratie.
     */
    private void reset() {
        row = -1;
        column = -1;
        model.reset();
    }

    /**
     * Teken de inhoud van het paneel.
     */
    @Override
    public void paintComponent(Graphics g) {
        // Achtergrond
        super.paintComponent(g);

        // Knikkers
        for (int i = 0; i < 2; i++) {
            for (int j = 2; j < 5; j++) {
                paintMarble(i, j, g);
            }
        }
        for (int i = 2; i < 5; i++) {
            for (int j = 0; j < 7; j++) {
                paintMarble(i, j, g);
            }
        }
        for (int i = 5; i < 7; i++) {
            for (int j = 2; j < 5; j++) {
                paintMarble(i, j, g);
            }
        }

        // Selectie
        if (row >= 0 && column >= 0) {
            g.setColor(Color.white);
            g.drawRect(18 + 36 * column, 18 + 36 * row, 35, 35);
        }
    }

    /**
     * Prentjes
     */
    static final Icon marbleIcon = new ImageIcon(SolitaireGUI.class.getResource("/images/marble.gif"));

    static final Icon pitIcon = new ImageIcon(SolitaireGUI.class.getResource("/images/pit.gif"));

    /**
     * Teken één enkele knikker (of put)
     */
    private void paintMarble(int row, int column, Graphics g) {
        Icon icon =
                model.isMarble(row, column) ? marbleIcon : pitIcon;
        icon.paintIcon(this, g, 20 + 36 * column, 20 + 36 * row);
    }

    /**
     * Muisluisteraars.
     */
    public void mouseClicked(MouseEvent e) {
        int row1 = (e.getY() - 18) / 36;
        int column1 = (e.getX() - 18) / 36;

        // buiten het bord ?
        if (row1 < 0) {
            return;
        } else if (row1 < 2) {
            if (column1 < 2 || column1 > 4) {
                return;
            }
        } else if (row1 < 5) {
            if (column1 < 0 || column1 > 6) {
                return;
            }
        } else if (row1 < 7) {
            if (column1 < 2 || column1 > 4) {
                return;
            }
        } else {
            return;
        }

        // op oude plaats ?
        if (row1 == row && column1 == column) {
            row = -1;
            column = -1;
            repaint();
        } // niets aangeduid
        else if (row < 0) {
            if (model.isMarble(row1, column1)) {
                row = row1;
                column = column1;
                repaint();
            }
        } // geldige verplaatsing
        else {
            int row0 = row;
            int column0 = column;
            row = row1;
            column = column1;
            if (model.isValidMove(row0, column0, row1, column1)) {
                model.move(row0, column0, row1, column1);
            } else {
                repaint();
            }
        }
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    /**
     * Menu dat gebruikt wordt in de main-methode van SolPanel.
     */
    static class SolMenu
            extends JMenu
            implements ActionListener {

        /**
         * Paneel waarop dit menu betrekking heeft.
         */
        private SolitaireGUI panel;

        /**
         * Construeer een menu dat het opgegeven paneel be�nvloedt.
         */
        public SolMenu(SolitaireGUI panel) {
            this.panel = panel;

            ResourceBundle bundle = ResourceBundle.getBundle("solitaire/solitaire");

            /*
            Locale locale = new Locale ("nl", "BE");
            ResourceBundle bundle
            =  ResourceBundle.getBundle ("solitaire", locale);
             */

            setText(bundle.getString("game"));
            setMnemonic(bundle.getString("game_afk").charAt(0)
                    - 'A' + KeyEvent.VK_A);
            JMenuItem mnNieuw = new JMenuItem(bundle.getString("new"));
            mnNieuw.setMnemonic(bundle.getString("new_afk").charAt(0)
                    - 'A' + KeyEvent.VK_A);
            add(mnNieuw);
            mnNieuw.addActionListener(this);
        }

        /**
         * Reageer op de menu-optie 'Nieuw'.
         */
        public void actionPerformed(ActionEvent e) {
            panel.reset();
        }
    }

    public static void test() {
        main(new String[0]);
    }

    /**
     * Hoofdprogramma.
     */
    public static void main(String[] args) {
        JFrame window = new JFrame("Solitaire (c) 2011 KC");
        SolitaireLogic model = new SolitaireLogic();
        SolitaireGUI gui = new SolitaireGUI(model);
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(new SolMenu(gui));

        window.setJMenuBar(menuBar);
        window.setContentPane(gui);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }
}
