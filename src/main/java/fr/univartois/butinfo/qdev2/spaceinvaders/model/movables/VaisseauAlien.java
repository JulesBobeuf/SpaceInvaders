/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 thomas.santoro
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.IDeplacements;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.IAlienAttaque;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur.VaisseauJoueur;
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
     * L'attribut deplacement...
     */
    private IDeplacements deplacement;
    /**
     * L'attribut facteur...
     */
    private double facteur = 1.00;
    
    /**
     * L'attribut attack...
     */
    private IAlienAttaque attack;
    
    /**
     * 
     */
    private boolean changedStrategyAttack;

    /**
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     * @param deplacement
     * @param attack
     */
    public VaisseauAlien(SpaceInvadersGame game, double xPosition, double yPosition,Sprite sprite, IDeplacements deplacement, IAlienAttaque attack) {
        super(game, xPosition, yPosition, sprite);
        this.deplacement = deplacement;
        this.setHorizontalSpeed(deplacement.getHorizontalSpeed(25));
        this.setVerticalSpeed(deplacement.getVerticalSpeed(25));
        this.attack=attack;
        this.changedStrategyAttack=false;
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
        boolean tir = attack.tir();
        if (tir) {
            game.fireShotAlien(this);
        }
        if ((game.getNbRemainingAliens()<10) && (changedStrategyAttack==false)) {
            game.changeTirAlien(this);
            changedStrategyAttack=true;
        }
        if (!x) {
            if (this.getY()+this.getHeight()==game.getBottomLimit()) {
                game.alienReachedPlanet();
                return false;
            }
            if (this.getX()==game.getLeftLimit()) {
                setHorizontalSpeed(deplacement.getHorizontalSpeed(delta)*(facteur));
                facteur += 0.02;
                game.changeTirAlien(this);
                game.changeDeplacementAlien(this);
                return false;
            }
            if (this.getX()+this.getWidth()==game.getRightLimit()) {
                setHorizontalSpeed(deplacement.getHorizontalSpeed(delta)*(-facteur));
                facteur += 0.02;
                game.changeTirAlien(this);
                game.changeDeplacementAlien(this);
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
    
    /**
     * @param attack
     */
    public void setAlienAttack(IAlienAttaque attack) {
        this.attack=attack;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TirAlien)
     */
    @Override
    public void collidedWith(TirAlien other) {
        //il n'y a rien ici, et c'est normal.
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Mur)
     */
    @Override
    public void collidedWith(Mur other) {
        //il n'y a rien ici et c normal
    }

    
    /**
     * @return
     */
    public IDeplacements getDeplacement() {
        return deplacement;
    }

    
    /**
     * @param deplacement
     */
    public void setDeplacement(IDeplacements deplacement) {
        this.deplacement = deplacement;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb)
     */
    @Override
    public void collidedWith(BonusBomb other) {
        other.collidedWith(this);
        
    }
}

