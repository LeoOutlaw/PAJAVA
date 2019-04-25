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
public class AwaitCrewPhase extends IStatesAdapter{
    
    public AwaitCrewPhase(GameData game) {
        super(game);
    }
    
    public IStates passCrewPhase(){
        getGameData().setTurnActionPoints();
        getGameData().advanceTurn();
        return new AwaitAlienPhase(getGameData());
    }
}
