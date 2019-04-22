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

    public void setSickBay(SickBay sickBay) {
        this.sickBay = sickBay;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public void setCrewQuarters(CrewQuarters crewQuarters) {
        this.crewQuarters = crewQuarters;
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
    
    
    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.conferenceRoom, this.crewQuarters, this.bridge, this.sickBay);
    }
    
}
