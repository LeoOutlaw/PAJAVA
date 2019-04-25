/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.Members;

import controllers.GameData;


public class CommsOfficer extends Members{
    public CommsOfficer(){
        name = "CommsOfficer";
        attack = 1;
        movement = 1;
    }
    
    public String getName(){
        return name;
    }
    
    public int rollDiceNotAttack(GameData game){
        return game.rollDice();
    }
    
}

