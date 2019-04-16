/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information.Members;

/**
 *
 * @author Tiago Alves
 */
public class SecurityOfficer extends Members {
    SecurityOfficer(){
        name = "SecurityOfficer";
        attack = 2;
        movement = 1;
    }
    
    public String getName(){
        return name;
    }
    
    public int getAttack(){ 
        return attack;
    }
    
    public void setAttack(int attack){
         this.attack = attack;
    }
    
    public int getMovement(){
        return movement;
    }
    
    public void setMovement(int movement){
         this.movement = movement;
    }
}
    

