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
public class Brig extends ShipRooms{
    
    private ConferenceRoom conferenceRoom;
    private Engineering engineering;
   
    public Brig(){
        name = "Brig";
        roomNumber = 3;
        canBeSealed = true;
    }
    
    public String getName(){
        return name;
    }
    
    public void moveAlienToConferenceRoom(){
        this.conferenceRoom.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToEngineering(){
        this.engineering.moveAliens(aliens);
        aliens.clear();
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public void setEngineering(Engineering engineering) {
        this.engineering = engineering;
    }
    
    
    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.conferenceRoom, this.engineering);
    }
    
}