/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusShield;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type VaisseauJoueur
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class VaisseauJoueur extends AbstractMovable {
    
    
    /**
     * L'attribut etat, qui permet de gérer si le vaisseau est invincible ou non, et d'exécuter sa méthode handle() en fonction.
     */
    private IEtatVaisseau etat;
    
    /**
     * Crée une nouvelle instance de VaisseauJoueur.
     * 
     * @param game référence à SpaceInvadersGame
     * @param xPosition double la position horizontale
     * @param yPosition double la position verticale
     * @param sprite le sprite du vaisseau
     */
    public VaisseauJoueur(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(0);
        this.etat = new EtatVulnerable(game);
    }
    
    /**
     * Donne l'attribut etat de cette instance de VaisseauJoueur.
     *
     * @return L'attribut etat de cette instance de VaisseauJoueur.
     */
    public IEtatVaisseau getEtat() {
        return etat;
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
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb)
     */
    @Override
    public void collidedWith(BonusBomb other) {
        etat.handle();
        etat = etat.nextStateAfterShot();
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
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.BonusShield)
     */
    @Override
    public void collidedWith(BonusShield other) {
        game.removeMovable(other);
        etat = etat.nextStateAfterShot();
    }
}
