/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.Random;

/**
 * Le type DeplacementVertical
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public class DeplacementVertical implements IDeplacements {
    private Random random = new Random();
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
            //nb = random.nextDouble(20.00, 70.00);
            nb = (depVert ? 10.00 : 45.00);
            depVert = (depVert ? false : true);
            temps = 0;
        }
        return nb;
    }
 
}

