/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.rooms;

import information.alien.Alien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tiago Alves
 */
public class Astrometrics extends ShipRooms{
    
    private ConferenceRoom conferenceRoom;
    private Hydroponics hydroponics;
    
    public Astrometrics(){
        name = "Astrometrics";
        roomNumber = 10;
    }
    
    public String getName(){
        return name;
    }
    
    public void setConferenceRoom(ConferenceRoom conferenceRoom){
        this.conferenceRoom = conferenceRoom;
    }
    
    public void setHydroponics(Hydroponics hydroponics){
        this.hydroponics = hydroponics;
    }
    
    public void moveAlienToHydroponics(){
        this.hydroponics.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToConferenceRoom(){
        this.conferenceRoom.moveAliens(aliens);
        aliens.clear();
    }   
}
