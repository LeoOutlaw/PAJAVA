/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package information;

/**
 *
 * @author Leonardo
 */
public class Settings {
    private int hp, hull; 
    /*como podemos mudar a vida, hull e a journey
    temos de ter uma classe para guardar toda a informacao 
    para depois conseguir, ao mudar (nas Settings), implementar 
    no GameData
    */
    public Settings(){
        hp=8;
        hull=8;
    }
    
    public int getHp(){
        return hp;
    }
    
    public int getHull(){
        return hull;
    }
    
    public void setHp(int hp){
        this.hp = hp;
    }
    
    public void setHull(int hull){
        this.hull = hull;
    }
}
