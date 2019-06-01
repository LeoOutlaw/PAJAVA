/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import com.sun.glass.events.KeyEvent;
import controllers.ObservableGame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Leonardo
 */
public class DestinationEarthView extends JFrame implements Observer {

    ObservableGame game;
    DestinationEarthPanel panel;

    public DestinationEarthView(ObservableGame j) {
        super("Destination Earth");

        game = j;
        game.addObserver(this);

        panel = new DestinationEarthPanel(game);

        addComponents();
        menu();

        setVisible(true);
        this.setSize(700, 500);
        this.setMinimumSize(new Dimension(650, 450));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
    }

    private void menu() {
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu gameMenu = new JMenu("Game");
        JMenuItem newObjJMI = new JMenuItem("Stop");
        newObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

        JMenuItem readObjJMI = new JMenuItem("Load");
        newObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));

        JMenuItem saveObjJMI = new JMenuItem("Save");
        newObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        JMenuItem exitObjJMI = new JMenuItem("Exit");
        newObjJMI.setAccelerator(
                KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        gameMenu.add(newObjJMI);
        gameMenu.add(readObjJMI);
        gameMenu.add(saveObjJMI);
        gameMenu.addSeparator();

        gameMenu.add(exitObjJMI);
        menuBar.add(gameMenu);

        newObjJMI.addActionListener(new NewObjMenuBarListener());
        readObjJMI.addActionListener(new LoadObjMenuBarListener());
        saveObjJMI.addActionListener(new SaveObjMenuBarListener());
        exitObjJMI.addActionListener(new ExitListener());

        JMenu helpMenu = new JMenu("Help");

        JMenuItem helpContentJMI = new JMenuItem("Help Contents");
        helpContentJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));

        JMenuItem aboutJMI = new JMenuItem("About");
        aboutJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

        helpMenu.add(helpContentJMI);
        helpMenu.add(aboutJMI);
        menuBar.add(helpMenu);

        helpContentJMI.addActionListener(new HelpContentListener());
        aboutJMI.addActionListener(new AboutListener());

    }

    private void addComponents() {
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(panel);      
    }

    class NewObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(DestinationEarthView.this, "Fechou o Jogo", "Exit", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }

    class LoadObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showOpenDialog(DestinationEarthView.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

            } else {
                System.out.println("Operation Cancled");
            }
        }
    }

    class SaveObjMenuBarListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            JFileChooser fc = new JFileChooser("./data");
            int returnVal = fc.showOpenDialog(DestinationEarthView.this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

            } else {
                System.out.println("Operation Cancled");
            }

        }
    }

    class ExitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(DestinationEarthView.this, "Fechou o Jogo", "Exit", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }

    class HelpContentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(DestinationEarthView.this, "Carregue nas Cartas para as Virar! Tente chegar a Dugeon 14 sem morrer e derrote o BossMonster!", "Help", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class AboutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(DestinationEarthView.this, "MiniRogue GameBoard", "About", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void update(Observable o, Object arg) {
        repaint();
    }
}
