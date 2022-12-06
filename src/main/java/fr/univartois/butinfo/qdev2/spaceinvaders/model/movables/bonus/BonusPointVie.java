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
 * Le type BonusPointVie
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class BonusPointVie extends AbstractMovable {

    /**
     * L'attribut nbPoints est le nombre de pv qui seront ajoutés au joueur s'il récupère ce bonus.
     */
    private int nbPoints;

    /**
     * Crée une nouvelle instance de BonusPointVie.
     * 
     * @param game Référence à un SpaceInvadersGame
     * @param xPosition La position horizontale de spawn.
     * @param yPosition La position verticale de spawn.
     * @param sprite Le sprite utilisé par le bonus.
     * @param verticalSpeed Le vitesse à laquelle le bonus descend.
     * @param nbPoints Le nombre de pv que donne ce bonus.
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
        // ne rien faire
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
        game.addPlayerLife(this.nbPoints);
        game.removeMovable(this);
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
        game.removeMovable(this);
        // si la bombe sur le bonus, bah bonus est perdu. Fallait mieux jouer.
    }
}
