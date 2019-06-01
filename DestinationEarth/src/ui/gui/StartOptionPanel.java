/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitBeginning;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class StartOptionPanel extends JPanel implements Observer {

    ObservableGame game;

    JButton start = new JButton("Start Game");
    JButton settings = new JButton("Settings");
    JButton sair = new JButton("Sair");
    JLabel ndificuldade = new JLabel();
    JLabel narea = new JLabel();

    StartOptionPanel(ObservableGame game) {
        this.game = game;
        game.addObserver(this);

        setupComponents();
        setupLayout();
    }

    private void setupLayout() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        start.setAlignmentX(Component.CENTER_ALIGNMENT);
        settings.setAlignmentX(Component.CENTER_ALIGNMENT);
        sair.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(270)); // do topo ate ao button start
        add(start);
        add(Box.createVerticalStrut(30)); // entre cada button
        add(settings);
        add(Box.createVerticalStrut(30));
        add(sair);

        validate();

    }

    private void setupComponents() {
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.startGame();
            }

        });
        settings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.changeSettings();
            }
        });
        sair.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ev) {
                System.exit(0);
            }

        });
    }


    @Override
    public void update(Observable o, Object o1) {
        setVisible(game.getState() instanceof AwaitBeginning);
    }
}
