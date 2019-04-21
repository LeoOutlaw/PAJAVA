/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information;

import information.rooms.Bridge;
import information.rooms.ConferenceRoom;
import information.rooms.MessHall;

/**
 *
 * @author Leonardo
 */
public class SpaceShip {

    Bridge bridge;
    ConferenceRoom conferenceRoom;
    MessHall messHall;

    public SpaceShip() {

        bridge = new Bridge();
        conferenceRoom = new ConferenceRoom();
        messHall = new MessHall();

        bridge.setConferenceRoom(conferenceRoom);
        bridge.setMessHall(messHall);

    }

    public Bridge getBridge() {
        return bridge;
    }

    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public MessHall getMessHall() {
        return messHall;
    }

    
    private int hull;
    /*
     Informaçao sobre a SpaceShip
     Temos de saber onde e que sao cada uma das salas 
     a que numeros correspondem e de que sala para que sala
     por se mover tantos os alliens como os membros
     */

    public int getHull() {
        return hull;
    }

    public void setHull(int hull) {
        this.hull = hull;
    }
}
