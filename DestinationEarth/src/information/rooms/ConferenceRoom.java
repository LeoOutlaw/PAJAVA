/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.rooms;

public class ConferenceRoom extends ShipRooms{
   
    private Brig brig;
    private Astrometrics astrometrics;
    private MessHall messHall;
    private Bridge bridge;
    
    public ConferenceRoom() {
        name = "ConferenceRoom";
        roomNumber = 5;
    }
    
    public String getName(){
        return name;
    }
    
    public void moveAlienToBrig(){
        this.brig.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToAstrometrics(){
        this.astrometrics.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToBridge(){
        this.bridge.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToMessHall(){
        this.messHall.moveAliens(aliens);
        aliens.clear();
    }
}

