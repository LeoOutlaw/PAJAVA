package controllers;

import information.traps.*;
import information.dices.Dice;
import information.Player;
import information.Settings;
import information.SpaceShip;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Aqui basicamente tem toda a informacao sobre o jogo a decorrer Ou seja, todos
 * os Membros, todos os alliens e bombas Guardar toda a informaçao sobre em que
 * turno se encontra Basicamente esta classe toma conta do jogo todo!
 *
 * @author Leonardo
 */
public class GameData {

    //private SpaceShip spaceShip;
    private Player player;
    private SpaceShip ship;
    private Settings settings;

    private List<String> journey;
    private int numAlliens;

    private int turn = 0;
    private int actionPoints;

    private String msg;
    
    public GameData() {
        msg = "";
        journey = Arrays.asList("S", "2A", "3A", "4A", "5A*", "R", "4A", "5A", "6A*", "R", "6A", "7A*", "R", "8A", "E");

        settings = new Settings();
        numAlliens = 15;
        ship = new SpaceShip();
    }

    public Player getPlayer() {
        return player;
    }

    public Settings getSettings() {
        return settings;
    }

    public void setPlayerHp(int hp) {
        this.player.setHp(hp);
    }

    public void setSpaceShipHull(int hull) {
        this.ship.setHull(hull);
    }

    public void startgame() {
        this.player = new Player(settings);
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void advanceTurn() {
        this.turn = turn + 1;
    }

    public String getJourneyStep() {
        return this.journey.get(turn);
    }

    public int roll2Dice() {
        return rollDice() + rollDice();
    }

    public int rollDice() {
        return (int) (Math.random() * 6 + 1);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public int getActionPoints(){
        return actionPoints;
    }
    
    public void decementActionPoints(){
        this.actionPoints = this.actionPoints-1;
    }
    
    public void setTurnActionPoints(){
        this.actionPoints = getPlayer().getActionPoints();
    }
}
