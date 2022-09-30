/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 thomas.santoro
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type VaisseauAlien
 *
 * @author thomas.santoro
 *
 * @version 0.1.0
 */
public class VaisseauAlien extends AbstractMovable {

    /**
     * Crée une nouvelle instance de VaisseauAlien.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    protected VaisseauAlien(SpaceInvadersGame game, double xPosition, double yPosition,Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(75.00);
        this.setVerticalSpeed(1.00);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long delta) {
        boolean x = super.move(delta);
        if (x == false)
            if (this.getY()==game.getBottomLimit()) {
                game.alienReachedPlanet();
                return false;
            }
            if (this.getX()==game.getLeftLimit()) {
                this.setHorizontalSpeed(-(getHorizontalSpeed()*1.02));
                return false;
            }
            if (this.getX()==game.getRightLimit()) {
                this.setHorizontalSpeed(-(getHorizontalSpeed()*1.02));
                return false;
            }
        return true;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void collidedWith(IMovable other) {
        other.collidedWith(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Tir)
     */
    @Override
    public void collidedWith(Tir other) {
        //il n'y a rien ici, et c'est normal.
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien)
     */
    @Override
    public void collidedWith(VaisseauAlien other) {
        //il n'y a rien ici, et c'est normal.  
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauJoueur)
     */
    @Override
    public void collidedWith(VaisseauJoueur other) {
        game.playerIsDead();
        
    }
    

}

