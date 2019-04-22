/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.Members;


/**
 *
 * @author Leonardo
 */
public abstract class Members {
    String name;
    int attack;
    int movement;
    
    public abstract String getName();
    
    public int getMovement(){
        return movement;
    }
    
    public void setMovement(int movement){
        this.movement = movement;
    }
    
    public int getAttack(){ 
        return attack;
    }
    
    public void setAttack(int attack){
         this.attack = attack;
    }

    @Override
    public String toString() {
        return "Members{" + "name=" + name + '}';
    }
    
    
}
