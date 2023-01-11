/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 pierre.schreiner
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur;


/**
 * Le type IEtatVaisseau
 *
 * @author pierre.schreiner
 *
 * @version 0.1.0
 */
public interface IEtatVaisseau {
    
    /**
     * Réalise une séquence d'action qui dépend de l'état actuel.
     */
    void handle();
    /**
     * @return IEtatVaisseau le prochain état du vaisseau après qu'il ait pris un tir
     */
    IEtatVaisseau nextStateAfterShot();
    
    /**
     * @return IEtatVaisseau le prochain état du vaisseau après un certain délai
     */
    IEtatVaisseau nextStateAfterTime();
}

