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
public class CrewQuarters extends ShipRooms{
    
    private Holodeck holoDeck;
    private MessHall messHall;
    
    public CrewQuarters(){
        name = "CrewQuarters";
        roomNumber = 4;
    }
    
    public String getName(){
        return name;
    }
    
    public void moveAlienToHoloDeck(){
        this.holoDeck.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToMessHall(){
        this.messHall.moveAliens(aliens);
        aliens.clear();
    }
    
    
}
