package information.rooms;

import information.Members.Members;
import information.alien.Alien;
import java.util.List;
import java.util.ArrayList;

public abstract class ShipRooms {

    int roomNumber;
    String name;
    int[] neighbors;
    private boolean sealed;
    private boolean hasOrganicDetonator;
    private boolean hasParticleDisperser;
    List<Alien> aliens;

    Members user;

    public void setUser(Members user) {
        this.user = user;
    }

    public ShipRooms() {
        aliens = new ArrayList();
    }

    //List<Integer> listNeighbors = new ArrayList<>() ;
    public int[] getNeighbors() {
        return neighbors;
    }

    /*public Integer getListNeighbors(){
     for (int i = 0; i < listNeighbors.get(listNeighbors.size() - 1); i++)
          
     return listNeighbors.get(i);
      
     }
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    public void setMovement(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getName() {
        return name;
    }

    public void moveAliens(List<Alien> aliens) {
        this.aliens.addAll(aliens);
    }

    public void setOrganicDetonator() {
        this.hasOrganicDetonator = true;
    }

    public void unsetOrganicDetonator() {
        this.hasOrganicDetonator = false;
    }

    public void setParticleDisperser() {
        this.hasParticleDisperser = true;
    }

    public void unsetParticleDisperser() {
        this.hasParticleDisperser = false;
    }

    public boolean isSealed() {
        return sealed;
    }

    public boolean isHasOrganicDetonator() {
        return hasOrganicDetonator;
    }

    public boolean isHasParticleDisperser() {
        return hasParticleDisperser;
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public Members getUser() {
        return user;
    }
    
    

    @Override
    public String toString() {
        if (user != null) {
            return "ShipRooms{" + "roomNumber=" + roomNumber + ", name=" + name + ", neighbors=" + neighbors + ", sealed=" + sealed + ", hasOrganicDetonator=" + hasOrganicDetonator + ", hasParticleDisperser=" + hasParticleDisperser + ", aliens=" + aliens + ", user=" + user.getName() + '}';
        } else {
            return "ShipRooms{" + "roomNumber=" + roomNumber + ", name=" + name + ", neighbors=" + neighbors + ", sealed=" + sealed + ", hasOrganicDetonator=" + hasOrganicDetonator + ", hasParticleDisperser=" + hasParticleDisperser + ", aliens=" + aliens + ", user= NO_USER}";
        }
    }
}
