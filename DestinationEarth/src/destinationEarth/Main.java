
package destinationEarth;

import controllers.ObservableGame;
import ui.textUI.MenuTextUI;
import information.Members.*;
import information.Player;
import ui.gui.DestinationEarthView;
/**
 *
 * @author Leonardo
 */
public class Main {

   private MenuTextUI menuTextUI;
    
    public static void main(String[] args) {
        DestinationEarthView GUI = new DestinationEarthView(new ObservableGame());
        //MenuTextUI menuTextUI = new MenuTextUI();
    }
    
}
