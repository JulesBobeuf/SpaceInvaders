package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;


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
        if (game.getShip().getY()==200) {
            return true;
        }
        else {
            return false;
        }
    }

}

