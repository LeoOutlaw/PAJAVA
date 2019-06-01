/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.gui;

import controllers.ObservableGame;
import controllers.stats.AwaitBeginning;
import controllers.stats.AwaitSettings;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Leonardo
 */
class SettingsPanel extends JPanel implements Observer {
    
    ObservableGame game;
    JLabel hp = new JLabel();
    JLabel hull = new JLabel();
    JComboBox comboBoxHP = new JComboBox();
    JComboBox comboBoxHull = new JComboBox();
    JButton voltar = new JButton("Voltar");
    
    SettingsPanel(ObservableGame game) {
        this.game = game;
        game.addObserver(this);

        setupComponents();
        setupLayout();
        
        setVisible(game.getState() instanceof AwaitSettings);
    }
      
    public void setupComponents(){
        voltar.addActionListener(new ActionListener() {
        
            @Override
            public void actionPerformed(ActionEvent e){
                game.setHp(comboBoxHP.getSelectedIndex()+1);
                game.setHull(comboBoxHull.getSelectedIndex()+1);
                game.voltarMenu();
            }
    });
        
        
    }
    
    public void setupLayout(){
        setLayout(new GridLayout(0, 3, 0, 0));

        JPanel pRigth = new JPanel();
        add(pRigth);


        JPanel pMiddle = new JPanel();
        add(pMiddle);
        pMiddle.setLayout(new GridLayout(4, 1, 0, 0));
        
        JPanel pUp= new JPanel();
        pMiddle.add(pUp);

        JPanel pHp = new JPanel();
        pMiddle.add(pHp);
        
        JPanel pHull = new JPanel();
        pMiddle.add(pHull);
        
        JPanel pDown = new JPanel();
        pDown.setOpaque(false);
        pMiddle.add(pDown);

        comboBoxHP.setEditable(true);
        comboBoxHP.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4","5","6","7","8","9","10","11","12"}));
        comboBoxHP.setSelectedIndex(7);
        comboBoxHP.setToolTipText("8");
        
        hp.setHorizontalAlignment(SwingConstants.CENTER);
        hp.setText("Insira o HP:");
        
        pHp.add(hp);
        pHp.add(comboBoxHP);
        pHp.setOpaque(false);

        comboBoxHull.setEditable(true);
        comboBoxHull.setModel(new DefaultComboBoxModel(new String[]{"1", "2", "3", "4","5","6","7","8","9","10","11","12"}));
        comboBoxHull.setSelectedIndex(7);
        comboBoxHull.setToolTipText("8");
        
        hull.setHorizontalAlignment(SwingConstants.CENTER);
        hull.setText("Insira o Hull:");
         
        pHull.add(hull);
        pHull.add(comboBoxHull);
        pHull.setOpaque(false);

        pDown.add(voltar);
        JPanel pLeft = new JPanel();
        add(pLeft);

        setVisible(true);

    }
    @Override
    public void update(Observable o, Object arg) {
        setVisible(game.getState() instanceof AwaitSettings);
    }
    
}
