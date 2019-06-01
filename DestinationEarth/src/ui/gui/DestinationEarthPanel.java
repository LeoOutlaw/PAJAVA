/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class DestinationEarthPanel extends JPanel {

    ObservableGame game;
    StartOptionPanel optionPanel;
    CharacterStatsPanel caraStatsPanel;
    SettingsPanel settingsPanel;
    CardsPanel cardsPanel;
    ShipPanel shipPanel;
    MensagesPanel mensagesPanel;
    ActionPointsPanel actionPanel;

    public DestinationEarthPanel(ObservableGame game) {
        this.game = game;

        setupComponents();
        setupLayout();
    }

    private void setupComponents() {
        optionPanel = new StartOptionPanel(game);
        settingsPanel = new SettingsPanel(game);
        optionPanel.setPreferredSize(new Dimension(1400, 0));
        caraStatsPanel = new CharacterStatsPanel(game);
        cardsPanel = new CardsPanel(game);
        shipPanel = new ShipPanel(game);
        mensagesPanel= new MensagesPanel(game);
        actionPanel = new ActionPointsPanel(game);
    }

    private void setupLayout() {
        JPanel pCenter, pSouth, pWest, pEast;

        setLayout(new BorderLayout());
        pEast = new JPanel();
        pEast.setLayout(new BorderLayout());
        pEast.add(optionPanel);
        pEast.add(settingsPanel, BorderLayout.WEST);
        pEast.add(cardsPanel, BorderLayout.NORTH);
        pCenter = new JPanel();
        pCenter.setLayout(new GridLayout(1, 3,0, 0));
        pCenter.add(caraStatsPanel);
        pCenter.add(shipPanel);
        
        pWest = new JPanel();
        pWest.setLayout(new BorderLayout());
        

        pSouth = new JPanel();
        pSouth.setLayout(new GridLayout(2, 1,0, 0));
        pSouth.add(mensagesPanel);
        pSouth.add(actionPanel);
        
        pCenter.add(pSouth);

        add(pCenter, BorderLayout.CENTER);
        add(pWest, BorderLayout.WEST);
        add(pEast,BorderLayout.EAST);

        validate();
    }

}
