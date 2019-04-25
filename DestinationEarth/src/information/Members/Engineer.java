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
public class Engineer extends Members{
    public Engineer(){
        name = "Engineer";
        attack = 1;
        movement = 1;
    }
    
    public String getName(){
        return name;
    }
    
    public void setHullInspiration(GameData game){
        game.getPlayer().setHp( game.getShip().getHull()+2);
    }
    
    public void setHullActionPoints(GameData game){
        game.getPlayer().setHp( game.getShip().getHull()+1);
    }
    
    public void setHullEngenniring(GameData game){ // Atencao na confirmaçao se esta mesmo na sala
        game.getPlayer().setHp( game.getShip().getHull()+1);
    }
    
}
    

