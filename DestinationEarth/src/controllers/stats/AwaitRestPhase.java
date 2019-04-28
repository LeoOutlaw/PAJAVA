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
 * @author Leonardo
 */
public class AwaitRestPhase extends IStatesAdapter {

    public AwaitRestPhase(GameData game) {
        super(game);
    }

    public IStates clearAlliens() {
        final List<ShipRooms> rooms = getGameData().getShip().getRooms();
        
        for (ShipRooms room : rooms) {
            room.deleteAllAliens();
        } 
        return this;
    }
    
    public IStates endOfRestPhase(){
        getGameData().setTurnActionPoints();
        getGameData().advanceTurn();
        return new Turn(getGameData());
    }

}
