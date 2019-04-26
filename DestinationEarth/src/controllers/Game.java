/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 * Esta classe vai ter o GameData do jogo e saber em que estado do jogo estamos
 * Classe superior a GameData e da maquina de estados para que se consiga Ligar
 * a maquina de estados a informaçao do jogo
 *
 * @author Leonardo
 */
import controllers.stats.AwaitBeginning;
import controllers.stats.IStates;

public class Game {

    private GameData gameData;
    private IStates iStates;

    public Game() {
        gameData = new GameData();
        setState(new AwaitBeginning(gameData));
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setGameData(GameData game) {
        this.gameData = game;
    }

    public IStates getState() {
        return iStates;
    }

    public void setState(IStates state) {
        this.iStates = state;
    }
    
    public void startGame(){
        setState(getState().startGame());
    }
    
    public void chooseMember(int member){
        setState(getState().chooseMember(member));
    }
    
    public void setRoomsPlayers(){
        setState(getState().setPlayers());
    }
    
    public void journeyTracker(int length){
        setState(getState().journeyTracker(length));
    }
    
    public void assignAliens(int n_alliens){
        setState(getState().allienAssign(n_alliens));
    }

    public void dontDoNothing() {
        setState(getState().passCrewPhase());
    }
    
    public void valActionPoints(){
        setState(getState().setActionPoints());
    }
    
    public void clearAliens(){
        setState(getState().clearAlliens());
    }
    
    public void endOfRestPhase(){
        setState(getState().endOfRestPhase());
    }
    
    public void moveAliensRandom(){
        setState(getState().moveAliens());
    }
    
    public void combatAliens(){
        setState(getState().CombatPhase());
    }
    
    public void winGame(){
        setState(getState().winGame());
    }
    
    public void endGame(){
        setState(getState().endGame());
    }
}
