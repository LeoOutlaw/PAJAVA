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
public class Brig extends ShipRooms{
    
    private ConferenceRoom conferenceRoom;
    private Engineering engineering;
   
    public Brig(){
        name = "Brig";
        roomNumber = 3;
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
}