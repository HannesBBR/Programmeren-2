package solitaire;

/**
 * Logica voor de toepassing 'Solitaire'. 
 * Houdt bij op welke plaatsen
 * er zich een knikker bevindt en op welke niet. 
 * Bevat een aantal hulpfuncties waarmee de spelregels 
 * kunnen worden nagegaan.
 */
public class SolitaireLogic {


    protected SolitaireGUI gui;
    boolean[][] matrix= {{true,true,true,true,true,true,true},{true,true,true,true,true,true,true},{true,true,true,true,true,true,true},{true,true,true,false,true,true,true},{true,true,true,true,true,true,true},{true,true,true,true,true,true,true},{true,true,true,true,true,true,true}};


    /**
     * Registreert de opgegeven SolitaireGUI bij dit model. 
     * Deze SolitaireGUI moet op de hoogte worden gehouden van
     * ELKE verandering aan deze SolitaireLogic klasse. 
     */
    public void setSolitaireGUI(SolitaireGUI gui) {
        this.gui=gui;
    }
            
    /**
     * Staat er een knikker op de aangeduide plaats ?
     * Wordt enkel opgeroepen met 0 <= row <= 6 EN
     * 0 <= column <= 6 ; controle is niet nodig !
     * @param row Rijnummer (0 tem. 6)
     * @param column Kolomnummer (0 tem. 6)
     */
    public boolean isMarble(int row, int column) {
      return matrix[row][column];
    }
    
    /**
     * Stel de knikkers in op hun beginconfiguratie:
     * <pre>
     *          X X X
     *          X X X
     *      X X X X X X X
     *      X X X   X X X
     *      X X X X X X X
     *          X X X
     *          X X X
     * </pre>
     */
    public void reset() {

        for(int i=0;i<7;i++){
            for(int j=0;j<7;j++){
                matrix[i][j]=true;
            }
        }
        matrix[3][3]=false;
    }
    
    /* ============================================================
       Zetten
       ============================================================ */
    
    /**
     * Is het volgens de spelregels toegelaten om een knikker van de
     * eerste naar de tweede plaats te brengen ?
     * Wordt enkel opgeroepen met posities (row1, column1) en (row2, column2)
     * die op het bord voorkomen !
     */
    public boolean isValidMove(int row1, int column1, int row2, int column2) {
       if(matrix[row1][column1]&& !(matrix[row2][column2])&& matrix[(row1+row2)/2][(column1+column2)/2])return true;
       return false;
    }
    
    /**
     * Verplaats de knikker van de eerste naar de tweede positie en
     * neem de tussenliggende knikker weg. Wordt enkel opgeroepen
     * wanneer {@link #isValidMove} true gaf.
     */
    public void move(int row1, int column1, int row2, int column2) {
        if(isValidMove(row1,column1,row2,column2))
            {
            matrix[row1][column1]=false;
            matrix[row2][column2]=true;
            matrix[(row1+row2)/2][(column1+column2)/2]=false;
            }
    }
    
}
