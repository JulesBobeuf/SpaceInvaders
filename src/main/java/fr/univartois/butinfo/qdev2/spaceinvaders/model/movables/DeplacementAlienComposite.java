package fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;

import java.util.ArrayList;
import java.util.Random;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.SpaceInvadersGame;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementDiagonale;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementNormal;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementVertical;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.IDeplacements;

/**
 * @author thomas
 *
 */
public class DeplacementAlienComposite implements IAlienDeplacementComposite{
    /**
     * 
     */
    private ArrayList<IDeplacements> deplacements;

    
    /**
     * 
     */
    Random random = new Random();
    
    /**
     * 
     */
    private int index;
    
    
    
    /**
     * @param game
     */
    public DeplacementAlienComposite(SpaceInvadersGame game) {
        deplacements = new ArrayList<>();
        deplacements.add(new DeplacementDiagonale());
        deplacements.add(new DeplacementNormal());
        deplacements.add(new DeplacementVertical());
        index = random.nextInt(1,4);
    }

  
    /**
     * @return
     */
    public IDeplacements getDeplacement() {
        int x = random.nextInt(0,deplacements.size());
        return deplacements.get(x);
    }
}
