/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitAlliensPlacement;
import controllers.stats.AwaitCrewPhase;
import controllers.stats.Turn;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
public class ActionPointsPanel extends JPanel implements Observer {

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

    ActionPointsPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        setupComponents();
        setupLayout();

        setVisible(game.getState() instanceof AwaitCrewPhase);
    }

    private void setupComponents() {
        skip.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.chooseOption();
                game.moveAlliens();
                game.combatAlliens();
            }
        });
    }

    private void setupLayout() {
        setLayout(new GridLayout(5, 2,0, 0));
        actionPoints.setText("Action Points-> " + game.getActionPoints());
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
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitCrewPhase);
    }

}
