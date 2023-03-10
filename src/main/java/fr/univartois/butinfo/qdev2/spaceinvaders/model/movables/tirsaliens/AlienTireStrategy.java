/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 thomas
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens;

import java.util.Random;

/**
 * Le type AlienTireStrategy
 *
 * @author thomas
 *
 * @version 0.1.0
 */
public class AlienTireStrategy implements IAlienAttaque {
    
    /**
     * 
     */
    Random random = new Random();
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IAlienAttaque#tir()
     */
    @Override
    public boolean tir() {
        int x = random.nextInt(1,500);
        return x==69;
    }
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.IAlienAttaque#newStrategy()
     */
    @Override
    public IAlienAttaque newStrategy() {
        //cette méthode ne sera jamais appelé.
        return null;
    }

}

