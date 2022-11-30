/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements;

/**
 * Le type DeplacementVertical
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class DeplacementVertical implements IDeplacements {
    private long temps = 0;
    private double nb = 10;
    boolean depVert = true;
    
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IDeplacements#getHorizontalSpeed()
     */
    @Override
    public double getHorizontalSpeed(long delta) {
        return 0;
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.IDeplacements#getVerticalSpeed()
     */
    @Override
    public double getVerticalSpeed(long delta) {
        temps += delta;
        if (temps >= 1_000) {
            if (depVert) {
                nb = 10;
            } else {
                nb = 45;
            }
            depVert = !depVert;
            temps = 0;
        }
        return nb;
    }
 
}

