package controllers;

import information.Members.Members;
import information.traps.*;
import information.dices.Dice;
import information.Player;
import information.Settings;
import information.SpaceShip;
import information.alien.Alien;
import information.rooms.ShipRooms;

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

    public List<Members> member;
    private List<String> journey;
    private int numAlliens;
    private int addToResult;

    private int turn = 0;
    private int actionPoints;
    private int organicDetonator;
    private int particleDisperser;
    private int sealedRoom;

    private String msg;

    private boolean gameOver;

    public GameData() {
        msg = "";
        addToResult = 0;
        sealedRoom = 6;
        organicDetonator = 4;
        particleDisperser = 2;
        journey = Arrays.asList("S", "2A", "3A", "4A", "5A*", "R", "4A", "5A", "6A*", "R", "6A", "7A*", "R", "8A", "E");
        settings = new Settings();
        numAlliens = 15;
    }
    
    public Members getCarta(int area){ //Retorna o Objecto carta da area actual
        return member.get(area);
    }
    
    public String getStringCarta(int area)
    {
        return getCarta(area).getName();
    }

    public int getAddToResult() {
        return addToResult;
    }

    public void setAddToResult(int addToResult) {
        this.addToResult = addToResult;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
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
        this.ship = new SpaceShip(settings);
    }

    public SpaceShip getShip() {
        return ship;
    }

    public void advanceTurn() {
        this.turn = turn + 1;
    }

    public int getTurn() {
        return turn;
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

    public int getActionPoints() {
        return actionPoints;
    }

    public void decementActionPoints() {
        this.actionPoints = this.actionPoints - 1;
    }

    public void setTurnActionPoints() {
        this.actionPoints = getPlayer().getActionPoints();
    }

    public int getParticleDisperser() {
        return particleDisperser;
    }

    public void setParticleDisperser(int particleDisperser) {
        this.particleDisperser = particleDisperser;
    }

    public int getOrganicDetonator() {
        return organicDetonator;
    }

    public void setOrganicDetonator(int organicDetonator) {
        this.organicDetonator = organicDetonator;
    }

    public int getSealedRoom() {
        return sealedRoom;
    }

    public void setSealedRoom(int sealedRoom) {
        this.sealedRoom = sealedRoom;
    }

    public void seeIfOrganicDetonator(ShipRooms room, Alien alien) {
        if (room.isHasOrganicDetonator()) {
            room.removeAlien(alien);
            room.unsetOrganicDetonator();
            setOrganicDetonator(getOrganicDetonator() + 1);
            getPlayer().setInspirationPoints(getPlayer().getInspirationPoints() + 1);
        }
    }

    public void gainOneAttackDie(Members member) {
        if (member.getAttack() < 3) {
            member.setAttack(member.getAttack() + 1);
        } else {
            member.setAttack(3);
        }
    }

    public int attackPlayer() {
        return (int) (Math.random() * 6 + 1) + addToResult;
    }

    public void movePlayerTo(ShipRooms room, Members member, int option) {
        room.removeUser(member);
        room.getNeighbours().get(option - 1).setUser(member);
    }
}
