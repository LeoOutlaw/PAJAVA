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
public class MessHall extends ShipRooms{
        
    private SickBay sickBay;
    private Bridge bridge;
    private ConferenceRoom conferenceRoom;
    private CrewQuarters crewQuarters;
       
    
    public MessHall(){
        name = "MessHall";
        roomNumber = 8;
    }
    
    public String getName(){
        return name;
    }
    
    
    public void moveAlienToCrewQuarters(){
        this.crewQuarters.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToSickBay(){
        this.sickBay.moveAliens(aliens);
        aliens.clear();
    }
    public void moveAlienToConferenceRoom(){
        this.conferenceRoom.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToBridge(){
        this.bridge.moveAliens(aliens);
        aliens.clear();
    }
    
}
