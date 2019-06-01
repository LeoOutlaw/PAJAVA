/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitNewCrewMember;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 * @author Leonardo
 */
class CardsPanel extends JPanel implements Observer {

    ObservableGame game;
    JPanel p = new JPanel();
    int a = 0;

    CardsPanel(ObservableGame g) {
        game = g;
        game.addObserver(this);
        update(null, this.game);

        p.setLayout(new GridLayout(2, 6, 50, 10));
        setupLayout();

        setVisible(game.getState() instanceof AwaitNewCrewMember);
    }

    private void setupLayout() {
        for (int i = 0; i < 12; i++) {
            Imagens imagens = new Imagens(game, i);
            p.add(imagens);

        }

        add(p);
        p.repaint();
        validate();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent ev) {
                int x = ev.getX();
                int y = ev.getY();

                if (a < 2) {
                    if (x >= 0 && x <= 200 && y >= 8 && y <= 240) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(0);
                        p.add(lq, 0);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(1);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 220 && x <= 420 && y >= 8 && y <= 240) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(1);
                        p.add(lq, 1);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(2);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 440 && x <= 640 && y >= 8 && y <= 240) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(2);
                        p.add(lq, 2);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(3);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 660 && x <= 860 && y >= 8 && y <= 240) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(3);
                        p.add(lq, 3);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(4);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 880 && x <= 1080 && y >= 8 && y <= 240) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(4);
                        p.add(lq, 4);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(5);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 1100 && x <= 1300 && y >= 8 && y <= 240) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(5);
                        p.add(lq, 5);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(6);
                        x = 0;
                        y = 0;
                        a++;
                    }
                     if (x >= 0 && x <= 200 && y >= 260 && y <= 500) {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(6);
                        p.add(lq, 6);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(7);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 220 && x <= 420 && y >= 260 && y <= 500)  {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(7);
                        p.add(lq, 7);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(8);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 440 && x <= 640 && y >= 260 && y <= 500)  {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(8);
                        p.add(lq, 8);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(9);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 660 && x <= 860 && y >= 260 && y <= 500)  {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(9);
                        p.add(lq, 9);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(10);
                        x = 0;
                        y = 0;
                        a++;
                    }
                    if (x >= 880 && x <= 1080 && y >= 260 && y <= 500)  {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(10);
                        p.add(lq, 10);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(11);
                        x = 0;
                        y = 0;
                        a++;
                    }
                   if (x >= 1100 && x <= 1300 && y >= 260 && y <= 500)  {
                        ImagensViradas lq = new ImagensViradas(game);
                        p.remove(11);
                        p.add(lq, 11);
                        add(p);

                        lq.repaint();
                        validate();
                        game.pickMember(12);
                        x = 0;
                        y = 0;
                        a++;
                    }
                }
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitNewCrewMember);
        revalidate();
        repaint();
    }

}
