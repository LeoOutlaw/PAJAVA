/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.rooms.ShipRooms;
import java.util.List;


/**
 *
 * @author Tiago Alves
 */
public class Turn extends IStatesAdapter { 
           
    public Turn (GameData g){
        super(g);
    }  
    
    public IStates journeyTracker(int length){
        
        switch(length){
            case 1:
                return new AwaitRestPhase(getGameData());
            default:
                return new AwaitAlliensPlacement(getGameData());
        }

    }
    
    public IStates journeyEnded(){
        return new FinalStage(getGameData());
    }
}
