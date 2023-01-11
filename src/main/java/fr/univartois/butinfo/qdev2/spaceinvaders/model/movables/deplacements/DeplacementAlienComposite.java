package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements;

import java.util.ArrayList;
import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;

/**
 * @author thomas
 *
 */
public class DeplacementAlienComposite implements IAlienDeplacementComposite{
    
    /**
     * L'attribut deplacements est une liste qui contient tous les types de déplacement possibles pour les aliens.
     */
    private ArrayList<IDeplacements> deplacements;
    
    /**
     * Un attribut random qu'on peut
     */
    Random random = new Random();
    
    /**
     * Crée une nouvelle instance de DeplacementAlienComposite.
     * 
     * @param game Une référencec au jeu SpaceInvadersGame.
     */
    public DeplacementAlienComposite(SpaceInvadersGame game) {
        deplacements = new ArrayList<>();
        deplacements.add(new DeplacementDiagonale());
        deplacements.add(new DeplacementNormal());
        deplacements.add(new DeplacementVertical());
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.IAlienDeplacementComposite#getDeplacement()
     */
    @Override
    public IDeplacements getDeplacement() {
        int x = random.nextInt(0,deplacements.size());
        return deplacements.get(x);
    }
}
