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
public class Commander extends Members {
    public Commander(GameData game){
        name = "Commander";
        attack = 1;
        movement = 1;
        game.getPlayer().setActionPoints(6);
    }
    
    public String getName(){
        return name;
    }
    
}
    

