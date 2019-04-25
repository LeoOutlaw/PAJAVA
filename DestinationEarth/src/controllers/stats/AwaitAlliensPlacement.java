/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.alien.Alien;
import information.rooms.ShipRooms;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class AwaitAlliensPlacement extends IStatesAdapter {

    public AwaitAlliensPlacement(GameData game) {
        super(game);
    }

    public IStates allienAssign(int n_alliens) {
        final List<ShipRooms> rooms = getGameData().getShip().getRooms();

        for (int i = 0; i < n_alliens; i++) {
            final int roomNumber = getGameData().roll2Dice();

            for (ShipRooms room : rooms) { // corre as salas todas. pode ser melhorado para saltar fora antes
                if (room.getRoomNumber() == roomNumber) {
                    room.addAlien(new Alien());
                }
            }
        }
        return new AwaitCrewPhase(getGameData());
    }

}
