/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.vaisseaujoueur.VaisseauJoueur;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type BonusShield est un bonus qui rend le joueur invulnérable.
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class BonusShield extends AbstractMovable {

    /**
     * Crée une nouvelle instance de BonusShield.
     * 
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     * @param verticalSpeed
     * @param nbPoints
     */
    public BonusShield(SpaceInvadersGame game, double xPosition, double yPosition,
            Sprite sprite, double verticalSpeed) {
        super(game, xPosition, yPosition, sprite);
        this.setVerticalSpeed(verticalSpeed);
        this.setHorizontalSpeed(0);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void collidedWith(IMovable other) {
        other.collidedWith(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.Tir)
     */
    @Override
    public void collidedWith(Tir other) {
        // ne rien faire
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien)
     */
    @Override
    public void collidedWith(VaisseauAlien other) {
        // ne rien faire
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.VaisseauJoueur)
     */
    @Override
    public void collidedWith(VaisseauJoueur other) {
        // ne rien faire
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TirAlien)
     */
    @Override
    public void collidedWith(TirAlien other) {
        // ne rien faire
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Mur)
     */
    @Override
    public void collidedWith(Mur other) {
        // ne rien faire
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb)
     */
    @Override
    public void collidedWith(BonusBomb other) {
        // ne rien faire
    }

}
