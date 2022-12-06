/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TrucResistantDecorateur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusPointVie;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementDiagonale;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementNormal;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementVertical;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.TirPuissantDecorateur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.AlienTireIntelligent;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.AlienTirePasStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.AlienTireStrategy;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur.VaisseauJoueur;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;

/**
 * Le type MovableFactory
 *
 * @author pierre.schreiner
 *
 * @version 0.1.0
 */
public class MovableFactory implements IMovableFactory {

    /**
     * 
     */
    private ISpriteStore spriteStore;
    /**
     * 
     */
    private Random random = new Random();

    /**
     * 
     */
    private SpaceInvadersGame game;

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setSpriteStore(fr.
     * univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore)
     */
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#setGame(fr.
     * univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame)
     */
    @Override
    public void setGame(SpaceInvadersGame game) {
        this.game = game;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createAlien(int,
     * int)
     */
    @Override
    public IMovable createAlien(int x, int y) {
        String alienSprite = "alien";

        int nb = random.nextInt(21);
        if (nb <= 10) {
            if (random.nextBoolean()) {
                return new VaisseauAlien(game, x, y, spriteStore.getSprite(alienSprite),
                        new DeplacementNormal(), new AlienTireStrategy());
            } else {
                return new TrucResistantDecorateur(new VaisseauAlien(game, x, y, spriteStore.getSprite("strongAlien"), new DeplacementNormal(),new AlienTirePasStrategy()), true); // le true indique au décorateur que l'objet est un alien
            }
        } else if (10 < nb && nb < 15) {
            return new VaisseauAlien(game, x, y, spriteStore.getSprite("ufo"),
                    new DeplacementVertical(), new AlienTireIntelligent(game));
        } else {
            return new VaisseauAlien(game, x, y, spriteStore.getSprite(alienSprite),
                    new DeplacementDiagonale(), new AlienTirePasStrategy());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShip(int,
     * int)
     */
    @Override
    public IMovable createShip(int x, int y) {
        return new VaisseauJoueur(game, x, y, spriteStore.getSprite("ship"));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShot(int,
     * int)
     */
    @Override
    public IMovable createShot(int x, int y) {
        return new Tir(game, x, y, spriteStore.getSprite("shot"));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createShotAlien(
     * int, int)
     */
    public IMovable createShotAlien(int x, int y) {
        return new TirAlien(game, x, y, spriteStore.getSprite("shotAlien"));
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovableFactory#createStrongShot(
     * int, int)
     */
    @Override
    public IMovable createStrongShot(int x, int y) {
        return new TirPuissantDecorateur(new Tir(game, x, y, spriteStore.getSprite("strongShot")));
    }
    
    @Override
    public IMovable createMur(int x, int y) {
        return new Mur(game, x, y, spriteStore.getSprite("bricks"));
    }

    @Override
    public IMovable createBonus(int x, int y) {
        int nb = random.nextInt(101);

        if (nb >= 90)
            return new BonusPointVie(game, x, y, spriteStore.getSprite("heart_2"), 225.00, 2);
        else
            return new BonusPointVie(game, x, y, spriteStore.getSprite("heart_1"), 175.00, 1);
    }
    
    @Override
    public IMovable createBomb(int x, int y) {
        return new BonusBomb(game, x, y, spriteStore.getSprite("bomb"));
    }

}
