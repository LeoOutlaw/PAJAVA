package information.alien;

import controllers.GameData;
import information.dices.Dice;
import information.rooms.ShipRooms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Alien {
    private GameData game;
    
    public Alien(GameData g){
        game = g;
    }
    
    public void attackAlienMember(){
        Random rand = new Random();
        if (rand.nextInt(6) + 1 >= 5){
            game.getPlayer().setHp(game.getPlayer().getHp()-1);
        }
    }
    
    public void attackAlienShip(){
        game.getShip().setHull(game.getShip().getHull()-1);
    }
    
    public ShipRooms moveRandomAlien( ShipRooms shipRoom){
        Random rd = new Random();  
        return shipRoom.getNeighbours().get(rd.nextInt(shipRoom.getNeighbours().size()));
    }
    
}
