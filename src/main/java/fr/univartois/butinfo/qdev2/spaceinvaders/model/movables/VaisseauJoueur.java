/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.EtatVulnerable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type VaisseauJoueur
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class VaisseauJoueur extends AbstractMovable {
    
    long timer;
    public IEtatVaisseau etat;
    
    /**
     * Crée une nouvelle instance de VaisseauJoueur.
     * 
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    public VaisseauJoueur(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(0);
        this.etat = new EtatVulnerable(game);
        this.timer = 0;
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
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Tir)
     */
    @Override
    public void collidedWith(Tir other) {
        //il n'y a rien ici, et c'est normal.  
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TirAlien)
     */
    @Override
    public void collidedWith(TirAlien other) {
        game.removeMovable(other);
        etat.handle();
        etat = etat.nextStateAfterShot();
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.VaisseauAlien)
     */
    @Override
    public void collidedWith(VaisseauAlien other) {
        //il n'y a rien ici, et c'est normal.
    }
    
    @Override
    public void collidedWith(VaisseauJoueur other) {
        //il n'y a rien ici, et c'est normal.  
    }
    
    @Override
    public boolean move(long delta) {
        etat = etat.nextStateAfterTime();
        return super.move(delta); 
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Mur)
     */
    @Override
    public void collidedWith(Mur other) {
        // impossible
    }
}
