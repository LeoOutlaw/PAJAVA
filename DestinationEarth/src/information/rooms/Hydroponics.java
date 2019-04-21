package information.rooms;

public class Hydroponics extends ShipRooms{
    
    private Engineering engineering;
    private Astrometrics astrometrics;
    
    public Hydroponics(){
        name = "MessHall";
        roomNumber = 12;
        neighbors[0] = 10;
        neighbors[1] = 9;
    }
    
    public String getName(){
        return name;
    }  
    
    
    public void moveAlienToEngineering(){
        this.engineering.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToAstrometrics(){
        this.astrometrics.moveAliens(aliens);
        aliens.clear();
    }
    
}
