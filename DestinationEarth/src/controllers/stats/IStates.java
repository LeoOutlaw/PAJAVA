/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

/**
 * Neste package faremos a maquina de estados toda
 * @author Leonardo
 */
public interface IStates {
    IStates selectHP(int hp);
    IStates selectHull( int hull);
    IStates startGame();
    IStates chooseMember(int member);
    IStates setPlayers();
    IStates journeyTracker(int length);
    IStates allienAssign(int n_alliens);
    IStates passCrewPhase();
    IStates setActionPoints();
}
