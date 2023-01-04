package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens;

import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.ITirsGeneral;

/**
 * @author thomas
 *
 */
public class TirAlienComposite implements IAlienAttaque {
    
    /**
     * 
     */
    Random random = new Random();
    
    /**
     * 
     */
    private SpaceInvadersGame game;
    
         
    
    /**
     * @param game
     */
    public TirAlienComposite(SpaceInvadersGame game) {
        this.game = game;
    }

    
    @Override
    public boolean tir() {
        int x = random.nextInt(1,100);
        if (x==69) {
            return true;
        }
        return false;
        
    }
    
    /**
     * @return
     */
    @Override
    public IAlienAttaque newStrategy() {
            int x = random.nextInt(1,4);
            if (x==1) {
                return new AlienTirePasStrategy();
            }
            else if (x==2) {
                return new AlienTireStrategy();
            }
            else {
                return new AlienTireIntelligent(game);
            }
            
        }

}
