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
public class ShipPanel extends JPanel implements Observer {

    ObservableGame game;
    String imageFiles[] = {"imagens/ShipBoard.jpg", "imagens/Blue.jpg", "imagens/Yellow.jpg", "imagens/Orange.jpg", "imagens/Black.png", "imagens/White.jpg", "imagens/Green.jpg", "imagens/Purple.png", "imagens/Red.jpg"};
    Image imagem[] = new Image[imageFiles.length];
    boolean loaded = false;

    ShipPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        setVisible(game.getState() instanceof Turn);
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

        if (game.getHull() == 1) {
            g.drawImage(getImagem(game, 1), 128, 613, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 2) {
            g.drawImage(getImagem(game, 1), 155, 613, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 3) {
            g.drawImage(getImagem(game, 1), 183, 613, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 4) {
            g.drawImage(getImagem(game, 1), 212, 613, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 5) {
            g.drawImage(getImagem(game, 1), 239, 613, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 6) {
            g.drawImage(getImagem(game, 1), 268, 613, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 7) {
            g.drawImage(getImagem(game, 1), 128, 643, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 8) {
            g.drawImage(getImagem(game, 1), 155, 643, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 9) {
            g.drawImage(getImagem(game, 1), 183, 643, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 10) {
            g.drawImage(getImagem(game, 1), 212, 643, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 11) {
            g.drawImage(getImagem(game, 1), 239, 643, x / 20, ((getHeight() / 28)) - 1, null);
        }
        if (game.getHull() == 12) {
            g.drawImage(getImagem(game, 1), 268, 643, x / 20, ((getHeight() / 28)) - 1, null);
        }

        if (game.getJourneyStep().length() == 1) {
            //rest, start or end

            if (game.getJourneyStep().equals("R")) {
                game.journeyTracker(game.getJourneyStep().length());
            } else if (game.getJourneyStep().equals("S")) {
                game.getGame().getGameData().advanceTurn();
            } else {

            }
        } else if (game.getJourneyStep().length() == 2) {
            game.journeyTracker(game.getJourneyStep().length());
            int numberOfAliens = Integer.valueOf(game.getJourneyStep().split("A")[0]);
            game.assienAllien(numberOfAliens);
        } else {
            // assign aliens and put all aliens back to bowl in the end of turn
            game.journeyTracker(game.getJourneyStep().length()); // Ver se o proximo turn e REST e apager todos os alliens
            //fase de batalha
        }
        // meter os membros a aparecer em cada sala!!
        for (int i = 0; i < 12; i++) {
            if (game.getRooms().get(i).getName().equalsIgnoreCase("Bridge")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 100, 100, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 100, 70, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if (game.getRooms().get(i).isHasOrganicDetonator()) {
                    g.drawImage(getImagem(game, 3), 130, 70, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isHasParticleDisperser()) {
                    g.drawImage(getImagem(game, 4), 130, 100, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Brig")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 90, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 60, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if (game.getRooms().get(i).isHasOrganicDetonator()) {
                    g.drawImage(getImagem(game, 3), 90, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isHasParticleDisperser()) {
                    g.drawImage(getImagem(game, 4), 130, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isSealed()) {
                    g.drawImage(getImagem(game, 5), 60, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("CrewQuarters")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 275, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 330, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if (game.getRooms().get(i).isHasOrganicDetonator()) {
                    g.drawImage(getImagem(game, 3), 330, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isHasParticleDisperser()) {
                    g.drawImage(getImagem(game, 4), 300, 180, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isSealed()) {
                    g.drawImage(getImagem(game, 5), 275, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Astrometrics")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 135, 340, x / 20, ((getHeight() / 28)), null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 170, 340, x / 20, ((getHeight() / 28)), null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),135, 380, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),170, 380, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("ConferenceRoom")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 135, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 170, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),135, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),170, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Engeneering")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 90, 270, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 60, 270, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),90, 310, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),75, 290, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isSealed()) {
                    g.drawImage(getImagem(game, 5), 60, 310, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Holodeck")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 275, 270, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 330, 270, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),330, 310, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),300, 290, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isSealed()) {
                    g.drawImage(getImagem(game, 5), 275, 310, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("MessHall")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 200, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 235, 160, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),200, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),235, 200, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Hydroponics")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 90, 380, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 60, 380, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),90, 410, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),75, 390, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isSealed()) {
                    g.drawImage(getImagem(game, 5), 60, 410, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Shuttlebay")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 155, 510, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 210, 510, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),155, 535, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),210, 535, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("SickBay")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 200, 340, x / 20, ((getHeight() / 28)), null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 235, 340, x / 20, ((getHeight() / 28)), null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),200, 380, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),235, 380, x / 20, ((getHeight() / 28)) - 1, null);
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("WeaponsBay")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(0).getName())) {
                        g.drawImage(getImagem(game, 7), 275, 380, x / 20, ((getHeight() / 28)) - 1, null);
                    } else if (game.getRooms().get(i).getUser().get(0).getName().equals(game.getMember().get(1).getName())) {
                        g.drawImage(getImagem(game, 8), 330, 380, x / 20, ((getHeight() / 28)) - 1, null);
                    }
                }
                if(game.getRooms().get(i).isHasOrganicDetonator()){
                    g.drawImage(getImagem(game, 3),330, 410, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if(game.getRooms().get(i).isHasParticleDisperser()){
                    g.drawImage(getImagem(game, 4),305, 390, x / 20, ((getHeight() / 28)) - 1, null);
                }
                if (game.getRooms().get(i).isSealed()) {
                    g.drawImage(getImagem(game, 5), 275, 410, x / 20, ((getHeight() / 28)) - 1, null);
                }
            }
        }

        // meter os alliens!!---------------------------------------------------------------------
        for (int i = 0; i < 12; i++) {
            if (!game.getRooms().get(i).getAliens().isEmpty()) {
                if (game.getRooms().get(i).getName().equalsIgnoreCase("Bridge")) {
                    g.drawImage(getImagem(game, 6), 200, 70, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Brig")) {
                    g.drawImage(getImagem(game, 6), 50, 200, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("CrewQuarters")) {
                    g.drawImage(getImagem(game, 6), 275, 200, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Astrometrics")) {
                    g.drawImage(getImagem(game, 6), 135, 400, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("ConferenceRoom")) {
                    g.drawImage(getImagem(game, 6), 135, 200, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Engeneering")) {
                    g.drawImage(getImagem(game, 6), 60, 320, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Holodeck")) {
                    g.drawImage(getImagem(game, 6), 275, 320, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("MessHall")) {
                    g.drawImage(getImagem(game, 6), 210, 210, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Hydroponics")) {
                    g.drawImage(getImagem(game, 6), 60, 420, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Shuttlebay")) {
                    g.drawImage(getImagem(game, 6), 155, 560, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("SickBay")) {
                    g.drawImage(getImagem(game, 6), 210, 400, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("WeaponsBay")) {
                    g.drawImage(getImagem(game, 6), 275, 420, x / 20, ((getHeight() / 28)), null);

                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitAlliensPlacement || game.getState() instanceof AwaitRestPhase || game.getState() instanceof Turn || game.getState() instanceof AwaitCrewPhase || game.getState() instanceof AwaitAlienPhase);
    }
}
