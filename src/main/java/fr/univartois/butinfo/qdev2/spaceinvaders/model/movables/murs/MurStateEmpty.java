/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs;

/**
 * Le type MurStateEmpty
 *
 * @author Jules
 *
 * @version 0.1.0
 */
public class MurStateEmpty implements IStateMur {

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IStateMur#getNextState()
     */
    @Override
    public IStateMur getNextState() {
        return new MurStateBroken();
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IStateMur#getSpriteName()
     */
    @Override
    public String getSpriteName() {
        return "empty-bricks";
    }

}

