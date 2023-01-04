package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens;


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
     * @param game Instance de SpaceInvadersGame
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
        return game.getShip().getX()==500;
    }
}

