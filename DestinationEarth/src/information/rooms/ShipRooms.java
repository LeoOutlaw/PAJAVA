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
    List<Members> users;
   // List<ShipRooms>vizinhos;
    
    public abstract List<ShipRooms> getNeighbours();
    
    public ShipRooms() {
        aliens = new ArrayList();
        users = new ArrayList();
        //vizinhos = new ArrayList();
    }
    
    public void setUser(Members user) {
        this.users.add(user);
    }
    
    public void removeUser(Members user){
        this.users.remove(user);
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
    
    public void addAlien(Alien alien) {
        this.aliens.add(alien);
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

    public List<Members> getUser() {
        return users;
    }
    
    @Override
    public String toString() {
        if (users != null && users.size() > 0) {
            return "ShipRoom{" + "roomNumber=" + roomNumber + ", name=" + name + ", sealed=" + sealed + ", hasOrganicDetonator=" + hasOrganicDetonator + ", hasParticleDisperser=" + hasParticleDisperser + ", aliens=" + aliens + ", user=" + users + "} \\n";
        } else {
            return "ShipRoom{" + "roomNumber=" + roomNumber + ", name=" + name + ", sealed=" + sealed + ", hasOrganicDetonator=" + hasOrganicDetonator + ", hasParticleDisperser=" + hasParticleDisperser + ", aliens=" + aliens + ", user= NO_USER} \\n";
        }
    }

    public void deleteAllAliens() {
        this.aliens.clear();
    }
}
