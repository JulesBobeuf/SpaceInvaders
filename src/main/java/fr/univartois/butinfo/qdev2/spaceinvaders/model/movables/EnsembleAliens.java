/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.ArrayList;
import java.util.List;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur.VaisseauJoueur;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;

/**
 * Le type EnsembleAliens
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class EnsembleAliens implements IMovable {

    /**
     * Initialisation d'une liste d'aliens
     */
    private List<IMovable> aliens = new ArrayList<>();

    /**
     * L'attribut game...
     */
    private SpaceInvadersGame game;

    /**
     * L'attribut alien...
     */
    private IMovable alienTouche;

    /**
     * Crée une nouvelle instance de EnsembleAliens.
     * 
     * @param game
     */
    public EnsembleAliens(SpaceInvadersGame game) {
        this.game = game;
    }

    /**
     * Permet d'ajouter un alien à la liste alien
     * 
     * @param alien
     * 
     */
    public void ajouteAlien(IMovable alien) {
        aliens.add(alien);
    }

    /**
     * Permet de supprimer un alien de la liste alien
     * 
     * @param alien
     * 
     */
    public void removeAlien(IMovable alien) {
        aliens.remove(alien);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getWidth()
     */
    @Override
    public int getWidth() {
        // return (aliens.get(-1).getX()) - (aliens.get(0).getX());
        return aliens.get(0).getWidth();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getHeight()
     */
    @Override
    public int getHeight() {
        // return (aliens.get(-1).getY()) - (aliens.get(0).getY());
        return aliens.get(0).getHeight();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setX(int)
     */
    @Override
    public void setX(int xPosition) {
        for (IMovable alien : aliens)
            alien.setX(xPosition);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getX()
     */
    @Override
    public int getX() {
        return aliens.get(0).getX();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getXProperty()
     */
    @Override
    public DoubleProperty getXProperty() {
        // return aliens.get(0).getXProperty();
        return aliens.get(0).getXProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setY(int)
     */
    @Override
    public void setY(int yPosition) {
        for (IMovable alien : aliens)
            alien.setY(yPosition);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getY()
     */
    @Override
    public int getY() {
        return aliens.get(0).getY();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getYProperty()
     */
    @Override
    public DoubleProperty getYProperty() {
        // return aliens.get(0).getYProperty();
        return aliens.get(0).getYProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#consume()
     */
    @Override
    public void consume() {
        for (IMovable alien : aliens)
            alien.consume();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isConsumed()
     */
    @Override
    public boolean isConsumed() {
        for (IMovable alien : aliens)
            if (alien.isConsumed())
                return true;
        return false;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isConsumedProperty()
     */
    @Override
    public BooleanProperty isConsumedProperty() {
        return aliens.get(0).isConsumedProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setHorizontalSpeed(double)
     */
    @Override
    public void setHorizontalSpeed(double speed) {
        for (IMovable alien : aliens)
            alien.setHorizontalSpeed(speed);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getHorizontalSpeed()
     */
    @Override
    public double getHorizontalSpeed() {
        return aliens.get(0).getHorizontalSpeed();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setVerticalSpeed(double)
     */
    @Override
    public void setVerticalSpeed(double speed) {
        for (IMovable alien : aliens)
            alien.setVerticalSpeed(speed);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getVerticalSpeed()
     */
    @Override
    public double getVerticalSpeed() {
        return aliens.get(0).getVerticalSpeed();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#move(long)
     */
    @Override
    public boolean move(long timeDelta) {
        boolean inverse = false;
        for (IMovable alien : aliens) {
            if (!(alien.move(timeDelta))) {
                inverse = true;
                break;
            }
        }
        
        if (inverse) {
            setHorizontalSpeed(getHorizontalSpeed() * -1);
            return false;
        } else
            return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setSprite(fr.univartois.
     * butinfo.qdev2.spaceinvaders.view.Sprite)
     */
    @Override
    public void setSprite(Sprite sprite) {
        for (IMovable alien : aliens)
            alien.setSprite(sprite);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSprite()
     */
    @Override
    public Sprite getSprite() {
        return aliens.get(0).getSprite();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSpriteProperty()
     */
    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        return aliens.get(0).getSpriteProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#isCollidingWith(fr.
     * univartois.butinfo.qdev2.spaceinvaders.model.IMovable)
     */
    @Override
    public boolean isCollidingWith(IMovable other) {
        for (IMovable alien : aliens)
            if (alien.isCollidingWith(other)) {
                alienTouche = alien;
                return true;
            }
        return false;
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
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.Tir)
     */
    @Override
    public void collidedWith(Tir other) {
        game.alienIsDead(alienTouche);
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
        // il n'y a rien ici, et c'est normal.
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
        game.playerIsDead();
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.TirAlien)
     */
    @Override
    public void collidedWith(TirAlien other) {
        // Il n'y a rien ici, et c'est normal
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.Mur)
     */
    @Override
    public void collidedWith(Mur other) {
        // Il n'y a rien ici, et c'est normal
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#self()
     */
    @Override
    public IMovable self() {
        // Il n'y a rien ici, et c'est normal
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois
     * .butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb)
     */
    @Override
    public void collidedWith(BonusBomb other) {
        // Il n'y a rien ici, et c'est normal
    }

}
