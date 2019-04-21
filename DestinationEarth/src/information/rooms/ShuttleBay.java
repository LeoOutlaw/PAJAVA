/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.rooms;

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
    
    public void moveAlienToSickBay(){
        this.sickBay.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToAstrometrics(){
        this.astrometrics.moveAliens(aliens);
        aliens.clear();
    }
    
}
