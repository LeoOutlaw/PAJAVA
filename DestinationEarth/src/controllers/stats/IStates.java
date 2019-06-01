/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import information.Members.Members;
import information.rooms.ShipRooms;

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
    IStates setActionPoints();
    IStates chooseOption(int option, Members member);
    IStates clearAlliens();
    IStates moveAliens();
    IStates CombatPhase();
    IStates journeyEnded();
    IStates endGame();
    IStates crewMemberDieded();
    IStates changeSettings();
    IStates voltarMenu();
    IStates chooseAPOption(int option, ShipRooms room, Members member, int roomOption, int attack) ;
}
