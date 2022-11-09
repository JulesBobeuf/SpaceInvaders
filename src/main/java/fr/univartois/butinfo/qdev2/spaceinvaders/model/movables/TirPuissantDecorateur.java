/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.IMovable;

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
}

