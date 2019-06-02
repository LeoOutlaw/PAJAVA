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
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                game.chooseOption(0, null, null, 0, 0);
                game.moveAlliens();
                game.combatAlliens();
            }
        });
        move.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String[] as = new String[2];
                as[0] = game.getMember().get(0).getName();
                as[1] = game.getMember().get(1).getName();

                Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Member", "Member Selection", JOptionPane.QUESTION_MESSAGE, null, as, game.getMember().get(0).getName());
                if (selectMem.equals(game.getMember().get(0).getName())) {
                    for (int i=0; i< game.getRooms().size(); i++){
                        if(game.getRooms().get(i).getUser().get(0).getName().equalsIgnoreCase(game.getMember().get(0).getName())){
                            game.chooseOption(1, game.getRooms().get(i), game.getMember().get(0), 1, 0);
                        }
                    }    
                }else {
                    for (int i=0; i< game.getRooms().size(); i++){
                        if(game.getRooms().get(i).getUser().get(0).getName().equalsIgnoreCase(game.getMember().get(1).getName())){
                            game.chooseOption(1, game.getRooms().get(i), game.getMember().get(1), 1, 0);
                        }
                    } 
                }
                
                game.getGame().getGameData().decementActionPoints();

            }
        });
        attack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int a = game.getGame().getGameData().getAddToResult();
                int b;
                String[] as = new String[2];
                as[0] = game.getMember().get(0).getName();
                as[1] = game.getMember().get(1).getName();

                Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Member", "Member Selection", JOptionPane.QUESTION_MESSAGE, null, as, game.getMember().get(0).getName());
                if(selectMem.equals(game.getMember().get(0).getName())){
                    game.chooseOption(2, null, null, 1, a);
                }else if(selectMem.equals(game.getMember().get(1).getName())){
                    game.chooseOption(2, null, null, 2, a);
                }
            }
        });
        
    }

    private void setupLayout() {
        setLayout(new GridLayout(5, 2, 0, 0));
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
