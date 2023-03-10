/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.SpriteStore;

/**
 * Le type EtatVulnerable
 *
 * @author pierre.schreiner
 *
 * @version 0.1.0
 */
public class EtatInvulnerable implements IEtatVaisseau {
    
    /**
     * Instance de SpaceInvadersGame
     */
    private SpaceInvadersGame game;
    
    /**
     * L'heure en ms où le joueur est devenu invincible.
     */
    private long timeOfCreation;
    
    /**
     * La durée de l'invincibilité en ms.
     */
    private long invincibilityDuration = 2_000;
    
    /**
     * Crée une nouvelle instance de EtatInvulnerable.
     * @param game Instance de SpaceInvadersGame
     */
    public EtatInvulnerable(SpaceInvadersGame game) {
        timeOfCreation = System.currentTimeMillis();
        this.game=game;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau#handle()
     */
    @Override
    public void handle() {
        // le joueur ne prend pas de dégat.
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau#nextStateAfterShot()
     */
    @Override
    public IEtatVaisseau nextStateAfterShot() {
        return this;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IEtatVaisseau#nextStateAfterTime()
     */
    @Override
    public IEtatVaisseau nextStateAfterTime() {
        if (System.currentTimeMillis() > (timeOfCreation + invincibilityDuration)) {
            game.getShip().setSprite(SpriteStore.getInstance().getSprite("ship"));
            return new EtatVulnerable(game);
        }
        return this;
    }    
}

