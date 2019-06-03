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
import information.rooms.ShipRooms;
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
                    for (ShipRooms room : game.getRooms()) {
                        if (room.getUser().contains(game.getMember().get(0))) {
                            String[] nei = new String[room.getNeighbours().size()];
                            for (int i = 0; i < room.getNeighbours().size(); i++) {
                                nei[i] = room.getNeighbours().get(i).getName();
                            }
                            Object select = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Member", "Member Selection", JOptionPane.QUESTION_MESSAGE, null, nei, room.getNeighbours().get(0));
                            for (int c = 0; c < room.getNeighbours().size(); c++) {
                                if (select.equals(room.getNeighbours().get(c).getName())) {
                                    game.chooseOption(1, room, game.getMember().get(0), c + 1, 0);
                                }
                            }
                            break;
                        }
                    }

                } else if (selectMem.equals(game.getMember().get(1).getName())){
                    for (ShipRooms room : game.getRooms()) {
                        if (room.getUser().contains(game.getMember().get(1))) {
                            String[] nei = new String[room.getNeighbours().size()];
                            for (int i = 0; i < room.getNeighbours().size(); i++) {
                                nei[i] = room.getNeighbours().get(i).getName();
                            }
                            Object select = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Member", "Member Selection", JOptionPane.QUESTION_MESSAGE, null, nei, room.getNeighbours().get(0));
                            for (int c = 0; c < room.getNeighbours().size(); c++) {
                                if (select.equals(room.getNeighbours().get(c).getName())) {
                                    game.chooseOption(1, room, game.getMember().get(1), c + 1, 0);
                                }
                            }
                            break;
                        }
                    }
                }

                game.getGame().getGameData().decementActionPoints();

            }

        }
        );
        attack.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev
            ) {
                int a = game.getGame().getGameData().attackPlayer();
                int b;
                String[] as = new String[2];
                as[0] = game.getMember().get(0).getName();
                as[1] = game.getMember().get(1).getName();

                Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Member", "Member Selection", JOptionPane.QUESTION_MESSAGE, null, as, game.getMember().get(0).getName());
                if (selectMem.equals(game.getMember().get(0).getName())) {
                    game.chooseOption(2, null, null, 1, a);
                } else if (selectMem.equals(game.getMember().get(1).getName())) {
                    game.chooseOption(2, null, null, 2, a);
                }
            }
        }
        );

        heal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int flag = 0;
                for (int i = 0; i < game.getMember().size(); i++) {
                    if (game.getMember().get(i).getName().equalsIgnoreCase("Doctor")) {
                        game.chooseOption(3, null, null, 0, 0);
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    JOptionPane.showMessageDialog(ActionPointsPanel.this, "Nao possui Doctor na crew!", "Aviso", JOptionPane.PLAIN_MESSAGE);
                }

            }
        });

        repair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int flag = 0;
                for (int i = 0; i < game.getMember().size(); i++) {
                    if (game.getMember().get(i).getName().equalsIgnoreCase("Engineer")) {
                        game.chooseOption(4, null, null, 0, 0);
                        flag = 1;
                    }
                }
                if (flag == 0) {
                    JOptionPane.showMessageDialog(ActionPointsPanel.this, "Nao possui Engineer na crew!", "Aviso", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
        orgTrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String[] as = new String[2];
                int a = 0;
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (!game.getRooms().get(i).getUser().isEmpty()) {
                        as[a] = game.getRooms().get(i).getName();
                        a++;
                    }
                }
                Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Room", "Room Selection", JOptionPane.QUESTION_MESSAGE, null, as, null);
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (selectMem.equals(game.getRooms().get(i).getName())) {
                        game.chooseOption(5, game.getRooms().get(i), null, 0, 0);
                    }
                }

            }
        });

        parTrap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String[] as = new String[2];
                int a = 0;
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (!game.getRooms().get(i).getUser().isEmpty()) {
                        as[a] = game.getRooms().get(i).getName();
                        a++;
                    }
                }
                Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Room", "Room Selection", JOptionPane.QUESTION_MESSAGE, null, as, null);
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (selectMem.equals(game.getRooms().get(i).getName())) {
                        game.chooseOption(6, game.getRooms().get(i), null, 0, 0);
                    }
                }

            }
        });

        seal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String[] as = new String[6];
                int a = 0;
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (game.getRooms().get(i).getCanBeSealed()) {
                        as[a] = game.getRooms().get(i).getName();
                        a++;
                    }
                }
                Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Room", "Room Selection", JOptionPane.QUESTION_MESSAGE, null, as, null);
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (selectMem.equals(game.getRooms().get(i).getName())) {
                        game.chooseOption(7, game.getRooms().get(i), null, 0, 0);
                    }
                }

            }
        });

        detonate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int count = 0;
                for (int i = 0; i < game.getRooms().size(); i++) {
                    if (game.getRooms().get(i).isHasParticleDisperser()) {
                        count++;
                    }
                }
                if (count > 0) {

                    String[] as = new String[2];
                    int a=0;
                    for (int i = 0; i < game.getRooms().size(); i++) {
                        if (game.getRooms().get(i).isHasParticleDisperser()) {
                            as[a] = game.getRooms().get(i).getName();
                            a++;
                        }
                    }
                    Object selectMem = JOptionPane.showInputDialog(ActionPointsPanel.this, "Choose a Room", "Room Selection", JOptionPane.QUESTION_MESSAGE, null, as, null);
                    for (int i = 0; i < game.getRooms().size(); i++) {
                        if (selectMem.equals(game.getRooms().get(i))) {
                            game.chooseOption(8, game.getRooms().get(i), null, 0, 0);
                        }
                    }

                } else {
                    System.out.println("Nao existem particle dispersers colocadas!");
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
