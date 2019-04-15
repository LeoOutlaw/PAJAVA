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
    public abstract int getMovement();
    public abstract void setMovement(int movement);
    public abstract int getAttack();
    public abstract void setAttack(int attack);
}
