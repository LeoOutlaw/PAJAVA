/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.Members.Members;
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
        List<ShipRooms> rooms;
        rooms = new ArrayList<>();
        ShipRooms newRoom;
        for (int i = 0; i < getGameData().getShip().getRooms().size(); i++) {
            if (!getGameData().getShip().getRooms().get(i).getAliens().isEmpty()) {
                rooms.add(getGameData().getShip().getRooms().get(i));
            }
        }
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.isEmpty()) {
                for (int j = 0; j < rooms.get(i).getAliens().size(); j++) {
                    do {
                        newRoom = rooms.get(i).getAliens().get(j).moveRandomAlien(rooms.get(i));
                    } while (newRoom.isSealed());
                    newRoom.addAlien(rooms.get(i).getAliens().get(j));
                    getGameData().seeIfOrganicDetonator(newRoom, rooms.get(i).getAliens().get(j));
                }
                rooms.get(i).deleteAllAliens();
            }
        }
        return this;
    }
    
    public IStates CombatPhase(){
        final List<Members> members = getGameData().getPlayer().getMembers();
        final List<ShipRooms> rooms = getGameData().getShip().getRooms();
        for (int i = 0; i < rooms.size(); i++) {
            if (!rooms.get(i).getAliens().isEmpty()) {
                if (!rooms.get(i).getUser().isEmpty()) {
                    for (int j = 0; j < rooms.get(i).getAliens().size(); j++) {
                        rooms.get(i).getAliens().get(j).attackAlienMember();
                        if (getGameData().getPlayer().getHp() < 1) {
                            getGameData().setGameOver(true);
                            break;
                        }
                    }
                } else {
                    for (int j = 0; j < rooms.get(i).getAliens().size(); j++) {
                        rooms.get(i).getAliens().get(j).attackAlienShip();
                        if (getGameData().getShip().getHull() < 1) {
                            getGameData().setGameOver(true);
                            break;
                        }
                    }
                }
            }
            if (getGameData().getPlayer().getHp() < 1 || getGameData().getShip().getHull() < 1) {
                getGameData().setGameOver(true);
                break;
            }
        }
        if(getGameData().isGameOver()){
            return new FinalStage(getGameData());
        }
        return new Turn(getGameData());
    }
    
    
    
}
