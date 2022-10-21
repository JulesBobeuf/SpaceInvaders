/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;


/**
 * Le type DeplacementNormal
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class DeplacementNormal implements IDeplacements {

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IDeplacements#getHorizontalSpeed()
     */
    @Override
    public double getHorizontalSpeed() {
        return 75.00;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IDeplacements#getVerticalSpeed()
     */
    @Override
    public double getVerticalSpeed() {
        return 5.00;
    }

}

