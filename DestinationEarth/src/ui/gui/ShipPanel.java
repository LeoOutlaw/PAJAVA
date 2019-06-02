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
    String imageFiles[] = {"imagens/ShipBoard.jpg", "imagens/Blue.jpg", "imagens/Yellow.jpg", "imagens/Orange.jpg", "imagens/Black.png", "imagens/White.jpg", "imagens/Green.jpg"};
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
        g.drawImage(getImagem(game, 1), 415, 150, x / 16, ((getHeight() / 23)) - 1, null);
        // meter os membros a aparecer em cada sala!!
        for (int i = 0; i < 12; i++) {
            if (game.getRooms().get(i).getName().equalsIgnoreCase("Bridge")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 0, 0, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 0, 0, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Brig")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 30, 50, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 30, 50, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("CrewQuarters")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 70, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 70, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Astrometrics")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 90, 130, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 90, 130, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("ConferenceRoom")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 120, 200, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 120, 200, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Engeneering")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 70, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 70, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Holodeck")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 300, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 300, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("MessHall")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 240, 300, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 240, 300, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Hydroponics")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 70, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 70, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Shuttlebay")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 70, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 70, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("SickBay")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 70, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 70, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            } else if (game.getRooms().get(i).getName().equalsIgnoreCase("WeaponsBay")) {
                if (!game.getRooms().get(i).getUser().isEmpty()) {
                    if (game.getRooms().get(i).getUser() == game.getMember().get(0)) {
                        g.drawImage(getImagem(game, 3), 70, 100, x / 15, ((getHeight() / 20)), null);
                    } else {
                        g.drawImage(getImagem(game, 2), 70, 100, x / 15, ((getHeight() / 20)), null);
                    }
                }
            }
        }

        // meter os alliens!!---------------------------------------------------------------------
        for (int i = 0; i < 12; i++) {
            if (!game.getRooms().get(i).getAliens().isEmpty()) {
                if (game.getRooms().get(i).getName().equalsIgnoreCase("Bridge")) {
                        g.drawImage(getImagem(game, 6 ), 0, 0, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Brig")) {
                        g.drawImage(getImagem(game, 6), 30, 50, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("CrewQuarters")) {
                        g.drawImage(getImagem(game, 6), 70, 100, x / 20, ((getHeight() / 28)), null); 
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Astrometrics")) {
                        g.drawImage(getImagem(game, 6), 90, 130, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("ConferenceRoom")) {
                        g.drawImage(getImagem(game, 6), 120, 200, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Engeneering")) {
                        g.drawImage(getImagem(game, 6), 70, 100, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Holodeck")) {
                        g.drawImage(getImagem(game, 6), 300, 100, x / 20, ((getHeight() / 28)), null); 
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("MessHall")) {
                        g.drawImage(getImagem(game, 6), 240, 300, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Hydroponics")) {
                        g.drawImage(getImagem(game, 6), 70, 100, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("Shuttlebay")) {
                        g.drawImage(getImagem(game, 6), 70, 100, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("SickBay")) {
                        g.drawImage(getImagem(game, 6), 70, 100, x / 20, ((getHeight() / 28)), null);
                } else if (game.getRooms().get(i).getName().equalsIgnoreCase("WeaponsBay")) {
                        g.drawImage(getImagem(game, 6), 70, 100, x / 20, ((getHeight() / 28)), null);

                }
            }
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitAlliensPlacement || game.getState() instanceof AwaitRestPhase || game.getState() instanceof Turn || game.getState() instanceof AwaitCrewPhase || game.getState() instanceof AwaitAlienPhase);
    }
}
