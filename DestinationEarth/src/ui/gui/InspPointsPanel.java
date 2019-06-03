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
import java.awt.GridLayout;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class InspPointsPanel extends JPanel implements Observer {

    ObservableGame game;

    JLabel actionPoints = new JLabel();
    JButton skip = new JButton("Skip");
    JButton move = new JButton("Move");
    JButton attack = new JButton("Attack");
    JButton heal = new JButton("Heal");
    JButton repair = new JButton("Repair");
    JButton orgTrap = new JButton("Organic Trap");
    JButton parTrap = new JButton("Particle Trap");
    JButton seal = new JButton("Seal Room");
    JButton detonate = new JButton("Detonate Particle Trap");

    InspPointsPanel(ObservableGame g) {
        this.game = g;
        this.game.addObserver(this);
        setupLayout();
        setupComponents();

        setVisible(game.getState() instanceof AwaitRestPhase);
    }

    private void setupComponents() {
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.chooseInsp(0, null);
                game.moveAlliens();
                game.combatAlliens();
            }
        });
    }

    private void setupLayout() {
        game.removeAlliens();
        setLayout(new GridLayout(5, 2, 0, 0));
        actionPoints.setText("Action Points-> ");
        add(actionPoints);
        add(skip);
        add(move);
        add(attack);
        add(heal);
        add(repair);
        add(orgTrap);
        add(parTrap);
        add(seal);
        add(detonate);

        validate();
    }

    @Override
    public void update(Observable o, Object o1) {
        setVisible(game.getState() instanceof AwaitRestPhase);
    }

}
