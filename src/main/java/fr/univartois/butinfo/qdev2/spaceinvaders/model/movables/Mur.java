/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


/**
 * Le type Mur
 *
 * @author Jules
 *
 * @version 0.1.0
 */
public class Mur extends AbstractMovable {
    
    private IntegerProperty vie = new SimpleIntegerProperty();
    
    private IStateMur state=new MurStateNormal();

    /**
     * Crée une nouvelle instance de Mur.
     * @param game
     * @param xPosition
     * @param yPosition
     * @param sprite
     */
    public Mur(SpaceInvadersGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        this.setHorizontalSpeed(0);
        this.setVerticalSpeed(0);
        vie.set(3);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public void collidedWith(IMovable other) {
        this.losesLife();
        other.collidedWith(this);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Tir)
     */
    @Override
    public void collidedWith(Tir other) {
        this.losesLife();
        game.removeMovable(other);
        if (vie.get()==0) {
            game.removeMovable(this);
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien)
     */
    @Override
    public void collidedWith(VaisseauAlien other) {
        this.losesLife();
        game.removeMovable(other);
        if (vie.get()==0) {
            game.removeMovable(this);
        }
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
    
    /**
     * @param state
     */
    public void setState(IStateMur state) {
        this.state=state;
    }
    
    /**
     * @return
     */
    public IStateMur getState() {
        return state;
    }
    
    private void losesLife() {
        vie.set(vie.get()-1);
        this.setState(state.getNextState());
        game.changeMurSprite(this);
    }

}

