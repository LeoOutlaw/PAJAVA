/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.rooms;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Tiago Alves
 */
public class ShuttleBay extends ShipRooms{
    
    private SickBay sickBay;
    private Astrometrics astrometrics;
    
    public ShuttleBay(){
        name = "ShuttleBay";
        roomNumber = 6;    }
    
    public String getName(){
        return name;
    }

    public void setSickBay(SickBay sickBay) {
        this.sickBay = sickBay;
    }

    public void setAstrometrics(Astrometrics astrometrics) {
        this.astrometrics = astrometrics;
    }
    
    public void moveAlienToSickBay(){
        this.sickBay.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToAstrometrics(){
        this.astrometrics.moveAliens(aliens);
        aliens.clear();
    }
    
    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.astrometrics, this.sickBay);
    }
}
