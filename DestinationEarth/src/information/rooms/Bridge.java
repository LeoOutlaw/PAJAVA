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
public class Bridge extends ShipRooms{
    private ConferenceRoom conferenceRoom;
    private MessHall messHall;
    
    public Bridge(){
        name = "Bridge";
        roomNumber = 1;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

    public void setMessHall(MessHall messHall) {
        this.messHall = messHall;
    }
    
    public String getName(){
        return name;
    }
   
    public void moveAlienToConferenceRoom(){
        this.conferenceRoom.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToMessHall(){
        this.messHall.moveAliens(aliens);
        aliens.clear();
    } 

    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.conferenceRoom, this.messHall);
    }}
