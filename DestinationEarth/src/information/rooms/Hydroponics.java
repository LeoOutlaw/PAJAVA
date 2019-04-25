package information.rooms;

import java.util.Arrays;
import java.util.List;

public class Hydroponics extends ShipRooms{
    
    private Engineering engineering;
    private Astrometrics astrometrics;
    
    public Hydroponics(){
        name = "MessHall";
        roomNumber = 12;
        //vizinhos.addAll(Arrays.asList(new Engineering(), new Astrometrics()));
    }
    
    public String getName(){
        return name;
    }  

    public void setEngineering(Engineering engineering) {
        this.engineering = engineering;
    }

    public void setAstrometrics(Astrometrics astrometrics) {
        this.astrometrics = astrometrics;
    }
    
    public void moveAlienToEngineering(){
        this.engineering.moveAliens(aliens);
        aliens.clear();
    }
    
    public void moveAlienToAstrometrics(){
        this.astrometrics.moveAliens(aliens);
        aliens.clear();
    }
    
    
    @Override
    public List<ShipRooms> getNeighbours() {
        //return this.vizinhos;
        return Arrays.asList(this.engineering, this.astrometrics);
    }
    
}
