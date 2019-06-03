/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.*;
import information.Members.Members;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class CharacterStatsPanel extends JPanel implements Observer {

    ObservableGame game;
    String imageFiles[] = {"imagens/PlayerBoard.jpg", "imagens/Blue.jpg", "imagens/Yellow.jpg", "imagens/Orange.jpg", "imagens/Black.png", "imagens/Green.jpg", "imagens/White.jpg", "imagens/Doctor.jpg", "imagens/Captain.jpg", "imagens/Commander.jpg", "imagens/Comm'sOfficer.jpg", "imagens/Engineer.jpg", "imagens/MoralOfficer.jpg", "imagens/NavigationOfficer.jpg", "imagens/RedShirt.jpg", "imagens/ScienceOfficer.jpg", "imagens/SecurityOfficer.jpg", "imagens/ShuttlePilot.jpg", "imagens/TransporterChief.jpg", "imagens/Purple.png", "imagens/Red.jpg"};
    Image imagem[] = new Image[imageFiles.length];
    boolean loaded = false;

    CharacterStatsPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        setVisible(game.getState() instanceof SetupMembers);
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
        int height = getHeight();
        int width = getWidth();
        int width_image = 700;
        int height_image = 1050;
        int y_gold_inicial = 310;
        int j = 0;

        int x = (width_image * height) / height_image;

        super.paintComponent(g);

        g.drawImage(getImagem(game, 0), 0, 0, x, (getHeight()) - 1, null);
        g.drawRect(0, 0, x, (getHeight()) - 1);

        //desenhar pino armor
        if (game.getHp() == 1) {
            g.drawImage(getImagem(game, 1), 370, 42, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 2) {
            g.drawImage(getImagem(game, 1), 370, 76, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 3) {
            g.drawImage(getImagem(game, 1), 370, 110, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 4) {
            g.drawImage(getImagem(game, 1), 370, 144, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 5) {
            g.drawImage(getImagem(game, 1), 370, 178, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 6) {
            g.drawImage(getImagem(game, 1), 370, 212, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 7) {
            g.drawImage(getImagem(game, 1), 415, 45, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 8) {
            g.drawImage(getImagem(game, 1), 415, 76, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 9) {
            g.drawImage(getImagem(game, 1), 415, 110, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 10) {
            g.drawImage(getImagem(game, 1), 415, 144, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 11) {
            g.drawImage(getImagem(game, 1), 415, 178, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getHp() == 12) {
            g.drawImage(getImagem(game, 1), 415, 212, x / 20, ((getHeight() / 25)) - 1, null);
        }

        // Inspiration Points
        if (game.getIp() == 0) {
            g.drawImage(getImagem(game, 2), 23, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 1) {
            g.drawImage(getImagem(game, 2), 57, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 2) {
            g.drawImage(getImagem(game, 2), 89, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 3) {
            g.drawImage(getImagem(game, 2), 120, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 4) {
            g.drawImage(getImagem(game, 2), 150, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 5) {
            g.drawImage(getImagem(game, 2), 183, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 6) {
            g.drawImage(getImagem(game, 2), 215, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 7) {
            g.drawImage(getImagem(game, 2), 245, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 8) {
            g.drawImage(getImagem(game, 2), 278, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 9) {
            g.drawImage(getImagem(game, 2), 310, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 10) {
            g.drawImage(getImagem(game, 2), 343, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 11) {
            g.drawImage(getImagem(game, 2), 375, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }
        if (game.getIp() == 12) {
            g.drawImage(getImagem(game, 2), 407, 300, x / 20, ((getHeight() / 25)) - 1, null);
        }

        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                if (game.getMember().get(i).getName().equalsIgnoreCase("Doctor")) {
                    g.drawImage(getImagem(game, 7), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("Captain")) {
                    g.drawImage(getImagem(game, 8), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("Commander")) {
                    g.drawImage(getImagem(game, 9), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("CommsOfficer")) {
                    g.drawImage(getImagem(game, 10), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("Engineer")) {
                    g.drawImage(getImagem(game, 11), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("MoralOfficer")) {
                    g.drawImage(getImagem(game, 12), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("NavigationOfficer")) {
                    g.drawImage(getImagem(game, 13), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("RedShirt")) {
                    g.drawImage(getImagem(game, 14), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("ScienceOfficer")) {
                    g.drawImage(getImagem(game, 15), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("SecurityOfficer")) {
                    g.drawImage(getImagem(game, 16), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("ShuttlePilot")) {
                    g.drawImage(getImagem(game, 17), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("TransporterChief")) {
                    g.drawImage(getImagem(game, 18), 0, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                }
            } else {
                if (game.getMember().get(i).getName().equalsIgnoreCase("Doctor")) {
                    g.drawImage(getImagem(game, 7), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("Captain")) {
                    g.drawImage(getImagem(game, 8), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("Commander")) {
                    g.drawImage(getImagem(game, 9), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("CommsOfficer")) {
                    g.drawImage(getImagem(game, 10), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("Engineer")) {
                    g.drawImage(getImagem(game, 11), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("MoralOfficer")) {
                    g.drawImage(getImagem(game, 12), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("NavigationOfficer")) {
                    g.drawImage(getImagem(game, 13), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("RedShirt")) {
                    g.drawImage(getImagem(game, 14), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("ScienceOfficer")) {
                    g.drawImage(getImagem(game, 15), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("SecurityOfficer")) {
                    g.drawImage(getImagem(game, 16), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("ShuttlePilot")) {
                    g.drawImage(getImagem(game, 17), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                } else if (game.getMember().get(i).getName().equalsIgnoreCase("TransporterChief")) {
                    g.drawImage(getImagem(game, 18), x / (3) + 32, 0, x / (3) + 30, ((getHeight() / 3)) + 30, null);
                }
            }
        }

        game.setupMembers();

        for (int i = 0; i < game.getMember().size(); i++) {
            if (i == 0) {
                switch (game.getMember().get(0).getMovement()) {
                    case 1:
                        g.drawImage(getImagem(game, 19), 50, 60, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 2:
                        g.drawImage(getImagem(game, 19), 80, 60, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 3:
                        g.drawImage(getImagem(game, 19), 115, 60, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    default:
                        break;
                }
                switch (game.getMember().get(0).getAttack()) {
                    case 1:
                        g.drawImage(getImagem(game, 19), 50, 115, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 2:
                        g.drawImage(getImagem(game, 19), 80, 115, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 3:
                        g.drawImage(getImagem(game, 19), 110, 115, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    default:
                        break;
                }

            } else {
                switch (game.getMember().get(1).getMovement()) {
                    case 1:
                        g.drawImage(getImagem(game, 20), 235, 60, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 2:
                        g.drawImage(getImagem(game, 20), 265, 60, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 3:
                        g.drawImage(getImagem(game, 20), 295, 60, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    default:
                        break;
                }
                switch (game.getMember().get(1).getAttack()) {
                    case 1:
                        g.drawImage(getImagem(game, 20), 235, 115, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 2:
                        g.drawImage(getImagem(game, 20), 265, 115, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    case 3:
                        g.drawImage(getImagem(game, 20), 295, 115, x / 20, ((getHeight() / 28)) - 1, null);
                        break;
                    default:
                        break;
                }
            }
        }
        
        for(int i = 0; i < game.getGame().getGameData().getOrganicDetonator(); i++){
            g.drawImage(getImagem(game, 20), 295, 115, x / 20, ((getHeight() / 28)) - 1, null);
        }
        for(int i = 0; i < game.getGame().getGameData().getParticleDisperser(); i++){
            g.drawImage(getImagem(game, 20), 295, 115, x / 20, ((getHeight() / 28)) - 1, null);
        }
        for(int i = 0; i < game.getGame().getGameData().getSealedRoom(); i++){
            g.drawImage(getImagem(game, 20), 295, 115, x / 20, ((getHeight() / 28)) - 1, null);
        }

    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(game.getState() instanceof SetupMembers || game.getState() instanceof AwaitAlliensPlacement || game.getState() instanceof AwaitRestPhase || game.getState() instanceof Turn || game.getState() instanceof AwaitCrewPhase || game.getState() instanceof AwaitAlienPhase);
    }

}

/*   ObservableGame game;
    JButton start = new JButton("Start Game");
    JButton dificuldade = new JButton("Dificuldade");

    public CharacterStatsPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);

        setupComponents();
        setupLayout();
        setVisible(game.getState() instanceof AwaitNewCrewMember);
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        dificuldade.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(270)); // do topo ate ao button start
        add(start);
        add(Box.createVerticalStrut(10));
        add(Box.createVerticalStrut(10)); // entre cada button
        add(dificuldade);
        validate();

    }

    private void setupComponents() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.startGame();
            }

        });
        dificuldade.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {

                System.exit(0);
            }

        });
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitNewCrewMember);
    }

}*/
