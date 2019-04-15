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
public class JourneyTracker {
    private String [] journeyTracker = new String [13];
    
    public void setJourneyTracker(String [] journeyTracker){
        this.journeyTracker = journeyTracker;
    }
    
    public String [] getJourneyTracker(){
        return journeyTracker;
    }
}
