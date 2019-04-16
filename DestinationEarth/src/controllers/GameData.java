package controllers;

import information.traps.*;
import information.dices.Dice;
import information.Player;
import information.Settings;
import information.SpaceShip;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * Aqui basicamente tem toda a informacao sobre o jogo a decorrer
 * Ou seja, todos os Membros, todos os alliens e bombas 
 * Guardar toda a informaçao sobre em que turno se encontra 
 * Basicamente esta classe toma conta do jogo todo!
 * @author Leonardo
 */
public class GameData {
    //private SpaceShip spaceShip;
    private Player player;
    private SpaceShip ship;
    private Settings settings;
    private int numAlliens;
    
    public GameData(){
        settings = new Settings();
        numAlliens = 15;
    }
    
    public Settings getSettings(){
        return settings;
    }
    
    public void setPlayerHp(int hp){
        this.player.setHp(hp);
    }
    
    public void setSpaceShipHull(int hull){
        this.ship.setHull(hull);
    }
    
}
