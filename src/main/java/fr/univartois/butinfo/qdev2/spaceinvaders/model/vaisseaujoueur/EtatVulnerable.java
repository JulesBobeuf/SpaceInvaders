/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.vaisseaujoueur;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type EtatVulnerable
 *
 * @author pierre.schreiner
 *
 * @version 0.1.0
 */
public class EtatVulnerable implements IEtatVaisseau {
    
    private SpaceInvadersGame game;
    
    public EtatVulnerable(SpaceInvadersGame game) {
        this.game=game;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau#handle()
     */
    @Override
    public void handle() {
        game.reducePlayerLife();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau#nextState()
     */
    @Override
    public IEtatVaisseau nextStateAfterShot() {
        if (game.getLife() != 0) {
            game.getShip().setSprite(SpriteStore.getInstance().getSprite("shipInvincible"));
            return new EtatInvulnerable(game);
        }
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau#nextStateAfterTime()
     */
    @Override
    public IEtatVaisseau nextStateAfterTime() {
        return this;
    }    
}

