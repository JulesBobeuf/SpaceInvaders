/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TrucResistantDecorateur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusPointVie;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.TirPuissantDecorateur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;

/**
 * Le type MovableFactory2
 *
 * @author Jules
 *
 * @version 0.1.0
 */
public class MovableFactory3 implements IMovableFactory {
    
    /**
     * L'attribut spriteStore...
     */
    private ISpriteStore spriteStore;
    /**
     * L'attribut random...
     */
    private Random random = new Random();
    /**
     * L'attribut game...
     */
    private SpaceInvadersGame game;
    /**
     * L'attribut movableFactory...
     */
    private final IMovableFactory movableFactory = new MovableFactory();

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;     
        this.movableFactory.setSpriteStore(spriteStore);
    }
    

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setGame(fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame)
     */
    @Override
    public void setGame(SpaceInvadersGame game) {
        this.game=game;
        this.movableFactory.setGame(game);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createAlien(int, int)
     */
    @Override
    public IMovable createAlien(int x, int y) {
        return new TrucResistantDecorateur(movableFactory.createAlien(x, y), true);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShip(int, int)
     */
    @Override
    public IMovable createShip(int x, int y) {
        return new TrucResistantDecorateur(movableFactory.createShip(x, y), false);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShot(int, int)
     */
    @Override
    public IMovable createShot(int x, int y) {
        return movableFactory.createShot(x, y);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShotAlien(int, int)
     */
    public IMovable createShotAlien(int x, int y) {
        return new TirAlien(game, x, y, spriteStore.getSprite("shotAlien"));
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createStrongShot(int, int)
     */
    @Override
    public IMovable createStrongShot(int x, int y) {
        return new TirPuissantDecorateur(new Tir(game, x, y, spriteStore.getSprite("strongShot")));
    }
    
    /*
     * 
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createMur(int, int)
     */
    @Override
    public IMovable createMur(int x, int y) {
        return new Mur(game, x, y, spriteStore.getSprite("bricks"));
    }
    
    /*
     * 
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createBonus(int, int)
     */
    @Override
    public IMovable createBonus(int x, int y) {
        int nb = random.nextInt(50);

        if (nb >= 40)
            return new BonusPointVie(game, x, y, spriteStore.getSprite("heart_2"), 225.00, 2);
        else
            return new BonusPointVie(game, x, y, spriteStore.getSprite("heart_1"), 175.00, 1);
    }
    
    /*
     * 
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createBomb(int, int)
     */
    @Override
    public IMovable createBomb(int x, int y) {
        return new BonusBomb(game, x, y, spriteStore.getSprite("bomb"));
    }

}

