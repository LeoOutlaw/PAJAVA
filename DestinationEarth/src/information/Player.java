package information;

  /*
    Aqui acho que temos de ter guardado informaçao sobre o player
    ou seja quem sao os membros quanta vida têm e em que sala 
    estam na SpaceShip
    */

import information.Members.*;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Leonardo
 */
public class Player {
    private int hp;
    private int hull;
    private int inspirationPoints;
    private List<Members> members;
    
    public Player(Settings a){
        inspirationPoints = 0;
        hp = a.getHp();
        hull = a.getHull();
        members = new ArrayList<>();
    }
       
    public void AddMember(Members member){
        this.members.add( member);
    }
    
    public List<Members> getMembers(){
        return members;
    }
    
    public int getHp(){
        return hp;
    }
    
    public int getInspirationPoints(){
        return inspirationPoints;
    }
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public void setInspirationPoints(int inspirationPoints){
        this.inspirationPoints = inspirationPoints;
    }
  
}
