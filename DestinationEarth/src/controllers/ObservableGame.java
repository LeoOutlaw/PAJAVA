/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import controllers.stats.IStates;
import information.Members.Members;
import information.rooms.ShipRooms;
import java.util.List;
import java.util.Observable;

/**
 *
 * @author Leonardo
 */
public class ObservableGame extends Observable {

    Game game;

    public ObservableGame() {
        game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;

        setChanged();
        notifyObservers();
    }

    public IStates getState() {
        return game.getState();
    }

    public void startGame() {
        game.startGame();

        setChanged();
        notifyObservers();
    }
    
    public void changeSettings(){
        game.changeSettings();
        
        setChanged();
        notifyObservers();
    }
    
    public void voltarMenu(){
        game.voltarMenu();
        
        setChanged();
        notifyObservers();
    }
    
    public void pickMember(int i){
        game.chooseMember(i);
        
        setChanged();
        notifyObservers();
    }
    
    public void setupMembers(){
        game.getGameData().setTurnActionPoints();
        game.setRoomsPlayers();
        
        setChanged();
        notifyObservers();
    }
    
    public void journeyTracker(int len){
        game.journeyTracker(len);
        
        setChanged();
        notifyObservers();
    }
    
    public void assienAllien(int n_alliens){
        game.assignAliens(n_alliens);
        
        setChanged();
        notifyObservers();
    }
    
    public void chooseInsp(int action, Members member){
        game.chooseOption(action, member);
        
        setChanged();
        notifyObservers();
    }
    
    public void removeAlliens(){
        game.clearAliens();
        
        setChanged();
        notifyObservers();
    }
    
    public void chooseOption(int action, ShipRooms room, Members member, int option2, int attack){
        game.chooseApOption(action, room, member, option2, attack);// so a funcionar para o skip!
        setChanged();
        notifyObservers();
    }
    
    public void moveAlliens(){
        game.moveAliensRandom();
        setChanged();
        notifyObservers();
    }
    
    public void combatAlliens(){
        game.combatAliens();
        setChanged();
        notifyObservers();
    }
    
    public void setHp(int hp){
        game.getState().selectHP(hp);
    }
    
    public void setHull(int hull){
        game.getState().selectHull(hull);
    }
    
    public int getHp(){
        return game.getHp();
    }
    
    public int getIp(){
        return game.getIp();
    }
    
    public int getHull(){
        return game.getHull();
    }
    
    public int getActionPoints(){
        return game.getGameData().getActionPoints();
    }
    
    public String getStringCarta(int area){
        return game.getStringCarta(area);
    }
    
    public List<Members> getMember(){
        return game.getGameData().getPlayer().getMembers();
    }
    
    public List<ShipRooms> getRooms(){
        return game.getGameData().getShip().getRooms();
    }

    public String getJourneyStep() {
        return game.getGameData().getJourneyStep();
    }
    
}
