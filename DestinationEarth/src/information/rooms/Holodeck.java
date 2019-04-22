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
public class Holodeck extends ShipRooms{
    
    private CrewQuarters crewQuarters;
    private WeaponsBay weaponsBay;
    
    public Holodeck(){
        name = "Holodeck";
        roomNumber = 11;
    }

    public void setCrewQuarters(CrewQuarters crewQuarters) {
        this.crewQuarters = crewQuarters;
    }

    public void setWeaponsBay(WeaponsBay weaponsBay) {
        this.weaponsBay = weaponsBay;
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
    
    
    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.crewQuarters, this.weaponsBay);
    }
    
}
