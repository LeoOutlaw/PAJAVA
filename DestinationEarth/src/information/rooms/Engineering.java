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
public class Engineering extends ShipRooms{
    private Brig brig;
    private Hydroponics hydroponics;
    
    public Engineering(){
        name = "Engineering";
        roomNumber = 9;        
    }
    
    public String getName(){
        return name;
    }
    
    public void moveAlienToBrig(){
        this.brig.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToHydroponics(){
        this.hydroponics.moveAliens(aliens);
        aliens.clear();
    }
    
}
