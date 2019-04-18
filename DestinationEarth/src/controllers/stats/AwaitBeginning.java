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
public class AwaitBeginning extends IStatesAdapter {
    public AwaitBeginning (GameData g){
        super(g);
    }
    
    public IStates selectHP(int hp){
        getGameData().getSettings().setHp(hp);
        return this;
    }
    
    public IStates selectHull(int hull){
        getGameData().getSettings().setHull(hull);
        return this;
    }
    
    @Override
    public IStates startGame(){
        getGameData().startgame();
        return new AwaitNewCrewMember(getGameData());
    }
}
