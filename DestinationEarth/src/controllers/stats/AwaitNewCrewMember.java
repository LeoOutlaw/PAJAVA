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
                break;
            case 2:
                getGameData().getPlayer().AddMember(new Captain());
                break;
            case 3:
                getGameData().getPlayer().AddMember(new Commander(getGameData()));
                break;
            case 4:
                getGameData().getPlayer().AddMember(new CommsOfficer());
                break;
            case 5:
                getGameData().getPlayer().AddMember(new Engineer());
                break;
            case 6:
                getGameData().getPlayer().AddMember(new MoralOfficer(getGameData()));
                break;
            case 7:
                getGameData().getPlayer().AddMember(new NavigationOfficer());
                break;
            case 8:
                getGameData().getPlayer().AddMember(new RedShirt());
                break;
            case 9:
                getGameData().getPlayer().AddMember(new ScienceOfficer());
                break;
            case 10:
                getGameData().getPlayer().AddMember(new SecurityOfficer());
                break;
            case 11:
                getGameData().getPlayer().AddMember(new ShuttlePilot());
                break;
            case 12:
                getGameData().getPlayer().AddMember(new TransporterChief());
                break;
        }
        if(getGameData().getPlayer().getMembers().size() == 2){
            for(int i = 0; i < getGameData().getPlayer().getMembers().size(); i++) {
                System.out.println("membros : " + getGameData().getPlayer().getMembers().get(i).getName());
            }
            return new SetupMembers(getGameData());
        }
        return this;
    }
}
