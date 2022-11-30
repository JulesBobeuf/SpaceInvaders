/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs.Tir;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Le type AlienResistantDecorateur
 *
 * @author pierre.schreiner
 *
 * @version 0.1.0
 */
public class TrucResistantDecorateur extends AbstractMovableDecorateur {

    /**
     * L'attribut vie qui compte les points de vie restants de l'objet décoré.
     */
    private IntegerProperty vie = new SimpleIntegerProperty();
    
    /**
     * L'attribut isAlien qui indique si l'objet décoré est un alien.
     */
    private boolean isAlien;
    
    /**
     * Crée une nouvelle instance de AlienResistantDecorateur.
     * @param movable IMovable : l'objet décoré
     * @param isAlien boolean : si le movable est un alien
     */
    public TrucResistantDecorateur(IMovable movable, boolean isAlien) {
        super(movable);
        this.isAlien = isAlien;
        vie.set(3);
    }
    
    @Override
    public void collidedWith(Tir other) {
        if (isAlien) {
            vie.set(vie.get()-1);
            if (vie.get() == 0)
                movable.collidedWith(other);
        }
    }
    
    /**
     * @return IntegerProperty : la propriété de la vie
     */
    public IntegerProperty getVieProperty() {
        return vie;
    }
    
    @Override
    public void setSprite(Sprite sprite) {
        this.movable.setSprite(sprite);
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#getSpriteProperty()
     */
    @Override
    public ObjectProperty<Sprite> getSpriteProperty() {
        return this.movable.getSpriteProperty();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#self()
     */
    @Override
    public IMovable self() {
        return this.movable;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TirAlien)
     */
    @Override
    public void collidedWith(TirAlien other) {
        if (!isAlien)
            this.movable.collidedWith(other);        
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

}

