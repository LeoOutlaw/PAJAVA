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
public class AwaitSettings extends IStatesAdapter{

    public AwaitSettings(GameData game) {
        super(game);
    }
        
    public IStates selectHP(int hp){
        getGameData().getSettings().setHp(hp);
        return this;
    }
    
    public IStates selectHull(int hull){
        getGameData().getSettings().setHull(hull);
        return this;
    }
    
    public IStates voltarMenu(){
        return new AwaitBeginning(getGameData());
    }
}
