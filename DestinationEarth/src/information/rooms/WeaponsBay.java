/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.rooms;

import java.util.Arrays;
import java.util.List;

public class WeaponsBay extends ShipRooms {

    private Holodeck holodeck;
    private SickBay sickBay;

    public WeaponsBay() {
        name = "WeaponsBay";
        roomNumber = 7;
    }

    public String getName() {
        return name;
    }

    public void setHolodeck(Holodeck holodeck) {
        this.holodeck = holodeck;
    }

    public void setSickBay(SickBay sickBay) {
        this.sickBay = sickBay;
    }

    public void moveAlienToHoloDeck() {
        this.holodeck.moveAliens(aliens);
        aliens.clear();
    }

    public void moveAlienToSickBay() {
        this.sickBay.moveAliens(aliens);
        aliens.clear();
    }

    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.holodeck, this.sickBay);
    }

}
