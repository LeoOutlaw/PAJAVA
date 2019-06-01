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

/**
 *
 * @author Leonardo
 */
public class AwaitCrewPhase extends IStatesAdapter {

    public AwaitCrewPhase(GameData game) {
        super(game);
    }

    public IStates chooseAPOption(int option, ShipRooms room, Members member, int option2, int attack) {
        final List<Members> members = getGameData().getPlayer().getMembers();
        final List<ShipRooms> rooms = getGameData().getShip().getRooms();
        switch (option) {
            case 0:
                getGameData().setTurnActionPoints();
                getGameData().advanceTurn();
                return new AwaitAlienPhase(getGameData());
            case 1:
                getGameData().movePlayerTo(room, member, option2);
                getGameData().decementActionPoints();
                break;
            case 2:
                for (int i = 0; i < rooms.size(); i++) {
                    for (int j = 0; j < rooms.get(i).getUser().size(); j++) {
                        if (rooms.get(i).getUser().get(j).getName().equals(members.get(option2 - 1).getName()) && rooms.get(i).isAliens()) {
                            for (int x = 0; x < members.get(option2 - 1).getAttack(); x++) {
                                if (!rooms.get(i).getAliens().isEmpty()) {
                                    if (attack > 4) {
                                        rooms.get(i).getAliens().remove(rooms.get(i).getAliens().get(rooms.get(i).getAliens().size() - 1));
                                        getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() + 1);
                                    }
                                    getGameData().decementActionPoints();
                                }
                            }
                        }
                    }
                }
            case 3:
                for (int i = 0; i < members.size(); i++) {
                    if (members.get(i).getName().equals("Doctor")) {
                        getGameData().getPlayer().setHp(getGameData().getPlayer().getHp() + 1);
                        getGameData().decementActionPoints();
                        break;
                    }
                }
                break;
            case 4:
                for (int i = 0; i < members.size(); i++) {
                    if (members.get(i).getName().equals("Engineer")) {
                        getGameData().getShip().setHull(getGameData().getShip().getHull() + 1);
                        getGameData().decementActionPoints();
                        break;
                    }
                }
                break;
            case 5:
                if (getGameData().getOrganicDetonator() > 0) {
                    getGameData().decementActionPoints();
                    room.setOrganicDetonator();
                    getGameData().setOrganicDetonator(getGameData().getOrganicDetonator() - 1);
                }
                break;
            case 6:
                if (getGameData().getParticleDisperser() > 0) {
                    getGameData().decementActionPoints();
                    room.setParticleDisperser();
                    getGameData().setParticleDisperser(getGameData().getParticleDisperser() - 1);
                }
                break;
            case 7:
                if (getGameData().getSealedRoom() > 0) {
                    if (!room.isSealed()) {
                        getGameData().decementActionPoints();
                        room.setSealedRoom();
                        getGameData().setParticleDisperser(getGameData().getSealedRoom() - 1);
                    }
                }
                break;
            case 8:
                if (room.isAliens()) {
                    room.deleteAllAliens();
                    getGameData().setParticleDisperser(getGameData().getSealedRoom() + 1);
                    getGameData().decementActionPoints();
                }
                if (room.isMembers()) {
                    getGameData().setGameOver(true);
                    return new FinalStage(getGameData());
                }
                break;
        }
        if (getGameData().getActionPoints() != 0) {
            return this;
        } else {
            getGameData().setTurnActionPoints();
            getGameData().advanceTurn();
            return new AwaitAlienPhase(getGameData());
        }
    }

    public IStates crewMemberDieded() {
        return new FinalStage(getGameData());
    }
}
