/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
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

    private IntegerProperty vie = new SimpleIntegerProperty();
    
    /**
     * Crée une nouvelle instance de AlienResistantDecorateur.
     * @param movable
     */
    public TrucResistantDecorateur(IMovable movable) {
        super(movable);
        vie.set(3);
    }
    
    @Override
    public void collidedWith(Tir other) {
        vie.set(vie.get()-1);
        if (vie.get() == 0)
            movable.collidedWith(other);
    }
    
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

}

