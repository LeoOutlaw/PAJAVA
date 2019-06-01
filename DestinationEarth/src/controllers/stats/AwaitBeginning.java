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
    
    public IStates changeSettings(){
        return new AwaitSettings(getGameData());
    }
    
    @Override
    public IStates startGame(){
        getGameData().startgame();
        return new AwaitNewCrewMember(getGameData());
    }
}
