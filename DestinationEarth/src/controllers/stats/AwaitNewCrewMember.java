/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.stats;

import controllers.GameData;
import information.Members.*;

/**
 *
 * @author Leonardo
 */
public class AwaitNewCrewMember extends IStatesAdapter {

    public AwaitNewCrewMember(GameData g) {
        super(g);
    }

    @Override
    public IStates chooseMember(int member) {
        switch (member) {
            case 1:
                getGameData().getPlayer().AddMember(new Doctor());
                System.out.println(getGameData().getPlayer().getMembers().size());
                break;
            case 2:
                getGameData().getPlayer().AddMember(new Captain());
                break;
        }
        if(getGameData().getPlayer().getMembers().size() == 2){
            for(int i = 0; i < getGameData().getPlayer().getMembers().size(); i++) {
                System.out.println(getGameData().getPlayer().getMembers().get(i));
            }
            //return new AwaitJourney(getGameData());
        }
        return this;
    }
}
