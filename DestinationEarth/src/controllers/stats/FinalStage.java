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
public class FinalStage extends IStatesAdapter{
    
    public FinalStage(GameData game) {
        super(game);
    }
    
    public IStates endGame() {

        if(getGameData().isGameOver())
            getGameData().setMsg("Morreste! :(\nPara a proxima corre melhor!");
        else {
            getGameData().setMsg("Boa! Ganhaste o jogo! Cheira-me a aldrabice...");
        }
        return new AwaitBeginning(getGameData());
    }
}
