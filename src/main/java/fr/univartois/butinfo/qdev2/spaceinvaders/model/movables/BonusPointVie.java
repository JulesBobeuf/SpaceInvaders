/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type BonusPointVie
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class BonusPointVie extends AbstractMovable {

    private int nbPoints;

    /**
     * Crée une nouvelle instance de BonusPointVie.
     * 
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     * @param verticalSpeed
     * @param nbPoints
     */
    public BonusPointVie(SpaceInvadersGame game, double xPosition, double yPosition,
            Sprite sprite, double verticalSpeed, int nbPoints) {
        super(game, xPosition, yPosition, sprite);
        this.setVerticalSpeed(verticalSpeed);
        this.setHorizontalSpeed(0);
        this.nbPoints = nbPoints;
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
        game.addPlayerLife(this.nbPoints);
        game.removeMovable(this);
    }

}
