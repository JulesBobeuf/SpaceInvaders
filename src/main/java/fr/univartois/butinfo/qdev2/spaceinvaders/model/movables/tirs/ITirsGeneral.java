package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.IAlienAttaque;

/**
 * @author thomas
 *
 */
public interface ITirsGeneral {
    
    /**
     * @return Fait tirer tous les aliens qui utilisent le tir correspondant.
     */
    IAlienAttaque tir();
}