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
public class VaisseauAlien extends AbstractMovable{

    private IDeplacements deplacement;
    private IFireshotAlien shot;
    
    /**
     * Crée une nouvelle instance de VaisseauAlien.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     * @param deplacement
     */
    public VaisseauAlien(SpaceInvadersGame game, double xPosition, double yPosition,Sprite sprite, IDeplacements deplacement, IFireshotAlien shot) {
        super(game, xPosition, yPosition, sprite);
        this.deplacement = deplacement;
        this.setHorizontalSpeed(deplacement.getHorizontalSpeed());
        this.setVerticalSpeed(deplacement.getVerticalSpeed());   
        this.shot=shot;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long delta) {
        boolean x = super.move(delta);
        
        if (x == false) {
            if (this.getY()+this.getHeight()==game.getBottomLimit()) {
                game.alienReachedPlanet();
                return false;
            }
            if (this.getX()==game.getLeftLimit()) {
                setHorizontalSpeed(getHorizontalSpeed()*(-1.02));
                return false;
            }
            if (this.getX()+this.getWidth()==game.getRightLimit()) {
                setHorizontalSpeed(getHorizontalSpeed()*(-1.02));
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
     * (non-Javadoc)    private long lastShot = 0;
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauJoueur)
     */
    @Override
    public void collidedWith(VaisseauJoueur other) {
        game.playerIsDead();
        
    }
    
    public void shot(VaisseauAlien other) {
        other.;
    }

    
    /**
     * Donne l'attribut shot de cette instance de VaisseauAlien.
     *
     * @return L'attribut shot de cette instance de VaisseauAlien.
     */
    public IFireshotAlien getShot() {
        return shot;
    }

    
    /**
     * Modifie l'attribut shot de cette instance de VaisseauAlien.
     *
     * @param shot La nouvelle valeur de l'attribut shot pour cette instance de VaisseauAlien.
     */
    public void setShot(IFireshotAlien shot) {
        this.shot = shot;
    }
}

