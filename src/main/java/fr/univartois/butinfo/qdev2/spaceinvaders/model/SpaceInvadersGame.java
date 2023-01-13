/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */
package fr.univartois.butinfo.qdev2.spaceinvaders.model;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.EnsembleAliens;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.TrucResistantDecorateur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.VaisseauAlien;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements.DeplacementAlienComposite;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs.Mur;
import fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens.IAlienAttaque;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.ISpriteStore;
import fr.univartois.butinfo.qdev2.spaceinvaders.view.Sprite;
import javafx.animation.AnimationTimer;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * La classe {@link SpaceInvadersGame} permet de gérer une partie du jeu Space-Invaders.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public final class SpaceInvadersGame {

    /**
     * L'attribut nbMurs donne le nombre de bombes que le joueur transporte actuellement.
     */
    private int nbMurs;
    
    /**
     * L'attribut nbBombes donne le nombre de bombes que le joueur transporte actuellement.
     */
    private int nbBombes;
    
    /**
     * Est ce qu'un bonus peut apparaitre.
     */
    private boolean bonusCanSpawn;

    /**
     * La vitesse du vaisseau du joueur lorsqu'il se déplace (en pixels/s).
     */
    private static final double SHIP_SPEED = 150;

    /**
     * La temporisation contraignant le temps entre deux tirs successifs (en
     * millisecondes).
     */
    private static final long SHOT_TEMPORIZATION = 300;
    
    private int level;

    /**
     * La largeur sur laquelle les objets du jeu peuvent se déplacer (en pixels).
     */
    private final int width;

    /**
     * La hauteur sur laquelle les objets du jeu peuvent se déplacer (en pixels).
     */
    private final int height;

    /**
     * L'instance de {@link ISpriteStore} permettant de créer les {@link Sprite} du jeu.
     */
    private final ISpriteStore spriteStore;

    /**
     * L'instance de {@link IMovableFactory} permettant de créer les objets du jeu.
     */
    private IMovableFactory factory;

    /**
     * Le contrôleur du jeu.
     */
    private ISpaceInvadersController controller;

    /**
     * Le vaisseau du joueur.
     */
    private IMovable ship;

    /**
     * Le nombre de vies restantes pour le joueur.
     */
    private final IntegerProperty life = new SimpleIntegerProperty();

    /**
     * Le score du joueur (en nombre d'aliens éliminés).
     */
    private final IntegerProperty score = new SimpleIntegerProperty();

    /**
     * Le timestamp du dernier tir.
     * Il permet de s'assurer que le joueur ne tire pas trop souvent.
     */
    private long lastShot = 0;

    /**
     * Le nombre d'aliens encore vivants.
     */
    private int nbRemainingAliens;
   

    /**
     * 
     */
    private DeplacementAlienComposite deplacementComposite = new DeplacementAlienComposite(this);
    /**
     * La liste des objets pouvant se déplacer dans le jeu.
     */
    private final List<IMovable> movableObjects = new CopyOnWriteArrayList<>();

    /**
     * L'animation du jeu, qui s'assure que les différents objets se déplacent.
     */
    private final AnimationTimer animation = new SpaceInvadersAnimation(this, movableObjects);


    /**
     * L'attribut random pour générer des nombres pseudo-aléatoires.
     */
    private Random random = new Random();


    


    /**
     * L'attribut ensembleAliens...
     */
    private EnsembleAliens ensembleAliens;
    
    /**
     * Crée une nouvelle instance de SpaceInvadersGame.
     *
     * @param width La largeur sur laquelle les objets du jeu peuvent se déplacer (en
     *        pixels).
     * @param height La hauteur sur laquelle les objets du jeu peuvent se déplacer (en
     *        pixels).
     * @param spriteStore L'instance de {@link ISpriteStore} permettant de créer les
     *        {@link Sprite} du jeu.
     * @param factory L'instance de {@link IMovableFactory} permettant de créer les objets
     *        du jeu.
     */
    public SpaceInvadersGame(int width, int height, ISpriteStore spriteStore,
            IMovableFactory factory) {
        this.width = width;
        this.height = height;
        this.spriteStore = spriteStore;
        this.factory = factory;
        this.level=1;
    }

    /**
     * Donne la largeur sur laquelle les objets du jeu peuvent se déplacer (en pixels).
     *
     * @return La largeur du jeu.
     */
    public int getWidth() {
        return width;
    }
    
    /**
     * Donne la liste des objets movables en jeu.
     * 
     * @return La liste des movables.
     */
    public List<IMovable> getMovableObjects() {
        return movableObjects;
    }

    /**
     * Donne la limite à gauche pour la position des objets mobiles du jeu (mesurée en
     * pixels).
     *
     * @return La limite à gauche pour la position des objets mobiles du jeu.
     */
    public int getLeftLimit() {
        return 10;
    }

    /**
     * Donne la limite à droite pour la position des objets mobiles du jeu (mesurée en
     * pixels).
     *
     * @return La limite à droite pour la position des objets mobiles du jeu.
     */
    public int getRightLimit() {
        return width - 10;
    }

    /**
     * Donne la hauteur sur laquelle les objets du jeu peuvent se déplacer (en pixels).
     *
     * @return La hauteur du jeu.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Donne la limite en haut pour la position des objets mobiles du jeu (mesurée en
     * pixels).
     *
     * @return La limite en haut pour la position des objets mobiles du jeu.
     */
    public int getTopLimit() {
        return 10;
    }

    /**
     * Donne la limite en bas pour la position des objets mobiles du jeu (mesurée en
     * pixels).
     *
     * @return La limite en bas pour la position des objets mobiles du jeu.
     */
    public int getBottomLimit() {
        return height - 100;
    }

    /**
     * Associe à cette partie de Space-Invaders le contrôleur gérant l'affichage du jeu.
     *
     * @param controller Le contrôleur de l'application.
     */
    public void setController(ISpaceInvadersController controller) {
        this.controller = controller;
    }

    /**
     * Prépare une partie de Space-Invaders sur le contrôleur de l'application.
     */
    public void prepare() {
        factory.setSpriteStore(spriteStore);
        factory.setGame(this);

        controller.setSpriteStore(spriteStore);
        controller.prepare();
        controller.bindScore(score);
        controller.bindLife(life);
    }

    /**
     * Démarre cette partie de Space-Invaders.
     * Cette méthode permet également de redémarrer une nouvelle partie.
     */
    public void start() {
        initStatistics();
        createMovables();
        animation.start();
    }

    /**
     * Initialise les statistiques de cette partie.
     */
    private void initStatistics() {
        life.set(3);
        score.set(0);
        nbRemainingAliens = 0;
        nbMurs=factory.getNombreMur();
        nbBombes=factory.getNombreBomb();
        bonusCanSpawn=factory.getBonus();
    }

    /**
     * Crée les différents objets présents au début de la partie et pouvant se déplacer.
     */
  /*private void createMovables() {
        // On commence par enlever tous les éléments mobiles encore présents.
        clearAllMovables();
        
        ensembleAliens = factory.ensembleAlien();

        ship = factory.createShip(width / 2, getBottomLimit());
        TrucResistantDecorateur shipResistant = new TrucResistantDecorateur(ship, false);
        shipResistant.getVieProperty().bindBidirectional(life);
        ship = shipResistant;
        addMovable(ship);
        for (int i = 1; i <= 10; i++)
            for (int j = 0; j <= 5; j++) {
                IMovable alien = factory.createAlien(getLeftLimit() + 55 * i, getTopLimit() + 35 * j);

                addMovable(alien);                
                ensembleAliens.ajouteAlien(alien);

                nbRemainingAliens++;
            }
        movableObjects.add(ensembleAliens);
    } */   
    
  
    private void createMovables() {
        // On commence par enlever tous les éléments mobiles encore présents.
        clearAllMovables();

        ship = factory.createShip(width / 2, getBottomLimit());
        TrucResistantDecorateur shipResistant = new TrucResistantDecorateur(ship, false);
        shipResistant.getVieProperty().bindBidirectional(life);
        ship = shipResistant;
        addMovable(ship);
        for (int i = 1; i <= 10; i++)
            for (int j = 0; j <= 5; j++) {
                addMovable(factory.createAlien(getLeftLimit() + 55 * i, getTopLimit() + 35 * j));
                nbRemainingAliens++;
            }
    }


    /**
     * Choisit aléatoirement un bonus et le place dans le jeu à une position aléatoire.
     */
    public void dropBonus() {
        if (bonusCanSpawn) {
            addMovable(factory.createBonus(500, 0));
        }
    }

    /**
     * Déplace le vaisseau du joueur vers la gauche.
     */
    public void moveLeft() {
        ship.setHorizontalSpeed(-SHIP_SPEED);
    }

    /**
     * Déplace le vaisseau du joueur vers la droite.
     */
    public void moveRight() {
        ship.setHorizontalSpeed(SHIP_SPEED);
    }

    /**
     * Arrête le déplacement du vaisseau du joueur.
     */
    public void stopMoving() {
        ship.setHorizontalSpeed(0);
    }

    /**
     * Déclenche un tir depuis le vaisseau du joueur.
     * Cette méthode est sans effet si le délai entre deux tirs n'est pas atteint.
     */
    public void fireShot() {
        if (lastShot + SHOT_TEMPORIZATION < System.currentTimeMillis()) {
            if (random.nextInt(4) == 3) {
                addMovable(factory.createStrongShot(ship.getX() + 10, ship.getY() - 25));
                lastShot = System.currentTimeMillis();
            } else {
                addMovable(factory.createShot(ship.getX() + 10, ship.getY() - 25));
                lastShot = System.currentTimeMillis();
            }
        }
    }

    /**
     * Met à jour le score du joueur lorsqu'un alien est tué.
     * Si c'était le dernier, le joueur gagne la partie.
     *
     * @param alien L'alien qui a été tué.
     */
    public void alienIsDead(IMovable alien) {
        removeMovable(alien);
        nbRemainingAliens -= 1;
        score.set(score.get() + 1);
        if (nbRemainingAliens <= 0) {
            controller.gameOver("Tous les aliens sont morts, vous avez gagné !");
            this.changeFactory();
        }
    }
    
    /**
     * change the facotry
     *
     */
    public void changeFactory() {
        level++;
        switch(level) {
            case 2:
                this.setFactory(new MovableFactory2()); 
                break;
            case 3:
                this.setFactory(new MovableFactory3()); 
                break;
            default:
                this.setFactory(new MovableFactory4()); 
                break;
        }
    }

    /**
     * Réduit la vie du joueur, et interrompt la partie si elle atteint 0.
     */
    public void reducePlayerLife() {
        life.set(life.get() - 1);
        if (life.get() <= 0) {
            playerIsDead();
        }
    }

    /**
     * Ajoute nb points de vie au joueur
     * @param nb le nombre de pv à ajouter
     * 
     */
    public void addPlayerLife(int nb) {
        life.set(life.get() + nb);
    }

    /**
     * Termine la partie lorsque le joueur est tué.
     */
    public void playerIsDead() {
        animation.stop();
        controller.gameOver("Vous êtes mort");
    }

    /**
     * Termine la partie lorsque les aliens atteignent la planète.
     */
    public void alienReachedPlanet() {
        animation.stop();
        controller.gameOver("Les aliens vous ont envahis");
    }

    /**
     * Ajoute un objet pouvant se déplacer dans le jeu.
     *
     * @param object L'objet à ajouter.
     */
    private void addMovable(IMovable object) {
        movableObjects.add(object);
        controller.addMovable(object);
    }

    /**
     * Supprime un objet pouvant se déplacer dans le jeu.
     *
     * @param object L'objet à supprimer.
     */
    public void removeMovable(IMovable object) {
        movableObjects.remove(object);
        object.consume();
    }

    /**
     * Supprime tous les objets pouvant se déplacer dans le jeu.
     */
    private void clearAllMovables() {
        for (IMovable movable : movableObjects) {
            movable.consume();
        }
        movableObjects.clear();
    }

    /**
     * Déclenche un tir depuis le vaisseau d'un alien.
     * 
     * @param alien L'alien qui tire.
     */
    public void fireShotAlien(IMovable alien) {
            addMovable(factory.createShotAlien(alien.getSprite().getWidth()/2+alien.getX(), alien.getY()+35));
    }

    /**
     * @return Le vaisseau joueur.
     */
    public IMovable getShip() {
        return ship;
    }
    
    /**
     * Donne l'attribut life de cette instance de SpaceInvadersGame.
     *
     * @return L'attribut life de cette instance de SpaceInvadersGame.
     */
    public int getLife() {
        return life.get();
    }
    

    
    /**
     * @param alien Le vaisseau alien qui doit changer de déplacement.
     */
    public void changeDeplacementAlien(VaisseauAlien alien) {
        alien.setDeplacement(deplacementComposite.getDeplacement());
    }
 

    /**
     * Place un mur en face du vaisseau joueur.
     */
    public void placeMur() {
        if (nbMurs>0) {
            addMovable(factory.createMur(ship.getX(),ship.getY()-100));  
            nbMurs--;
        }
    }
    
    /**
     * @param mur Change le sprite du mur, pour le suivant.
     */
    public void changeMurSprite(Mur mur) {
        mur.setSprite(spriteStore.getSprite(mur.getState().getSpriteName()));
    }
    
    /**
     * @return Le nombre d'aliens encore vivants
     */
    public int getNbRemainingAliens() {
        return nbRemainingAliens;
    }
    
    /**
     * Jette une bombe en face du joueur
     */
    public void throwBomb() {
        if (nbBombes>0) {
            addMovable(factory.createBomb(ship.getX(),ship.getY()-50));  
            nbBombes--;
        }
    }
    
    public void setFactory(IMovableFactory f) {
        this.factory=f;
        factory.setSpriteStore(spriteStore);
        factory.setGame(this);
        start();
    }
}
