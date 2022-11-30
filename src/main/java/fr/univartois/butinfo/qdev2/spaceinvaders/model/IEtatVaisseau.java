/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model;


/**
 * Le type IEtatVaisseau
 *
 * @author pierre.schreiner
 *
 * @version 0.1.0
 */
public interface IEtatVaisseau {
    void handle();
    IEtatVaisseau nextStateAfterShot();
    IEtatVaisseau nextStateAfterTime();
}

