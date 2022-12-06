/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.AbstractMovableDecorateur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.TirAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.beans.property.ObjectProperty;

/**
 * Le type TirPuissantDecorateur
 *
 * @author Jules
 *
 * @version 0.1.0
 */
public class TirPuissantDecorateur extends AbstractMovableDecorateur {
     /**
      * attribut décomptant le nombre d'alien que le tir puissant touche.
      */
    int count;
    /**
     * Crée une nouvelle instance de TirPuissantDecorateur.
     * @param movable
     */
    public TirPuissantDecorateur(IMovable movable) {
        super(movable);
        this.count=3;
    }
    
    @Override
    public void collidedWith(IMovable v) {
        if (this.count>1) {
            v.collidedWith((Tir)this.movable);
            count-=1;
        }
        else {
            this.movable.collidedWith(v);
        }
     }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#setSprite(fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite)
     */
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
        this.movable.collidedWith(other);
        
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.Mur)
     */
    @Override
    public void collidedWith(Mur other) {
        // TODO Auto-generated method stub.
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable#collidedWith(fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus.BonusBomb)
     */
    @Override
    public void collidedWith(BonusBomb other) {
        //Il ne se passe rien ici et c'est normal (les tirs puissant résistent les explosions de bombes 
        //grace à leur technologie avancé.
        
    }
}

