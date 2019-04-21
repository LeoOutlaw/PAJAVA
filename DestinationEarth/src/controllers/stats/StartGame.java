/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
/**
 *
 * @author Leonardo
 */
public class StartGame extends IStatesAdapter {
        
   
    public StartGame (GameData g){
        super(g);
    }
    
    public void mygame(){
        System.out.println("This is the start og the game");
    }
}
