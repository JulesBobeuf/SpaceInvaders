package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.IDeplacements;

/**
 * @author thomas
 *
 */
public interface IAlienDeplacementComposite {
    /**
     * @return
     */
    public IDeplacements getDeplacement();
}
