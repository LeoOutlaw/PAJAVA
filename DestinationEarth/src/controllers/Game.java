package controllers;

import controllers.stats.AwaitBeginning;
import controllers.stats.IStates;
import information.Members.Members;
import information.rooms.ShipRooms;

public class Game {

    private GameData gameData;
    private IStates iStates;

    public Game() {
        gameData = new GameData();
        setState(new AwaitBeginning(gameData));
    }

    public int getIp(){
        return gameData.getPlayer().getInspirationPoints();
    }
    
    public int getHp(){
        return gameData.getPlayer().getHp();
    }
    
    public int getHull(){
        return gameData.getShip().getHull();
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
    
    public void changeSettings () {
        setState(getState().changeSettings());
    }

    public void startGame() {
        setState(getState().startGame());
    }

    public void voltarMenu(){
        setState(getState().voltarMenu());
    }
    
    public void chooseMember(int member) {
        setState(getState().chooseMember(member));
    }

    public void setRoomsPlayers() {
        setState(getState().setPlayers());
    }

    public void journeyTracker(int length) {
        setState(getState().journeyTracker(length));
    }

    public void assignAliens(int n_alliens) {
        setState(getState().allienAssign(n_alliens));
    }

    public void chooseApOption(int option, ShipRooms room, Members member, int roomOption, int attack){
        setState(getState().chooseAPOption(option, room, member, roomOption, attack));
    }
    
    public void valActionPoints() {
        getGameData().setTurnActionPoints();
        setState(getState().setActionPoints());
    }

    public void clearAliens() {
        setState(getState().clearAlliens());
    }

    public void chooseOption(int option, Members member) {
        setState(getState().chooseOption(option, member));
    }

    public void moveAliensRandom() {
        setState(getState().moveAliens());
    }

    public void combatAliens() {
        setState(getState().CombatPhase());
    }

    public void journeyEnded() {
        setState(getState().journeyEnded());
    }

    public void endGame() {
        setState(getState().endGame());
    }

    public void crewMemberDieded() {
        setState(getState().crewMemberDieded());
    }

    /*---------------------------------------------------------*/
    
    public String getStringCarta(int area){
        return gameData.getStringCarta(area);
    }

}
