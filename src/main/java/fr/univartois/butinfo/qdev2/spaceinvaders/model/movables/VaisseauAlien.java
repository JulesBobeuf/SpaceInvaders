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

    private IDeplacements deplacement;
    private double facteur = 1.00;
    
    
    /**
     * Crée une nouvelle instance de VaisseauAlien.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     * @param deplacement
     */
    public VaisseauAlien(SpaceInvadersGame game, double xPosition, double yPosition,Sprite sprite, IDeplacements deplacement) {
        super(game, xPosition, yPosition, sprite);
        this.deplacement = deplacement;
        this.setHorizontalSpeed(deplacement.getHorizontalSpeed(25));
        this.setVerticalSpeed(deplacement.getVerticalSpeed(25));
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long delta) {
        boolean x = super.move(delta);        
        setVerticalSpeed(deplacement.getVerticalSpeed(delta));
        
        if (!x) {
            if (this.getY()+this.getHeight()==game.getBottomLimit()) {
                game.alienReachedPlanet();
                return false;
            }
            if (this.getX()==game.getLeftLimit()) {
                setHorizontalSpeed(deplacement.getHorizontalSpeed(delta)*(facteur));
                facteur += 0.02;
                return false;
            }
            if (this.getX()+this.getWidth()==game.getRightLimit()) {
                setHorizontalSpeed(deplacement.getHorizontalSpeed(delta)*(-facteur));
                facteur += 0.02;
                return false;
            }
                        
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
        game.alienIsDead(this);
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
    
    public void alienShot(VaisseauAlien other) {
        
    }

}

