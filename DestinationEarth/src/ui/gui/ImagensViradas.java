/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitNewCrewMember;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
class ImagensViradas extends JPanel implements Observer{
    
    ObservableGame game;
    static final String imageFiles = "imagens/virada.jpg";
     static Image carta;
    int i;
    static boolean loaded=false;
    
    ImagensViradas(ObservableGame g)
    {
        this.game = g;
         this.game.addObserver(this);
        
        update(null,this.game);
       
    }
    
    Image getImagem(ObservableGame game)
    {

       if(!loaded){
           
           loaded=true;
           
               try {
            carta = ImageIO.read(Resources.getResourceFile(imageFiles));
            } catch (IOException ex) {
            }
       }
       
       return carta;
    }

     @Override
     public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        
       g.drawImage(getImagem(game),0,0,(getWidth())-1,(getHeight())-1,null);
       
    }
    @Override
    public void update(Observable o, Object o1) {

       setVisible(game.getState() instanceof AwaitNewCrewMember);
    }
    
}