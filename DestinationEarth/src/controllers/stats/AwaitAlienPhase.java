/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.rooms.ShipRooms;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class AwaitAlienPhase extends IStatesAdapter {
    
    public AwaitAlienPhase(GameData game) {
        super(game);
    }
    
    public IStates moveAliens(){
        getGameData().moveAliens();
        return this;
    }
    
    public IStates CombatPhase(){
        getGameData().CombatAlienPhase();
        if(getGameData().isGameOver()){
            return new FinalStage(getGameData());
        }
        return new Turn(getGameData());
    }
    
    
    
}
