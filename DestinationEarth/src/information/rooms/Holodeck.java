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
public class Holodeck extends ShipRooms{
    
    private CrewQuarters crewQuarters;
    private WeaponsBay weaponsBay;
    
    public Holodeck(){
        name = "Holodeck";
        roomNumber = 11;
    }
    
    public String getName(){
        return name;
    }    
    
    public void moveAlienToCrewQuarters(){
        this.crewQuarters.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToWeaponsbay(){
        this.weaponsBay.moveAliens(aliens);
        aliens.clear();
    }
    
    
    
}
