/**
 * Ce fichier fait partie du projet projet-2022-2023-b-1.
 *
 * (c) 2022 Jules
 * Tous droits réservés.
 */

package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs;


/**
 * Le type IStateMur
 *
 * @author Jules
 *
 * @version 0.1.0
 */
public interface IStateMur {

    /**
     * @return IStateMur le prochain état du mur après prise de dégat.
     */
    public IStateMur getNextState();
    
    /**
     * @return String le nom du sprite actuel.
     */
    public String getSpriteName();
    
    
}

