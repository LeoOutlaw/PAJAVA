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
public class Captain extends Members{
    public Captain(){
        name = "Captain";
        attack = 1;
        movement = 1;
    }
    
    public String getName(){
        return name;
    }
    
}
