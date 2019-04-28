/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.rooms;

import java.util.Arrays;
import java.util.List;

public class ConferenceRoom extends ShipRooms {

    private Brig brig;
    private Astrometrics astrometrics;
    private MessHall messHall;
    private Bridge bridge;

    public ConferenceRoom() {
        name = "ConferenceRoom";
        roomNumber = 5;
        canBeSealed = false;
    }

    public String getName() {
        return name;
    }

    public void setBrig(Brig brig) {
        this.brig = brig;
    }

    public void setAstrometrics(Astrometrics astrometrics) {
        this.astrometrics = astrometrics;
    }

    public void setMessHall(MessHall messHall) {
        this.messHall = messHall;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public void moveAlienToBrig() {
        this.brig.moveAliens(aliens);
        aliens.clear();
    }

    public void moveAlienToAstrometrics() {
        this.astrometrics.moveAliens(aliens);
        aliens.clear();
    }

    public void moveAlienToBridge() {
        this.bridge.moveAliens(aliens);
        aliens.clear();
    }

    public void moveAlienToMessHall() {
        this.messHall.moveAliens(aliens);
        aliens.clear();
    }

    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.astrometrics, this.bridge, this.brig, this.messHall);
    }
}
