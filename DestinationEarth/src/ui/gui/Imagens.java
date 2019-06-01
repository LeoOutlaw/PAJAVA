/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitNewCrewMember;
import java.awt.Dimension;
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
class Imagens extends JPanel implements Observer {

    ObservableGame game;
    String imageFiles[] = {"imagens/Doctor.jpg", "imagens/Captain.jpg", "imagens/Commander.jpg", "imagens/Comm'sOfficer.jpg" ,"imagens/Engineer.jpg", "imagens/MoralOfficer.jpg", "imagens/NavigationOfficer.jpg", "imagens/RedShirt.jpg", "imagens/ScienceOfficer.jpg", "imagens/SecurityOfficer.jpg", "imagens/ShuttlePilot.jpg", "imagens/TransporterChief.jpg"};
    Image imagem[] = new Image[imageFiles.length];
    Image imagem2[] = new Image[imageFiles.length];
    boolean loaded = false;
    int a;

    Imagens(ObservableGame g, int i) {
        a = i;
        this.game = g;
        game.addObserver(this);

        setPreferredSize(new Dimension(180, 270));

    }

    Image getImagem(ObservableGame game, int i) {

        if (!loaded) {
            int j = 0;
            loaded = true;
            for (String fileName : imageFiles) {
                try {
                    imagem[j++] = ImageIO.read(Resources.getResourceFile(fileName));
                } catch (IOException ex) {
                }

            }
        }

        return imagem[i];
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(getImagem(game, a), 0, 0, (getWidth()) - 1, (getHeight()) - 1, null);

    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(game.getState() instanceof AwaitNewCrewMember);
        repaint();
    }

}
