
package destinationEarth;

import ui.textUI.MenuTextUI;
import information.Members.*;
import information.Player;
/**
 *
 * @author Leonardo
 */
public class Main {

   private MenuTextUI menuTextUI;
    
    public static void main(String[] args) {
        Members menber = new SecurityOfficer();
        Members member = new Doctor();
        Player player = new Player(menber, member);
        System.out.println(player.getMembers());
        //MenuTextUI menuTextUI = new MenuTextUI();
    }
    
}
