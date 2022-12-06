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
    
    /**
     * L'attribut temps qui compte le temps entre chaque changement de vitesse.
     */
    private long temps = 0;
    
    /**
     * L'attribut vitesse donne la vitesse verticale.
     */
    private double vitesse = 10;
    
    /**
     * L'attribut isFast qui donne si le vaisseau se déplace vite ou non (pour alterner).
     */
    boolean isFast = true;
    
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
            if (isFast) {
                vitesse = 10;
            } else {
                vitesse = 45;
            }
            isFast = !isFast;
            temps = 0;
        }
        return vitesse;
    }
 
}

