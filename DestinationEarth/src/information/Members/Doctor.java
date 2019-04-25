/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.Members;

import controllers.GameData;

/**
 *
 * @author Leonardo
 */
public class Doctor extends Members{
    public Doctor(){
        name = "Doctor";
        attack = 1;
        movement = 1;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
    public void setHpInspiration(GameData game){
        game.getPlayer().setHp( game.getPlayer().getHp()+2);
    }
    
    public void setHpActionPoints(GameData game){
        game.getPlayer().setHp( game.getPlayer().getHp()+1);
    }
    
    public void setHpSickbay(GameData game){ // Atencao na confirmaçao se esta mesmo na sala
        game.getPlayer().setHp( game.getPlayer().getHp()+1);
    }
    
}
