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
public class AwaitRestPhase extends IStatesAdapter {

    public AwaitRestPhase(GameData game) {
        super(game);
    }

    public IStates chooseOption(int option, Members member) {
        switch (option) {
            case 0:
                getGameData().setTurnActionPoints();
                getGameData().advanceTurn();
                return new Turn(getGameData());
            case 1:
                if (getGameData().getPlayer().getHp() < 12) {
                    getGameData().getPlayer().setHp(getGameData().getPlayer().getHp() + 1);
                    getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 1);
                }
                break;
            case 2:
                if (getGameData().getShip().getHull() < 12) {
                    getGameData().getShip().setHull(getGameData().getShip().getHull() + 1);
                    getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 1);
                }
                break;
            case 3:
                if (getGameData().getPlayer().getInspirationPoints() > 1) {
                    getGameData().setOrganicDetonator(getGameData().getOrganicDetonator() + 1);
                    getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 2);
                }
                break;
            case 4:
                if (getGameData().getPlayer().getInspirationPoints() > 3) {
                    if (member.getMovement() < 3) {
                        member.setMovement(member.getMovement() + 1);
                        getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 4);
                    }
                }
                break;
            case 5:
                if (getGameData().getPlayer().getInspirationPoints() > 4) {
                    getGameData().setParticleDisperser(getGameData().getParticleDisperser() + 1);
                    getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 5);
                }
                break;
            case 6:
                if (getGameData().getPlayer().getInspirationPoints() > 4) {
                    getGameData().setSealedRoom(getGameData().getSealedRoom() + 1);
                    getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 5);
                }
                break;
            case 7:
                if (getGameData().getPlayer().getInspirationPoints() > 5) {
                    if (member.getAttack() < 3) {
                        member.setAttack(member.getAttack() + 1);
                        getGameData().getPlayer().setInspirationPoints(getGameData().getPlayer().getInspirationPoints() - 4);
                    }
                }
                break;
            case 8:
                if (getGameData().getPlayer().getInspirationPoints() > 5) {
                    getGameData().setAddToResult(getGameData().getAddToResult() + 1);
                }
                break;
        }
        if (getGameData().getPlayer().getInspirationPoints() != 0) {
            return this;
        } else {
            getGameData().setTurnActionPoints();
            getGameData().advanceTurn();
            return new Turn(getGameData());
        }
    }

    public IStates clearAlliens() {
        final List<ShipRooms> rooms = getGameData().getShip().getRooms();

        for (ShipRooms room : rooms) {
            room.deleteAllAliens();
        }
        return this;
    }
}
