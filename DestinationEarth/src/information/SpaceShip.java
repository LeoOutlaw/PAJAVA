/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information;

import information.rooms.Astrometrics;
import information.rooms.Bridge;
import information.rooms.Brig;
import information.rooms.ConferenceRoom;
import information.rooms.CrewQuarters;
import information.rooms.Engineering;
import information.rooms.Holodeck;
import information.rooms.Hydroponics;
import information.rooms.MessHall;
import information.rooms.ShipRooms;
import information.rooms.ShuttleBay;
import information.rooms.SickBay;
import information.rooms.WeaponsBay;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leonardo
 */
public class SpaceShip {

    private int hull;
    private final Bridge bridge;
    private final ConferenceRoom conferenceRoom;
    private final MessHall messHall;
    private final Astrometrics astrometrics;
    private final Brig brig;
    private final CrewQuarters crewQuarters;
    private final Engineering engineering;
    private final Holodeck holodeck;
    private final Hydroponics hydroponics;
    private final ShuttleBay shuttleBay;
    private final SickBay sickBay;
    private final WeaponsBay weaponsBay;

    public SpaceShip(Settings a) {
        hull = a.getHull();
        bridge = new Bridge();
        conferenceRoom = new ConferenceRoom();
        astrometrics = new Astrometrics();
        brig = new Brig();
        crewQuarters = new CrewQuarters();
        engineering = new Engineering();
        holodeck = new Holodeck();
        hydroponics = new Hydroponics();
        messHall = new MessHall();
        shuttleBay = new ShuttleBay();
        sickBay = new SickBay();
        weaponsBay = new WeaponsBay();

        setRoomNeighbours();
    }

    private void setRoomNeighbours() {
        bridgeSetup();
        conferenceRoomSetup();
        brigSetup();
        engineeringSetup();
        hydroponicsSetup();
        astrometricsSetup();
        shuttlebaySetup();
        sickbaySetup();
        weaponsbaySetup();
        holodeckSetup();
        crewQuartersSetup();
        messhallSetup();
    }

    private void messhallSetup() {
        messHall.setBridge(bridge);
        messHall.setConferenceRoom(conferenceRoom);
        messHall.setCrewQuarters(crewQuarters);
        messHall.setSickBay(sickBay);
    }

    private void crewQuartersSetup() {
        crewQuarters.setHoloDeck(holodeck);
        crewQuarters.setMessHall(messHall);
    }

    private void holodeckSetup() {
        holodeck.setCrewQuarters(crewQuarters);
        holodeck.setWeaponsBay(weaponsBay);
    }

    private void weaponsbaySetup() {
        weaponsBay.setHolodeck(holodeck);
        weaponsBay.setSickBay(sickBay);
    }

    private void sickbaySetup() {
        sickBay.setMessHall(messHall);
        sickBay.setWeaponsBay(weaponsBay);
    }

    private void shuttlebaySetup() {
        shuttleBay.setAstrometrics(astrometrics);
        shuttleBay.setSickBay(sickBay);
    }

    private void astrometricsSetup() {
        astrometrics.setConferenceRoom(conferenceRoom);
        astrometrics.setHydroponics(hydroponics);
        astrometrics.setShuttleBay(shuttleBay);
    }

    private void hydroponicsSetup() {
        hydroponics.setAstrometrics(astrometrics);
        hydroponics.setEngineering(engineering);
    }

    private void engineeringSetup() {
        engineering.setBrig(brig);
        engineering.setHydroponics(hydroponics);
    }

    private void brigSetup() {
        brig.setConferenceRoom(conferenceRoom);
        brig.setEngineering(engineering);
    }

    private void conferenceRoomSetup() {
        conferenceRoom.setBridge(bridge);
        conferenceRoom.setBrig(brig);
        conferenceRoom.setAstrometrics(astrometrics);
        conferenceRoom.setMessHall(messHall);
    }

    private void bridgeSetup() {
        //set bridge neighbours
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

    public List<ShipRooms> getRooms() {
        return Arrays.asList(bridge, conferenceRoom, messHall, brig, crewQuarters, engineering, astrometrics, sickBay, holodeck, hydroponics, weaponsBay, shuttleBay);
        //return Arrays.asList(bridge, conferenceRoom);
    }
}
