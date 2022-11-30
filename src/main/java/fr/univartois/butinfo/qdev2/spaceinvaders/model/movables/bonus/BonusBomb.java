/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauJoueur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;


/**
 * Le type BonusMine
 *
 * @author Jules
 *
 * @version 0.1.0
 */
public class BonusBomb extends AbstractMovable {

    /**
     * L'attribut detonation...
     */
    long detonation = -10000;
    
    
    /**
     * Crée une nouvelle instance de BonusMine.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    public BonusBomb(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(0);
        this.setVerticalSpeed(-150);
        detonation=0;
    }
    
    @Override
    public boolean move(long delta) {
        detonation+=delta;
        boolean shouldMove = super.move(delta);  
        if (detonation>3000) {
            this.explode();
        }
        return shouldMove;
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
        detonation=0;
        this.setVerticalSpeed(0);
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien)
     */
    @Override
    public void collidedWith(VaisseauAlien other) {
        if (this.getVerticalSpeed()!=0) {
            game.removeMovable(this);
        }
    }
    /**
     * 
     */
    public void explode() {
        for (IMovable movable : game.getMovableObjects()) {
            if ((Math.abs(movable.getX()-this.getX())<100 || Math.abs(movable.getY()-this.getY())<100) && (! movable.equals(game.getShip()))) {
                game.removeMovable(movable);
            }
        }
        game.removeMovable(this);
    }
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauJoueur)
     */
    @Override
    public void collidedWith(VaisseauJoueur other) {
        // impossible
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TirAlien)
     */
    @Override
    public void collidedWith(TirAlien other) {
        // Il n'y a rien ici et c'est normal (une bombe résiste un tir d'alien)
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Mur)
     */
    @Override
    public void collidedWith(Mur other) {
        // Il n'y a rien ici et c'est normal (si qqn met un mur au dessus d'une bombe il est pas très intélligent xd
    }

}

