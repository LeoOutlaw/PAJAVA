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
public class Doctor extends Members{
    public Doctor(){
        name = "Doctor";
        attack = 1;
        movement = 1;
    }
    
    @Override
    public String getName(){
        return name;
    }
    
}
