package controllers;

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

    private List<String> journey;
    private int numAlliens;

    private int turn = 0;
    private int actionPoints;
    private int organicDetonator;
    private int particleDisperser;
    private int sealedRoom;

    private String msg;

    private boolean gameOver;
    private boolean shipOver;
    private boolean playerOver;

    public GameData() {
        msg = "";
        sealedRoom = 6;
        organicDetonator = 4;
        particleDisperser = 2;
        journey = Arrays.asList("S", "2A", "3A", "4A", "5A*", "R", "4A", "5A", "6A*", "R", "6A", "7A*", "R", "8A", "E");
        settings = new Settings();
        numAlliens = 15;
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

    public boolean isShipOver() {
        return shipOver;
    }

    public void setShipOver(boolean shipOver) {
        this.shipOver = shipOver;
    }
    
    public boolean isPlayerOver() {
        return playerOver;
    }

    public void setPlayerOver(boolean playerOver) {
        this.playerOver = playerOver;
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

    public void moveAliens() {
        List<ShipRooms> rooms;
        rooms = new ArrayList<>();
        ShipRooms newRoom;
        for (int i = 0; i < getShip().getRooms().size(); i++) {
            if (!getShip().getRooms().get(i).getAliens().isEmpty()) {
                rooms.add(getShip().getRooms().get(i));
            }
        }
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.isEmpty()) {
                for (int j = 0; j < rooms.get(i).getAliens().size(); j++) {
                    newRoom = rooms.get(i).getAliens().get(j).moveRandomAlien(rooms.get(i));
                    newRoom.addAlien(rooms.get(i).getAliens().get(j));
                    seeIfOrganicDetonator(newRoom, rooms.get(i).getAliens().get(j));
                }
                rooms.get(i).deleteAllAliens();
            }
        }
    }

    public void seeIfOrganicDetonator(ShipRooms room, Alien alien) {
        if (room.isHasOrganicDetonator()) {
            room.removeAlien(alien);
            room.unsetOrganicDetonator();
            setOrganicDetonator(getOrganicDetonator() + 1);
        }
    }

    public void CombatAlienPhase() {
        for (int i = 0; i < getShip().getRooms().size(); i++) {
            if (!getShip().getRooms().get(i).getAliens().isEmpty()) {
                if (!getShip().getRooms().get(i).getUser().isEmpty()) {
                    for (int j = 0; j < getShip().getRooms().get(i).getAliens().size(); j++) {
                        getShip().getRooms().get(i).getAliens().get(j).attackAlienMember();
                        if(getPlayer().getHp() < 1){
                            setPlayerOver(true);
                            break;
                        }
                    }
                }else {
                    for (int j = 0; j < getShip().getRooms().get(i).getAliens().size(); j++) {
                        getShip().getRooms().get(i).getAliens().get(j).attackAlienShip();
                        if(getShip().getHull() < 1){
                            setShipOver(true);
                            break;
                        }
                    }
                }
            }
            if(getPlayer().getHp() < 1 || getShip().getHull() < 1){
                setGameOver(true);
                break;
            }
        }
    }
}
