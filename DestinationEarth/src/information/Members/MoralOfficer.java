/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.Members;

import controllers.GameData;

/**
 *
 * @author Tiago Alves
 */
public class MoralOfficer extends Members {
    public MoralOfficer(GameData game){
        name = "MoralOfficer";
        attack = 1;
        movement = 1;
        game.getPlayer().setInspirationPoints(5);
    }
    
    public String getName(){
        return name;
    }
}
 
