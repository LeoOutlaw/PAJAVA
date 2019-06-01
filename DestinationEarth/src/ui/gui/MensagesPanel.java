/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitAlienPhase;
import controllers.stats.AwaitAlliensPlacement;
import controllers.stats.AwaitCrewPhase;
import controllers.stats.AwaitRestPhase;
import controllers.stats.SetupMembers;
import controllers.stats.Turn;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class MensagesPanel extends JPanel implements Observer{
    ObservableGame game;
    
    MensagesPanel(ObservableGame g)
    {
        this.game = g;
        this.game.addObserver(this);
        update(null,this.game);
    }
    
     @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int y =20;
        
        
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
     
        g.setColor(Color.blue);
        
        /*for(int i=0; i<game.getCartasTotal() ; i++)
        {
            if(game.isCarta_visivel(i) ) //&& game.getState() instanceof AwaitCardSelect
            {
                for(String line : game.showGame().split("\n"))
                g.drawString(line, 5, y+=g.getFontMetrics().getHeight());
            }
        }
        */
        
        int thickness = 4;
        
        Graphics2D g2 = (Graphics2D)g;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g2.setStroke(oldStroke);
    }
    
    
    @Override
    public void update(Observable o, Object o1) {
        setVisible(game.getState() instanceof SetupMembers || game.getState() instanceof AwaitAlliensPlacement || game.getState() instanceof AwaitRestPhase || game.getState() instanceof Turn || game.getState() instanceof AwaitCrewPhase || game.getState() instanceof AwaitAlienPhase);
        revalidate();
        repaint();
    }
    
}