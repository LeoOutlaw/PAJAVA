/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.Members.Members;
import information.rooms.ShipRooms;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Leonardo
 */
public class SetupMembers extends IStatesAdapter {
   
    public SetupMembers (GameData g){
        super(g);
    }
    
    public IStates setActionPoints(){
        return this;
    }
    
    public IStates setPlayers(){
        final List<Members> members = getGameData().getPlayer().getMembers();
        final List<ShipRooms> rooms = getGameData().getShip().getRooms();

        //int userIndex = 0;
        
        for (int userIndex = 0; userIndex < members.size(); userIndex++) {

            int randomRoomNumber = new Random().nextInt(12) + 1;

            for (ShipRooms room : rooms) {
                if (room.getRoomNumber() == randomRoomNumber) {             
                    room.setUser(members.get(userIndex));
                    
                    //userIndex= userIndex+1;
                    //members.remove(0);
                }
            }
        }
        
        return new Turn(getGameData());
    }
}
