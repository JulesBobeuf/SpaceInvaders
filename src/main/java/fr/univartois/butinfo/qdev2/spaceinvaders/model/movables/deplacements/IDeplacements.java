/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 aymeric.jakobowski
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements;

/**
 * Le type IDeplacements
 *
 * @author aymeric.jakobowski
 *
 * @version 0.1.0
 */
public interface IDeplacements {

    /**
     * @param delta long : le temps depuis le dernier move()
     * @return vitesse horizontale
     */
    double getHorizontalSpeed(long delta);

    /**
     * @param delta long : le temps depuis le dernier move()
     * @return vitesse verticale
     */
    double getVerticalSpeed(long delta);
}
