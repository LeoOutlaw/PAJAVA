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
public class SickBay extends ShipRooms{
    
    private MessHall messHall;
    private WeaponsBay weaponsBay;
    
    public SickBay(){
        name = "SickBay";
        roomNumber = 2;
        canBeSealed = false;
    }
    
    public String getName(){
        return name;
    }
        
    public void moveAlienToMessHall(){
        this.messHall.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToWeaponsBay(){
        this.weaponsBay.moveAliens(aliens);
        aliens.clear();
    }

    public void setMessHall(MessHall messHall) {
        this.messHall = messHall;
    }

    public void setWeaponsBay(WeaponsBay weaponsBay) {
        this.weaponsBay = weaponsBay;
    }
    
    @Override
    public List<ShipRooms> getNeighbours() {
        return Arrays.asList(this.messHall, this.weaponsBay);
    }
}
