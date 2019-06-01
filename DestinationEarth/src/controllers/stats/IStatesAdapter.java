/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.Members.Members;
import information.rooms.ShipRooms;

/**
 *
 * @author Leonardo
 */
public class IStatesAdapter implements IStates {
    
    private GameData gameData;
    
    public IStatesAdapter(GameData game){
        this.gameData = game;
    }

    public GameData getGameData(){
        return gameData;
    }
    
    @Override
    public IStates selectHP(int hp) {
        return this;
    }
    
    @Override
    public IStates selectHull( int hull) {
        return this;
    }
    
    @Override
    public IStates voltarMenu(){
        return this;
    }
    
    @Override
    public IStates changeSettings() {
        return this;
    }
    
    @Override
    public IStates startGame(){
        return this;
    }
    
    @Override
    public IStates chooseMember(int member){
        return this;
    }
    
    @Override
    public IStates setPlayers(){
        return this;
    }
    
    @Override
    public IStates journeyTracker(int length){
        return this;
    }
    
    @Override
    public IStates allienAssign (int n_alliens){
        return this;
    }
    
    @Override
    public IStates setActionPoints(){
        return this;
    }
    
    @Override
     public IStates clearAlliens(){
         return this;
     }
     
     public IStates chooseOption(int option, Members member){
         return this;
     }
     
    @Override
     public IStates moveAliens(){
         return this;
     }
     
    @Override
     public IStates journeyEnded(){
         return this;
     }
     
     public IStates endGame(){
         return this;
     }
    
     public IStates CombatPhase(){
         return this;
     }
     
     public IStates crewMemberDieded(){
         return this;
     }  
     
     public IStates chooseAPOption(int option, ShipRooms room, Members member, int roomOption, int attack){
         return this;
     }
}
