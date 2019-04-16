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
public class NavigationOfficer extends Members{
    NavigationOfficer(){
        name = "NavigatioOfficer";
        attack = 1;
        movement = 2;
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
    

