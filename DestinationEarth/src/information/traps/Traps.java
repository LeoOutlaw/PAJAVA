package information.traps;

import controllers.GameData;

import java.io.Serializable;
/**
 *
 * @author Leonardo
 */
public abstract class Traps {
    String name;
    
    public abstract String getName();
    
    public boolean action(GameData gameData){return false;}
}
