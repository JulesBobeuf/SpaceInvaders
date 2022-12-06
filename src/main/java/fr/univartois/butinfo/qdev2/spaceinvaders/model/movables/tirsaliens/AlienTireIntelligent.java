package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens;
import java.util.Timer;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

/**
 * Le type AlienTireStrategy
 *
 * @author thomas
 *
 * @version 0.1.0
 */
/**
 * 
 */
public class AlienTireIntelligent implements IAlienAttaque {
    
    /**
     * 
     */
    private SpaceInvadersGame game;

    
    final long SHOT_TEMPORIZATION = 500;
    
    /**
     * @param game
     */
    public AlienTireIntelligent(SpaceInvadersGame game) {
        this.game = game;
    }
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IAlienAttaque#tir()
     */
    @Override
    public boolean tir() {
        long lastShot= System.currentTimeMillis();
            if (game.getShip().getX()==500) {
                if(lastShot + SHOT_TEMPORIZATION > System.currentTimeMillis())
                    return true;
            }
        return false;
    }
}

