package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements;

/**
 * @author thomas
 *
 */
public interface IAlienDeplacementComposite {
    /**
     * @return IDeplacements L'un des déplacements possibles.
     */
    public IDeplacements getDeplacement();
}
